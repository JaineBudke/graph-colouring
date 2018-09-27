package test;

import static org.junit.Assert.*;

import org.junit.Test;

import graph.Graph;
import manager.Engine;

public class FileTest {

	@Test
	public void test() {
		
		Engine engine = new Engine();
		engine.readArchive(1);
		engine.createGraph();
		Graph g = engine.getGraph();
		
		assertEquals(g.getVertexes().size(), 543);
	}

}