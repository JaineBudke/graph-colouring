package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exact_algorithms.ZykovAlgorithm;
import graph.Graph;
import manager.Engine;

public class ZykovTest {
	
	@Test
	public void test() {
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
	
	

}
