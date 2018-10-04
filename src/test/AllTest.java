package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exact_algorithms.Brown_algorithm;
import exact_algorithms.ZykovAlgorithm;
import graph.Graph;
import graph.Vertex;
import manager.Engine;

public class AllTest {

	@Test
	public void testZykov() {
		Engine engine = new Engine( );
		ZykovAlgorithm zykov = new ZykovAlgorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel3.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = zykov.executeZykov(graph);
	}
	
	@Test
	public void test2Zykov() {
		Engine engine = new Engine( );
		ZykovAlgorithm zykov = new ZykovAlgorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel4.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = zykov.executeZykov(graph);
	}
	
	@Test
	public void test3Zykov() {
		Engine engine = new Engine( );
		ZykovAlgorithm zykov = new ZykovAlgorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel5.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = zykov.executeZykov(graph);
	}
	
	@Test
	public void test4Zykov() {
		Engine engine = new Engine( );
		ZykovAlgorithm zykov = new ZykovAlgorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel6.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = zykov.executeZykov(graph);
	}
	
	@Test
	public void test5Zykov() {
		Engine engine = new Engine( );
		ZykovAlgorithm zykov = new ZykovAlgorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel7.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = zykov.executeZykov(graph);
	}
	@Test
	public void testBrown() {
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel3.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = brown.executeBrown(graph);
		//assertEquals(4, k);
	}
	
	@Test
	public void test2Brown() {
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel4.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = brown.executeBrown(graph);
		//assertEquals(5, k);
	}
	
	@Test
	public void test3Brown() {
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel5.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = brown.executeBrown(graph);
		//assertEquals(6, k);
	}
	
	@Test
	public void test4Brown() {
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel6.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = brown.executeBrown(graph);
		//assertEquals(7, k);
	}
	
	@Test
	public void test5Brown() {
		Engine engine = new Engine( );
		Brown_algorithm brown = new Brown_algorithm();
		
		////myciel3.col		
		// lê arquivo com o índice indicado
		engine.readArchivebyFilename("myciel7.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		// executa algoritmo de coloração
		int k = brown.executeBrown(graph);
		//assertEquals(8, k);
	}

}
