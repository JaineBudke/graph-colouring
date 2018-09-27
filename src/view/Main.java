package view;

import manager.Engine;
import exact_algorithms.Brown_algorithm;
import graph.Graph;


public class Main {

	public static void main(String[] args) {
	
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		int ctIndex = 1;
		
		// lê arquivo com o índice indicado
		engine.readArchive(ctIndex);
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = brown.executeBrown(graph);
		System.out.println("Número cromático do grafo: "+k);
		
	}

}
