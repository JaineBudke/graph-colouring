package view;

import manager.Engine;
import metaheuristic_algorithms.AntColony;

import java.util.ArrayList;

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
		
		
		AntColony ant = new AntColony();
		ArrayList<ArrayList<Vertex>> C = ant.execute(graph);
		
		for( int i=0; i<C.size(); i++ ){
			
			System.out.println("ANT "+i);
			
			for( int j=0; j<C.get(i).size(); j++ ){
				System.out.print(C.get(i).get(j).getLabel()+"  :  ");
				System.out.println(C.get(i).get(j).getColor());
				
			}
			
		}
		
	}

}
