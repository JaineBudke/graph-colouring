package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import graph.Graph;
import graph.Vertex;
import manager.Engine;
import metaheuristic_algorithms.AntColony;

public class AntColonyTest {
	static Engine engine;
	static AntColony antCol;
	private static final Logger LOGGER = Logger.getLogger( AntColonyTest.class.getName() );
	
	static String resultTest;
	
	@BeforeAll
	static void onSetUp() {
		engine = new Engine();
		antCol = new AntColony();
	}
	
	@AfterEach
	public void print() {
		engine = new Engine();
		PrintWriter writer;
		
		try (FileWriter fileWriter  = new FileWriter(Paths.get("result3.txt").toString(), true); ){
			
			writer = new PrintWriter(fileWriter);
			writer.println(resultTest);
			writer.close();
		} catch (FileNotFoundException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (UnsupportedEncodingException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (IOException e1) {
			//LOGGER.info(e1.getMessage());
		}
	}

	@RepeatedTest(10)
	public void testDSJC1251(RepetitionInfo repetitionInfo) {
		engine = new Engine();
		engine.readArchivebyFilename("DSJC125.1.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		TreeMap<Integer, TreeMap<Integer, ArrayList<Vertex>>> result = antCol.execute(graph);
		//Recupera numero cromatico
		int k = result.firstKey();
		
		int it = result.get(k).firstKey();
		
		resultTest = "DSJC125.1.col "+ k + " "+it;
		/**
		// salva resultado em arquivo
		PrintWriter writer;
		
		try (FileWriter fileWriter  = new FileWriter(Paths.get("result1.txt").toString(), true); ){
			
			writer = new PrintWriter(fileWriter);
			writer.println("DSJC125.1.col "+ k + " "+it);
			writer.close();
		} catch (FileNotFoundException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (UnsupportedEncodingException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (IOException e1) {
			//LOGGER.info(e1.getMessage());
		}**/
		
	}
	
	@RepeatedTest(10)
	public void testDSJC1255(RepetitionInfo repetitionInfo){
		engine = new Engine();
		engine.readArchivebyFilename("DSJC125.5.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		TreeMap<Integer, TreeMap<Integer, ArrayList<Vertex>>> result = antCol.execute(graph);
		//Recupera numero cromatico
		int k = result.firstKey();
		
		int it = result.get(k).firstKey();
		resultTest = "DSJC125.5.col " + k + " " + it;
		/**
		// salva resultado em arquivo
		PrintWriter writer;
		
		try (FileWriter fileWriter  = new FileWriter(Paths.get("result1.txt").toString(), true); ){
			
			writer = new PrintWriter(fileWriter);
			writer.println("DSJC125.5.col " + k + " " + it);
			writer.close();
		} catch (FileNotFoundException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (UnsupportedEncodingException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (IOException e1) {
			//LOGGER.info(e1.getMessage());
		}**/
		
	}
	
	@RepeatedTest(10)
	public void testDSJC2501(RepetitionInfo repetitionInfo){
		engine = new Engine();
		engine.readArchivebyFilename("DSJC250.1.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		antCol = new AntColony();
		TreeMap<Integer, TreeMap<Integer, ArrayList<Vertex>>> result = antCol.execute(graph);
		//Recupera numero cromatico
		int k = result.firstKey();
		
		int it = result.get(k).firstKey();
		resultTest = "DSJC250.1.col "+ k + " " + it;
		/**
		
		// salva resultado em arquivo
		PrintWriter writer;
		
		try (FileWriter fileWriter  = new FileWriter(Paths.get("result1.txt").toString(), true); ){
			
			writer = new PrintWriter(fileWriter);
			writer.println("DSJC250.1.col "+ k + " " + it);
			writer.close();
		} catch (FileNotFoundException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (UnsupportedEncodingException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (IOException e1) {
			//LOGGER.info(e1.getMessage());
		}**/
		
	}
	
	@RepeatedTest(10)
	public void testDSJC2505(RepetitionInfo repetitionInfo){
		engine = new Engine();
		engine.readArchivebyFilename("DSJC250.5.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		TreeMap<Integer, TreeMap<Integer, ArrayList<Vertex>>> result = antCol.execute(graph);
		//Recupera numero cromatico
		int k = result.firstKey();
		
		int it = result.get(k).firstKey();
		
		resultTest = "DSJC250.5.col "+ k + " " + it;
		/**
		// salva resultado em arquivo
		PrintWriter writer;
		
		try (FileWriter fileWriter  = new FileWriter(Paths.get("result1.txt").toString(), true); ){
			
			writer = new PrintWriter(fileWriter);
			writer.println("DSJC250.5.col "+ k + " " + it);
			writer.close();
		} catch (FileNotFoundException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (UnsupportedEncodingException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (IOException e1) {
			//LOGGER.info(e1.getMessage());
		}**/
		
	}
	
	@RepeatedTest(10)
	public void testDSJC2506(RepetitionInfo repetitionInfo){
		engine = new Engine();
		engine.readArchivebyFilename("le450_15b.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		TreeMap<Integer, TreeMap<Integer, ArrayList<Vertex>>> result = antCol.execute(graph);
		//Recupera numero cromatico
		int k = result.firstKey();
		
		int it = result.get(k).firstKey();
		
		resultTest = "le450_15b.col " + k + " " + it;
		/**
		// salva resultado em arquivo
		PrintWriter writer;
		
		try (FileWriter fileWriter  = new FileWriter(Paths.get("result1.txt").toString(), true); ){
			
			writer = new PrintWriter(fileWriter);
			writer.println("le450_15b.col " + k + " " + it);
			writer.close();
		} catch (FileNotFoundException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (UnsupportedEncodingException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (IOException e1) {
			//LOGGER.info(e1.getMessage());
		}**/
		
	}
	
	@RepeatedTest(10)
	public void testDSJC2507(RepetitionInfo repetitionInfo){
		engine = new Engine();
		engine.readArchivebyFilename("le450_15c.col");
		// cria o grafo
		Graph graph = engine.createGraph();
		
		antCol = new AntColony();
		TreeMap<Integer, TreeMap<Integer, ArrayList<Vertex>>> result = antCol.execute(graph);
		//Recupera numero cromatico
		int k = result.firstKey();
		
		int it = result.get(k).firstKey();
		
		resultTest = "le450_15c.col " +k + " " + it;
		/**
		// salva resultado em arquivo
		PrintWriter writer;
		
		try (FileWriter fileWriter  = new FileWriter(Paths.get("result1.txt").toString(), true); ){
			
			writer = new PrintWriter(fileWriter);
			writer.println("le450_15c.col " +k + " " + it);
			writer.close();
		} catch (FileNotFoundException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (UnsupportedEncodingException e1) {
			//LOGGER.info(e1.getMessage());
		} catch (IOException e1) {
			//LOGGER.info(e1.getMessage());
		}**/
		
	}

}
