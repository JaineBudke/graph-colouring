package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exact_algorithms.BrownDsaturAlgorithm;
import exact_algorithms.ZykovAlgorithm;
import graph.Graph;
import graph.Vertex;
import manager.Engine;

public class BrownDsaturTest {
	
	@Test
	public void a() {
		Engine engine = new Engine( );
		BrownDsaturAlgorithm brown = new BrownDsaturAlgorithm();
		
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
		
		
		// executa algoritmo de coloração
		int k = brown.dsatur(graph);
		assertEquals(true, k >= 2);
	}
	
	
}
