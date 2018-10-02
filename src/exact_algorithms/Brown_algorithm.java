package exact_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import manager.Engine;


public class Brown_algorithm {

	
	private Graph graphTemp;
	private ArrayList<Vertex> vertexes;
	
	// Vetor contendo o conjunto de cores de cada vértice
	private ArrayList< ArrayList<String> > U = new ArrayList<>();
	
	// Vetor contendo o conjunto de total de cores utilizadas por uma coloração parcial com i vértices coloridos
	private ArrayList<Integer> L = new ArrayList<>();
		
	
	// q = color
	private int q = 1;		
	
	// inicialização de variáveis
	private int i = 1;
	
	
	private ArrayList<Vertex> bestColouring;
	
	private static final Logger LOGGER = Logger.getLogger( Brown_algorithm.class.getName() );
	
	private int nodes = 1;
	

	/**
	 * Ordena uma lista de vertices em ordem decrescente do grau
	 * @param list Lista de vertices
	 */
	public static void orderByDegree(ArrayList<Vertex> list) {
		Collections.sort(list, new Comparator<Vertex>() {

			public int compare(Vertex v1, Vertex v2) {
				return v1.compareTo(v2);
			}

		});
	}
	
	/**
	 * Gera uma lista de vértices de cores possíveis para um determinado vértice
	 * Ou seja, cores que não são utilizadas pelos vizinhos do vértice
	 * @param v Vertice analisado
	 * @param index Indice da lista U que deve ser salvas as cores
	 */
	public void generateUi( Vertex v, int index ){
		
		// lista com cores dos vertices adjacentes
		ArrayList<String> adjacentsColors = new ArrayList<>();
		
		// recupera vértices adjacentes a v
		ArrayList<Edge> adjacentsVertexes = v.getAdjacentVertexes();
		
		
		// percorre lista de vértices adjacentes
		for( int p=0; p<adjacentsVertexes.size(); p++ ){
			Edge currentEdge = adjacentsVertexes.get(p);
			Vertex adjacent = currentEdge.getVertex(v);
			
			if( adjacent.getColor() != null ){
				adjacentsColors.add( adjacent.getColor() );
			}
			
		}
		
		// adiciona a Ui as cores de 1 até q+1 que sejam diferentes da coloração dos adjacentes
		for( int p=1; p<=q+1; p++ ){
			
			// verifica se algum adjacente está colorido com a cor
			if( !adjacentsColors.contains(p+"") ){
				U.get(index).add(p+"");
			}
			
		}
		
		
	}
	
	
	/**
	 * Backtrack
	 */
	public void backtrack( int indPasso, int limInf ){
		
		i = indPasso;
		q = limInf;
		
	}
	
	/**
	 * Encontra o menor índice j para o qual a cor do vértice vj é igual a k.
	 */
	public int findIndex( int k ){
		
		// percorre lista de vértices do grafo
		for( int p=0; p<vertexes.size(); p++ ){

			int color = Integer.parseInt( vertexes.get(p).getColor() );
			
			// se vertice possui cor = k entao
			if( color == k ){
				return p;
			}
			
		}
		
		return 1;
	}

	
	
	/**
	 * Algoritmo principal de execução da coloração
	 * @param graph Grafo a ser colorido
	 */
	public int executeBrown( Graph graph ){
		
		
		// clonando grafo, vertices e arestas
		graphTemp = graph;

		// recuperando vertices
		vertexes = graphTemp.getVertexes();

		// ordena lista de vertices pelo grau
		orderByDegree(vertexes);

		// obter quantidade de vertices
		int n = vertexes.size();


		// Atribua a cor de índice 1 a v1
		vertexes.get(0).setColor(q+"");
		
		// inicialização de variáveis
		int k = n;
		
		// iniciliza l1 (pos=0) com 1
		L.add(0, 1);
		
		// inicializa U
		for( int x=0; x<vertexes.size(); x++ ){
			U.add( new ArrayList<>() );
		}
		
		
		boolean atualizarU = true;
		
		while (i > 0) {
			
			//Soluções são geradas enquanto o nó raiz da árvore não é alcançado.
			if ( atualizarU == true ) {

				// Determine o conjunto Ui, tal que Ui contém as cores do conjunto
				// {1, 2, .., q + 1} menos aquelas que são utilizadas pelos vizinhos do vértice
				// vi
				generateUi( vertexes.get(i), i );
				
			}
			//Se Ui = ∅ então
			if( U.get(i).isEmpty() ){
				
				backtrack(i-1, L.get(i));
				atualizarU = false;
			
			}
			else {
				
				//Escolha j ∈ Ui, tal que j é mínimo, e atribua a cor j ao vértice vi
				String color = U.get(i).get(0); // Recupera cor mínima da lista de cores possíveis		
				vertexes.get(i).setColor(color); // Atribui cor ao vértice examinado 
				U.get(i).remove(0); // remove cor de Ui
				
				int j = Integer.parseInt(color);
				
				// Se a cor j é menor do que o limitante superior k então
				if( j < k ){
					
					// Se a cor j é maior do que o limitante inferior q então
					if( j > q ){
						q = q+1;
					}
					// Se i = n então
					if( i == n-1 ){
						
						// Guarde a solução atual e faça k ← q
						bestColouring = vertexes;
						k = q;
						
						// Encontre o menor índice j para o qual a cor do vértice vj é igual a k.
						j = findIndex(k);
						
						
						backtrack(j-1, k-1);
						atualizarU = false;
						
					}
					else {
						
						//li ← q
						//L.set(i, q);
						L.add(i, q);
						
						//i ← i + 1 //um novo vértice é selecionado para ser colorido
						i = i+1;
						
						atualizarU = true;
						nodes++;
						
					}
					
				}
				else {
					backtrack(i-1, L.get(i-1));
					atualizarU = false;
				}
					
				
			}
			
		}
		LOGGER.info("cor:"+k);
		LOGGER.info("nos:"+nodes);
		return k;
		
		
	}
	
	
}
