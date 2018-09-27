package test;

import static org.junit.Assert.*;

import org.junit.Test;

import graph.Graph;
import manager.Engine;

public class FileTest {

	@Test
	public void test() {
		
		Engine engine = new Engine();
		engine.readArchivebyFilename("myciel3.col");
		engine.createGraph();
		Graph g = engine.getGraph();
		assertEquals(g.getVertexes().size(), 11);
		
		engine.readArchivebyFilename("myciel4.col");
		engine.createGraph();
		g = engine.getGraph();
		assertEquals(g.getVertexes().size(), 23);
		
		engine = new Engine();
		engine.readArchivebyFilename("myciel5.col");
		engine.createGraph();
		g = engine.getGraph();
		assertEquals(g.getVertexes().size(), 47);
		
		engine.readArchivebyFilename("myciel6.col");
		engine.createGraph();
		g = engine.getGraph();
		assertEquals(g.getVertexes().size(), 95);
		
		engine = new Engine();
		engine.readArchivebyFilename("myciel7.col");
		engine.createGraph();
		g = engine.getGraph();
		assertEquals(g.getVertexes().size(), 191);
		
		engine.readArchivebyFilename("car-f-92.stu");
		engine.createGraph();
		g = engine.getGraph();
		
		//assertEquals(g.getVertexes().size(), 543);
	}

}