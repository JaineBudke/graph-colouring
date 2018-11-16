package view;

import manager.Engine;
import metaheuristic_algorithms.AntColony;
import metaheuristic_algorithms.TabuSearch;
import test.AntColonyTest;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import exact_algorithms.Brown_algorithm;
import exact_algorithms.ZykovAlgorithm;
import graph.Edge;
import graph.Graph;
import graph.Vertex;


public class Main {

	public static void main(String[] args) {
	
		/**
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
		graph.addEdge(v3, v4);**/
		
		
		
		
		
		Engine engine = new Engine( );
		engine.readArchivebyFilename("myciel4.col");
		Graph graph = engine.createGraph();

		
		TabuSearch tabu = new TabuSearch();
		tabu.execute(graph);
		
		if(!graph.hasValidColoring()) {
			System.out.println("meurda");
		}
		
	}

}
