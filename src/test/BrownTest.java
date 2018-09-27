package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exact_algorithms.Brown_algorithm;
import graph.Graph;
import manager.Engine;

public class BrownTest {
	
	@Test
	public void test() {
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel4.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = brown.executeBrown(graph);
		assertEquals(5, k);
	}
	
	@Test
	public void test1() {
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel5.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = brown.executeBrown(graph);
		assertEquals(6, k);
	}
	
	@Test
	public void test2() {
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel3.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = brown.executeBrown(graph);
		assertEquals(4, k);
	}
	
	@Test
	public void test3() {
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel6.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = brown.executeBrown(graph);
		assertEquals(7, k);
	}
	
	@Test
	public void test4() {
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel7.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = brown.executeBrown(graph);
		assertEquals(8, k);
	}

}