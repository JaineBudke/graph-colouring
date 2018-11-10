package metaheuristic_algorithms;

public class TabuSearch {

	
	
	public void execute() {
		
		//Inicialização 
		// bestSolution = solução inicial
		// bestCandidate = solução inicial
		// tabuList = new ArrayList<>();
		// tabuList.add(solução inicial);
		
		while( /*stop criteria*/) {
			//neighborhood = getNeighbors(bestCandidate);
			for( candidate : neighborhood) {
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
			
			if(tabuList.size() > 0.2 *(vertex.size())) {
				tabuList.remove(0);
			}
			
			return bestSolution;
			
		}
		
		
	}
}
