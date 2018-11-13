package metaheuristic_algorithms;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class TabuSearch {

	//Lista que guarda as soluções
	ArrayList <ArrayList<Vertex>> tabuList;
	// Lista de vertices do grafo
	ArrayList<Vertex> vertexes;
	
	
	
	public ArrayList<Vertex> initialSolution() {
		
		// atribui uma cor a cada vertice
		for( int i=0; i<vertexes.size(); i++ ){
			vertexes.get(i).setColor(i+"");
		}
		
		
		return vertexes;
	}
	
	public boolean stopCriteria() {
		
		// para apos 10 solucoes sem diminuir numero de conflitos
		
		
		return true;
	}
	
	
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
				map.put(color, 0);
			}
			
		}
		
		// recupera do treemap cor com menor valor
		return map.firstKey();
		
	}
	
	public ArrayList<ArrayList<Vertex>> getNeighbors( ArrayList<Vertex> bestCandidate ){
		
		ArrayList<ArrayList<Vertex>> neighbors = new ArrayList<>(); 
		
		// percorre n/2
		for( int i=0; i<(vertexes.size())/2; i++ ){
			
			// escolhe aleatoriamente um vertice
			Random rand = new Random();
			int n = rand.nextInt( vertexes.size());
			Vertex v = vertexes.get(n);
			
			// calcula conflitos
			int color = calculateConflicts( v );	
			v.setColor(color+"");
			
			// gera solucao com a nova cor do v
			ArrayList<Vertex> candidate = (ArrayList<Vertex>) vertexes.clone();
			
			neighbors.add(candidate);
			
		}
		
		return neighbors;
	}
	
	
	
	/*
	 * Executa a busca tabu
	 */
	public ArrayList<Vertex> execute(Graph g) {
		
		//Inicialização 
		//Uma solução será uma lista de vértices coloridos
		ArrayList<Vertex> vertexes = g.cloneVertexes();
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
			}
			
			// Keep the best candidate at the tabu list
			tabuList.add(bestCandidate);
			
			if(tabuList.size() > 0.2 *(vertexes.size())) {
				tabuList.remove(0);
			}
			
			return bestSolution;
			
		}
		return bestCandidate;
		
		
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
}
