package metaheuristic_algorithms;

import java.util.ArrayList;

import graph.Graph;
import graph.Vertex;

public class TabuSearch {

	//Lista que guarda as soluções
	ArrayList <ArrayList<Vertex>> tabuList;
	
	
	
	
	/*
	 * Executa a busca tabu
	 */
	public ArrayList<Vertex> execute(Graph g) {
		
		//Inicialização 
		//Uma solução será uma lista de vértices coloridos
		ArrayList<Vertex> vertexes = g.cloneVertexes();
		ArrayList<Vertex> s0 = initialSolution(vertexes);
		ArrayList<Vertex> bestSolution = s0;
		ArrayList<Vertex> bestCandidate = s0;
		tabuList = new ArrayList<ArrayList<Vertex>>();
		tabuList.add(s0);
		
		while( /*stop criteria*/) {
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
			}
			
			// Keep the best candidate at the tabu list
			tabuList.add(bestCandidate);
			
			if(tabuList.size() > 0.2 *(vertexes.size())) {
				tabuList.remove(0);
			}
			
			return bestSolution;
			
		}
		
		
	}

	/**
	 * Calcula aptidão de uma solução
	 * @param candidate
	 * @return
	 */
	private float calculateFitness(ArrayList<Vertex> candidate) {
		// TODO Auto-generated method stub
		return 0;
	}
}
