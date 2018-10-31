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
		
		Vertex v0 = new Vertex("v8");
		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		Vertex v4 = new Vertex("v4");
		Vertex v5 = new Vertex("v5");
		Vertex v6 = new Vertex("v6");
		Vertex v7 = new Vertex("v7");
		Graph graph = new Graph();
		graph.addVertex(v0);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		graph.addVertex(v6);
		graph.addVertex(v7);
		graph.addEdge(v0, v1);
		graph.addEdge(v0, v3);
		graph.addEdge(v0, v2);
		graph.addEdge(v3, v2);
		graph.addEdge(v5, v2);
		graph.addEdge(v3, v4);
		graph.addEdge(v4, v6);
		graph.addEdge(v7, v5);
		graph.addEdge(v6, v5);
		graph.addEdge(v7, v6);
		
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
