package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exact_algorithms.Brown_algorithm;
import exact_algorithms.ZykovAlgorithm;
import graph.Graph;
import graph.Vertex;
import manager.Engine;

public class ZykovTest {
	
	
	@Test
	public void test() {
		Engine engine = new Engine( );
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
		
		
		// executa algoritmo de coloração
		int k = zykov.executeZykov(graph);
		assertEquals(2, k);
	}
	
	@Test
	public void test1() {
		Engine engine = new Engine( );
		ZykovAlgorithm zykov = new ZykovAlgorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel3.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = zykov.executeZykov(graph);
		assertEquals(4, k);
	}
	
	@Test
	public void test2() {
		Engine engine = new Engine( );
		ZykovAlgorithm zykov = new ZykovAlgorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel4.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = zykov.executeZykov(graph);
		assertEquals(5, k);
	}
	
	@Test
	public void test3() {
		Engine engine = new Engine( );
		ZykovAlgorithm zykov = new ZykovAlgorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel5.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = zykov.executeZykov(graph);
		assertEquals(6, k);
	}
	
	@Test
	public void test4() {
		Engine engine = new Engine( );
		ZykovAlgorithm zykov = new ZykovAlgorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel6.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = zykov.executeZykov(graph);
		assertEquals(7, k);
	}
	
	@Test
	public void test5() {
		Engine engine = new Engine( );
		ZykovAlgorithm zykov = new ZykovAlgorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel7.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = zykov.executeZykov(graph);
		assertEquals(8, k);
	}
	
	

}
