package metaheuristic_algorithms;

import java.util.ArrayList;

import graph.Graph;
import graph.Vertex;

public class TabuSearch {

	//Lista que guarda as soluções
	ArrayList <ArrayList<Vertex>> tabuList;
	// Lista de vertices do grafo
	ArrayList<Vertex> vertexes;
	
	
	
	public ArrayList<Vertex> initialSolution() {
		
		// atribui uma cor a cada vertice
		
		return vertexes;
	}
	
	public boolean stopCriteria() {
		
		// para apos 10 solucoes sem diminuir numero de conflitos
		
		return true;
	}
	
	
	public ArrayList<ArrayList<Vertex>> getNeighbors( ArrayList<Vertex> bestCandidate ){
		
		// percorre n/2
			// escolhe aleatoriamente um vertice
			// calcula conflitos
			// recupera solucao com menos conflitos (treemap)
		
		return null;
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
	private float calculateFitness(ArrayList<Vertex> candidate) {
		
		// percorre vertices da solucao candidata
			// percorre os adjacentes de v
				// calcula numero de vertices adjacentes que tem mesma cor de v
		
		return 0;
	}
}
