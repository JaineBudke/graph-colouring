package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import graph.Edge;

import graph.Graph;
import graph.Vertex;

public class GraphTest {

	@Test
	public void test() {
		Graph graph = new Graph();
		
		//cria vertices
		for( int i = 0; i< 10; i++) {
			Vertex v = new Vertex("v"+i);
			v.setColor(1+"");
			graph.addVertex(v);
		}
		ArrayList<Vertex> vertexes = graph.getVertexes();
		
		assertEquals(true, graph.hasValidColoring());
		
		Edge e1 = new Edge(vertexes.get(0), vertexes.get(1));
		graph.addEdge(e1);
		vertexes.get(0).addAdjacent(e1);
		vertexes.get(1).addAdjacent(e1);
		
		
		assertEquals(false, graph.hasValidColoring());
		
		// Testa grafo completo com cores diferentes
		graph.getEdges().clear();
		for(int i = 0; i < graph.getVertexes().size(); i++) {
			graph.getVertex(i).setColor(i+"");
			for( int j = i +1 ;j < graph.getVertexes().size(); j++) {
				Edge e = new Edge(graph.getVertex(i), graph.getVertex(j));
				graph.addEdge(e);
				graph.getVertex(i).addAdjacent(e);
				graph.getVertex(j).addAdjacent(e);
			}
		}
		
		assertEquals(true, graph.hasValidColoring());
		if(graph.getVertex(0).getColor() == 0+""){
			graph.getVertex(0).setColor(0+"");
		} else {
			graph.getVertex(0).setColor(1+"");
		}
		
		assertEquals(false, graph.hasValidColoring());
		
	}
	
	@Test
	public void isComplete() {
Graph graph = new Graph();
		
		//cria vertices
		for( int i = 0; i< 10; i++) {
			Vertex v = new Vertex("v"+i);
			graph.addVertex(v);
		}
		
		assertEquals(false, graph.isComplete());
		
		// Testa grafo completo com cores diferentes
		graph.getEdges().clear();
		for(int i = 0; i < graph.getVertexes().size(); i++) {
			for( int j = i +1 ;j < graph.getVertexes().size(); j++) {
				Edge e = new Edge(graph.getVertex(i), graph.getVertex(j));
				graph.addEdge(e);
				graph.getVertex(i).addAdjacent(e);
				graph.getVertex(j).addAdjacent(e);
			}
		}
		
		assertEquals(true, graph.isComplete());
		
		// Testa com algums arestas
		graph.getVertexes().clear();
		graph.getEdges().clear();
		for( int i = 0; i< 10; i++) {
			Vertex v = new Vertex("v"+i);
			graph.addVertex(v);
		}
		
		for( int i = 0; i< 5; i++) {
			Edge e = new Edge(graph.getVertex(i), graph.getVertex(i+5));
			graph.addEdge(e);
			graph.getVertex(i).addAdjacent(e);
			graph.getVertex(i+5).addAdjacent(e);
		}
		
		assertEquals(false, graph.isComplete());
		
		// Testa com uma aresta
		graph.getVertexes().clear();
		graph.getEdges().clear();
		for( int i = 0; i< 5; i++) {
			Vertex v = new Vertex("v"+i);
			graph.addVertex(v);
		}
		Edge e = new Edge(graph.getVertex(0), graph.getVertex(4));
		graph.addEdge(e);
		graph.getVertex(0).addAdjacent(e);
		graph.getVertex(4).addAdjacent(e);
		assertEquals(false, graph.isComplete());
		
	}

}
