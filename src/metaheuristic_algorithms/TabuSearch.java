package metaheuristic_algorithms;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class TabuSearch {

	// Lista que guarda as soluções
	ArrayList <ArrayList<Vertex>> tabuList;
	// Lista de vertices do grafo
	ArrayList<Vertex> vertexes;
	// conflito melhor candidato
	int conflict = 0;
	// armazena conflitos das ultimas 10 iterações
	ArrayList<Integer> conflicts = new ArrayList<>();
	
	/**
	 * Gera uma coloração inicial
	 * @return
	 */
	public ArrayList<Vertex> initialSolution() {
		
		// atribui uma cor a cada vertice
		for( int i=0; i<vertexes.size(); i++ ){
			vertexes.get(i).setColor(i+"");
		}
		
		return vertexes;
	}
	
	/**
	 * Checa se o calgoritmo deve continuar a execução
	 * @return Verdadeiro se existem menos de 10 iterações sem 
	 * melhorar a solução, falso caso contrário
	 */
	public boolean stopCriteria() {
		
		if( conflicts.size() < 10 ){
			return true;
		}
		
		int prevConflict = conflicts.get(0);
		
		// para apos 10 solucoes sem diminuir numero de conflitos
		for( int i=1; i<10; i++ ){
			if( conflicts.get(i) == prevConflict ){
				return false;
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Calcula os conflitos que podem ser gerados 
	 * ao trocar a cor de um vértice.
	 * @param v Vértice analisado
	 * @return
	 */
	public int calculateConflicts( Vertex v ){
		
		// map com soluções
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		// recupera adjacentes de v
		ArrayList<Edge> adjacents = v.getAdjacentVertexes();
		
		
		
		for( int i=0; i<adjacents.size(); i++ ){
			Vertex vAdj = adjacents.get(i).getVertex(v);
			
			// verifica qual a cor de vAdj
			int color = Integer.parseInt(vAdj.getColor());
			
			// se já tiver chave com essa cor no map, +1 ao valor do map[key]
			if( map.containsKey(color) ) {
				int value = map.get(color);
				value += 1;
				map.put(color, value);
			} 
			// se não tiver, adiciona chave no map
			else {
				map.put(color, 1);
			}
			
		}
		
		// recupera do treemap cor com menor valor
		return map.values().stream().min(Integer::compare).get();
		
	}
	
	/**
	 * Gera a vizinhança de uma solução
	 * @param bestCandidate Solução para a qual é gerada a vizinhança
	 * @return Lista de soluções vizinhas
	 */
	public ArrayList<ArrayList<Vertex>> getNeighbors( ArrayList<Vertex> bestCandidate ){
		
		ArrayList<ArrayList<Vertex>> neighbors = new ArrayList<>(); 
		
		ArrayList<Vertex> candidate = new ArrayList<>();
		for( Vertex v : bestCandidate) {
			candidate.add(v);
		}
		Random rand = new Random();
		
		// percorre n/2
		for( int i=0; i<(bestCandidate.size()); i++ ){
			
			// escolhe aleatoriamente um vertice
			int n = rand.nextInt( vertexes.size());
			Vertex v = candidate.get(i);
			
				
			
			// calcula conflitos
			int color = calculateConflicts( v );	
			v.setColor(color+"");
			
			
			// gera solucao com a nova cor do v
			ArrayList<Vertex> solution = new ArrayList<>();
			for( Vertex v1 : bestCandidate) {
				solution.add(v1);
			}
			neighbors.add(solution);
			
			//Reseta o grafo
			candidate.clear();
			for( Vertex v1 : bestCandidate) {
				candidate.add(v1);
			}
		}
		
		return neighbors;
	}
	

	/**
	 * Calcula aptidão de uma solução
	 * @param candidate
	 * @return
	 */
	private int calculateFitness(ArrayList<Vertex> candidate) {
		
		int quantColor = 0;
		
		// percorre vertices da solucao candidata
		for( int i=0; i<candidate.size(); i++ ){
			// percorre os adjacentes de v
			ArrayList<Edge> adjacents = candidate.get(i).getAdjacentVertexes();
			for( int j=0; j<adjacents.size(); j++ ){
				
				// calcula numero de vertices adjacentes que tem mesma cor de v
				// recupera adjacente
				Vertex adj = adjacents.get(j).getVertex(candidate.get(i));
				if( adj.getColor().equals( candidate.get(i).getColor() ) ){
					quantColor++;
				}
				
			}
	
		}
			
		return quantColor;
	}
	
	
	/*
	 * Executa a busca tabu
	 */
	public ArrayList<Vertex> execute(Graph g) {
		
		//Inicialização 
		//Uma solução será uma lista de vértices coloridos

		vertexes = g.getVertexes();
		ArrayList<Vertex> s0 = initialSolution();
		ArrayList<Vertex> bestSolution = s0;
		ArrayList<Vertex> bestCandidate = s0;
		tabuList = new ArrayList<ArrayList<Vertex>>();
		tabuList.add(s0);

		
		
	
		
		while( stopCriteria() ) {
			
			ArrayList<ArrayList<Vertex>> neighborhood = getNeighbors(bestCandidate);
			for( ArrayList<Vertex> candidate :  neighborhood) {
				// Search the best solution in the neighborhood
				if( !tabuList.contains(candidate)) {
					float fitnessCandidate = calculateFitness(candidate);
					float fitnessBestCandidate = calculateFitness(bestCandidate);
					if(fitnessCandidate > fitnessBestCandidate) {
						//update the best candidate
						bestCandidate = candidate;
						
					}
				}
			}
			
			// Check if the best neighbor is the best solution so far
			if(calculateFitness(bestCandidate) > calculateFitness(bestSolution)) {
				bestSolution = bestCandidate;
				// salva numero de conflitos de melhor candidato
				conflict = calculateFitness(bestCandidate);
				// adiciona conflito na lista de conflitos
				conflicts.add(conflict);
				// se já tiver cheia, remove primeiro
				if( conflicts.size() > 10 ) {
					conflicts.remove(0);
				}
			}
			
			// Keep the best candidate at the tabu list
			tabuList.add(bestCandidate);
			
			if(tabuList.size() > 0.2 *(vertexes.size())) {
				tabuList.remove(0);
			}
			
			//System.out.println(bestSolution);

			ArrayList<Integer> colors = new ArrayList<>();
			int numColors = 0;
			for( int k=0; k<bestSolution.size(); k++ ){
				System.out.print(bestSolution.get(k).getLabel() +"  ");
				System.out.println(bestSolution.get(k).getColor());
				int color = Integer.parseInt(bestSolution.get(k).getColor());
				// se a lista contem a cor, nao faz nada, senao adiciona e contabiliza mais uma cor
				if( !(colors.contains(color)) ) {
					colors.add(color);
					numColors++;
				}
			}
			
			
			System.out.println();
			System.out.println(numColors);
			
			return bestSolution;
			
		}
		
		
		
		return bestCandidate;
		
		
		
		
	}

}
