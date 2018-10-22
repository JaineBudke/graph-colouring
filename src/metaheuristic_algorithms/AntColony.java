package metaheuristic_algorithms;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class AntColony {

	// grafo
	private Graph graph;
	
	// lista de arestas do grafo
	private ArrayList<Vertex> U = new ArrayList<>();
	
	// matriz de feromônios
	private double[][] pheromone;
	
	// lista de aptidão
	private double[] fitnessList;
	
	// lista de probabilidade
	private double[] probabilityList;
	
	// Probabilidade de evaporação do feromônio
	private float p = 0.5f;
	
	// lista auxiliar para a trilha de fenomonios para cada formiga
	private double[][] trail;
	
	// Conjunto de classes de cores
	private ArrayList<ArrayList<Vertex> > C;
	
	private int k = 0;
		
	
		
	
	public void calculateFitness( Vertex v, ArrayList<Vertex> W ){
		
		fitnessList = new double[W.size()];
		
		int cont = 0;
		
		for( Vertex w : W ){
			
			// recupera quantidade de vertices adjacentes a v
			int dN = v.getAdjacentVertexes().size();
			
			// recupera o valor do feromônio na posição entre os vertices analisados
			int vi = Integer.parseInt(v.getLabel().replace("v", ""));
			int vj = Integer.parseInt(w.getLabel().replace("v", ""));
			
			double ph = pheromone[vi-1][vj-1];
			
			double f = Math.pow(dN, 2) * Math.pow(ph, 4);			
			
			fitnessList[cont] = f;
			cont++;
			
		}
		
	}
	
	public void calculateProbability( Vertex v, ArrayList<Vertex> W ){
		
		probabilityList = new double[W.size()];
				
		// calcule F = soma das aptidões
		int F = 0;
		for( int i=0; i<fitnessList.length; i++ ){
			F += fitnessList[i];
		}
		
		
		
		for( int i=0; i<W.size(); i++ ){
					
			probabilityList[i] = fitnessList[i]/F;
	
		}
		
	}
	
	
	public Vertex rouletteWheel( Vertex v, ArrayList<Vertex> W ){
		
		calculateFitness( v, W ); 
		calculateProbability( v, W );
		
		
		double max = probabilityList[0];
		Vertex vMax = W.get(0);
		
		// verifica qual probabilidade é maior
		for( int i=1; i<probabilityList.length; i++ ){

			if( max < probabilityList[i] ){
				max = probabilityList[i];
				vMax = W.get(i);
			}
			
		}
		
		return vMax;
	}
	
	public ArrayList<Vertex> findStableSet( ArrayList<Vertex> vertexes ){
		
		ArrayList<Vertex> N = new ArrayList<>();
		ArrayList<Vertex> Ck = new ArrayList<>();
		ArrayList<Vertex> W = (ArrayList<Vertex>) vertexes.clone();
		
		// v is selected from W at random
		Vertex v = W.get(0);
		
		// Add v to Ck
		Ck.add(v);
		
		// Add all neighbors in W of v to N
		ArrayList<Edge> adjacents = v.getAdjacentVertexes();
		
		for( int i=0; i<adjacents.size(); i++ ){
			N.add( adjacents.get(i).getVertex(v) );
			
			// Remove v neighbors from W
			W.remove(adjacents.get(i).getVertex(v));	
		}
		
		// remove v from W
		W.remove(v);
		
		while( !W.isEmpty() ){
			
			Vertex newV = rouletteWheel( v, W );
			
			
			// Add newV to Ck
			Ck.add(newV);
			
			
			// Add all neighbors of newV to N
			ArrayList<Edge> adjacentsNewV = newV.getAdjacentVertexes();
			for( int i=0; i<adjacentsNewV.size(); i++ ){
				N.add( adjacentsNewV.get(i).getVertex(newV) );
				
				// Remove v neighbors from W
				W.remove( adjacentsNewV.get(i).getVertex(newV) );
				
			}
			
			// Remove v from W
			W.remove(newV);
			
			
		}
		
		return Ck;
		
	}
	
	/**
	 * Inicializa matriz que contém a trilha de feromônios
	 * de todas as formigas
	 */
	public void pheromoneInitialize(){
		
		// inicializa matriz de feromônios com número de vértices
		pheromone = new double[U.size()][U.size()];
		
		
		// percorre matriz
		for( int i=0; i<U.size(); i++ ){
			for( int j=0; j<U.size(); j++ ){
				
				ArrayList<Edge> edges = graph.getEdges();

							
				// verifica se tem aresta entre vertices
				Vertex vO = new Vertex("v"+(i+1));
				Vertex vD = new Vertex("v"+(j+1));
				Edge e = new Edge( vO, vD );
				
				
		
				if( graph.containsEdge(e) || i==j ){
					
					
					pheromone[i][j] = 0;
					
				} else {
					
					pheromone[i][j] = 1;
					
				}
				
				System.out.print(pheromone[i][j]+"  ");
				
			}	
			
			System.out.println();
		}
		
		
		
	}
	
	/**
	 * Inicializa matriz auxiliar que guarda é atualizada
	 * quandop cada formiga encontra uma solução
	 */
	public void auxiliarTrailInitialize() {
		//A matriz deve conter inicialmente apenas 0s
		//Por padrão, o Java inicializa double como 0.0d
		trail = new double[U.size()][U.size()];	
		
	}
	
	/**
	 * Atualiza trilha de feronômios baseado nas soluções 
	 * encontradas por todas as formigas.
	 */
	public void updatePheromoneTrail() {
		// Percorre a matriz nxn, com n sendo o numero de vértices
		for( int i = 0; i < graph.getVertexes().size(); i++) {
			for(int j=0; j < graph.getVertexes().size(); j++) {
				if(i!= j) {
					
					// Evapora feromônio de acordo com fator de evaporação p
					// Deposita o que estava na matrix auxiliar
					pheromone[i][j] = p * pheromone[i][j] + trail[i][j];
				}
			}
		}
		
	}
	
	/**
	 * Atualiza matrix que guarda atualiza a trilha para
	 * cada formiga.
	 * Basicamente, é o valor que a formiga deposita na trilha
	 * em cada iteração.
	 */
	public void updateAuxiliarTrail() {
		// Percorre a matriz nxn, com n sendo o numero de vértices
		for( int i = 0; i < graph.getVertexes().size(); i++) {
			for(int j=0; j < graph.getVertexes().size(); j++) {
				if(i!= j) {
					Vertex v1 = graph.getVertex(i);
					Vertex v2 = graph.getVertex(j);
					
					// Atualiza proporção se dois vertices receberem a mesma cor na 
					// solução atual
					if(v1.getColor().equals(v2.getColor())) {
						trail[i][j] += 1/k;
					}
				}
			}
		}
	}
	
	/**
	 * Passo construtivo onde cada formiga encontra uma coloração
	 * @param g
	 */
	public void buildSolution(Graph g){
		
		
		ArrayList<Vertex> Vertexes = (ArrayList<Vertex>) U.clone();
		ArrayList<Vertex> setVertex = new ArrayList<>();
		k = 0; 
		
		ArrayList<Vertex> Ck = new ArrayList<Vertex>();
		

		// Enquanto existirem vértices sem cor
		while( !Vertexes.isEmpty() ){
			
			Ck = findStableSet( Vertexes ); 

			for( Vertex v : Ck ){
				Vertexes.remove(v); // U \ Ck
				v.setColor(k+"");
				setVertex.add(v);
			}

			k++;
		}
		
		C.add(setVertex);

	}
	
	/**
	 * Execução do algoritmo
	 */
	public ArrayList<ArrayList<Vertex>> execute(Graph g ) {
		graph = g.clone();
		U = graph.getVertexes();
		
		
		//Inicialiação das matrizes
		pheromoneInitialize();
		auxiliarTrailInitialize();
		
		C = new ArrayList<>();
		
		//flag ficticia para simular criterio de parada
		//TODO: implementar criterio de parada
		boolean stopCriteria = true;
		
		
		//while( stopCriteria ) {
			// Para cada formiga, constroi uma solução
			for(int ant = 0; ant < 5; ant++) {
				graph.reset();
				
				// A formiga busca a coloração
				buildSolution(graph);
				
				//Atualiza matrix auxiliar baseado na solução atual
				updateAuxiliarTrail();
			}
			
			// Atualiza trilha de feromônios
			updatePheromoneTrail();
		//}
		
		return C;
	}
	
	
	
	
}