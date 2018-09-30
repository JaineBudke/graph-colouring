package view;

import manager.Engine;
import exact_algorithms.BrownDsaturAlgorithm;
import exact_algorithms.Brown_algorithm;
import exact_algorithms.ZykovAlgorithm;
import graph.Graph;


public class Main {

	public static void main(String[] args) {
	
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		ZykovAlgorithm zykov = new ZykovAlgorithm();
		BrownDsaturAlgorithm dsatur = new BrownDsaturAlgorithm();
		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel3.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		//int k = zykov.executeZykov(graph);
		//System.out.println("Número cromático do grafo: "+k);
		
		
		
		
	}

}
