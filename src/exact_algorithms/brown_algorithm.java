package exact_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import graph.Graph;
import graph.Vertex;


public class brown_algorithm {

	
	private Graph graphTemp;
	private ArrayList<Vertex> vertexes;
	
	// Vetor contendo o conjunto de cores de cada vértice
	private ArrayList< ArrayList<String> > U = new ArrayList<>();
	
	// Vetor contendo o conjunto de total de cores utilizadas por uma coloração parcial com i vértices coloridos
	private ArrayList< ArrayList<Integer> > L = new ArrayList<>();
		
	

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
		
		// stub
		
	}
	
	
	/**
	 * Backtrack
	 */
	public void backtrack( int indPasso, int i, int limInf, int q ){
		
		// stub
		
	}

	
	
	/**
	 * Algoritmo principal de execução da coloração
	 * @param graph Grafo a ser colorido
	 */
	public void executeBrown( Graph graph ){
		
		
		// clonando grafo, vertices e arestas
		graphTemp = graph.clone();

		// recuperando vertices
		vertexes = graphTemp.getVertexes();

		// ordena lista de vertices pelo grau
		orderByDegree(vertexes);

		// obter quantidade de vertices
		int n = vertexes.size();


		// q = color
		int q = 1;		
		// Atribua a cor de índice 1 a v1
		vertexes.get(0).setColor(q+"");
		
		// inicialização de variáveis
		int i = 2;
		int k = n;
		

		int l1 = 1;
		boolean atualizarU = true;
		
		while (i > 1) {
			
			//Soluções são geradas enquanto o nó raiz da árvore não é alcançado.
			if ( atualizarU == true ) {

				// Determine o conjunto Ui, tal que Ui contém as cores do conjunto
				// {1, 2, .., q + 1} menos aquelas que são utilizadas pelos vizinhos do vértice
				// vi
				generateUi( vertexes.get(i), i );
				
			}
			//Se Ui = ∅ então
			if( U.get(i).isEmpty() ){
				// NÃO ENTENDI AINDA OQ EH O Li
				//backtrack(i-1, i, li, q);
				atualizarU = false;
			}
			else {
				
				//Escolha j ∈ Ui, tal que j é mínimo, e atribua a cor j ao vértice vi
				String color = U.get(i).get(0); // Recupera cor mínima da lista de cores possíveis		
				vertexes.get(i).setColor(color); // Atribui cor ao vértice examinado 
				U.get(i).remove(0); // remove cor de Ui
				
				// Se a cor j é menor do que o limitante superior k então
				if( Integer.parseInt(color) < k ){
					
					// Se a cor j é maior do que o limitante inferior q então
					if( Integer.parseInt(color) > q ){
						q = q+q;
					}
					// Se i = n então
					if( i == n ){
						
						// Guarde a solução atual e faça k ← q
						
					}
					
				}
					
				
			}
			
		}
		
		
		
	}
	
	
}
