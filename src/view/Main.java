package view;

import manager.Engine;
import exact_algorithms.Brown_algorithm;
import exact_algorithms.ZykovAlgorithm;
import graph.Graph;
import graph.Vertex;


public class Main {

	public static void main(String[] args) {
	
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		ZykovAlgorithm zykov = new ZykovAlgorithm();
		
		// lê arquivo com o índice indicado
		//engine.readArchivebyFilename("myciel3.col");
		// cria o grafo
		//Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		
		// Cria grafo
		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		Vertex v4 = new Vertex("v4");
		Graph graph = new Graph();
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addEdge(v1, v2);
		graph.addEdge(v2, v3);
		graph.addEdge(v3, v4);
		
		int k = zykov.executeZykov(graph);
		System.out.println("Número cromático do grafo: "+k);
		
		System.out.println("Coloração obtida: ");
		for( int i=0; i<zykov.bestColouring.size(); i++ ){
			
			System.out.println("COR "+(i+1));
			
			System.out.println(zykov.bestColouring.get(i).getLabel());
			for( int j=0; j<zykov.bestColouring.get(i).getMergedVertexes().size(); j++ ){
				
				System.out.println(zykov.bestColouring.get(i).getMergedVertexes().get(j).getLabel());
				
			}
			
		}
		
		
	}

}
