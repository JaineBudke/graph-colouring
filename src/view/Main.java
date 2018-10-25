package view;

import manager.Engine;
import metaheuristic_algorithms.AntColony;

import java.util.ArrayList;
import java.util.Map;

import exact_algorithms.Brown_algorithm;
import exact_algorithms.ZykovAlgorithm;
import graph.Edge;
import graph.Graph;
import graph.Vertex;


public class Main {

	public static void main(String[] args) {
	
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		ZykovAlgorithm zykov = new ZykovAlgorithm();
		
		/*// Cria grafo
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
		graph.addEdge(v3, v4);*/
		
		

		engine.readArchivebyFilename("DSJC500.5.col");
		Graph graph = engine.createGraph();
		
		AntColony ant = new AntColony();
		Map<Integer, ArrayList<Vertex>> result = ant.execute(graph);
		


		// imprime numero de cores
		ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
		for (Integer key : result.keySet()) {

			System.out.println("Número de cores: "+key);	
			vertexes = result.get(key);
			
		}
		
		// imprime vertices com as cores
		for( int i=0; i<vertexes.size(); i++ ){
			
			System.out.print(vertexes.get(i).getLabel()+"  :  ");
			System.out.println(vertexes.get(i).getColor());
			
		}
		
		
	}

}
