package exact_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class BrownDsaturAlgorithm {

	
	
	// private Graph graphTemp;
	private ArrayList<Vertex> vertexes;
	
	// q = color
	private int q = 1;		
	
	
	

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
	
	
	
	public Vertex higherDegreeSaturation(){
		
		int dsat = 0;
		Vertex v = null;
		
		// percorre lista de vertices
		for( int i=0; i<vertexes.size(); i++ ){
			
			// compara o grau de saturação de cada vertice
			if( vertexes.get(i).getSaturation() >= dsat ){
				dsat = vertexes.get(i).getSaturation();
				v = vertexes.get(i);
			}
			
		}
		
		return v;
		
	}


	
	public int dsatur( Graph graph ){
		
		// recuperando vertices
		vertexes = graph.getVertexes();

		// ordena lista de vertices pelo grau
		orderByDegree(vertexes);
		
		// Atribua a cor de índice 1 a v1
		vertexes.get(0).setColor(q+"");
		
		
		// aumenta em 1 a saturacao de todos os vertices adjacentes
		ArrayList<Edge> adj = vertexes.get(0).getAdjacentVertexes();
		for( int i=0; i < adj.size(); i++ ){
			adj.get(i).getVertex(vertexes.get(0)).increaseSaturation();
		}
		
		// remove o vertice da lista a ser analisada
		vertexes.remove(0);
		
		
		// enquanto a lista não estiver vazia
		while( vertexes.size() > 0 ){
			
			// recupera vertice com maior grau de saturação
			Vertex v = higherDegreeSaturation();
			
			ArrayList<String> adjacentColors = new ArrayList<>();

			// aumenta em 1 a saturacao de todos os vertices adjacentes
			ArrayList<Edge> adjList = v.getAdjacentVertexes();
			for( int i=0; i < adjList.size(); i++ ){
				
				// recupera cores dos vertices adjacentes
				String color = adj.get(i).getVertex(v).getColor();
				if( color != null ) {
					adjacentColors.add(color);
				}
				
				// aumenta saturação dos vertices adjacentes
				adjList.get(i).getVertex(v).increaseSaturation();
			}
			
			// Atribui ao vértice selecionado a cor de menor índice disponível
			for( int i=1; i<q+1; i++ ){
				if( !adjacentColors.contains(i+"") ){
					v.setColor(i+"");
					break;
				}
			}
			
			
			
		}
		

		
		
		return vertexes.size();
	}
	
}
