package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.RepeatedTest;

import graph.Graph;
import graph.Vertex;
import manager.Engine;
import metaheuristic_algorithms.AntColony;

public class AntColonyTest {
	Engine engine;
	AntColony antCol;
	
	@Before
	public void setUp() {
		engine = new Engine();
		antCol = new AntColony();
	}

	@RepeatedTest(20)
	public void testDSJC1251() {
		engine.readArchivebyFilename("DSJC125.1.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		Map<Integer, ArrayList<Vertex>> result = antCol.execute(graph);
		
	}
	
	@RepeatedTest(20)
	public void testDSJC1255() {
		engine.readArchivebyFilename("DSJC125.5.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		Map<Integer, ArrayList<Vertex>> result = antCol.execute(graph);
		
	}
	
	@RepeatedTest(20)
	public void testDSJC2501() {
		engine.readArchivebyFilename("DSJC250.1.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		Map<Integer, ArrayList<Vertex>> result = antCol.execute(graph);
		
	}
	
	@RepeatedTest(20)
	public void testDSJC2505() {
		engine.readArchivebyFilename("DSJC250.5.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		Map<Integer, ArrayList<Vertex>> result = antCol.execute(graph);
		
	}

}
