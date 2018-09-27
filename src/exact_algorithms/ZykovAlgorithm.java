package exact_algorithms;

import graph.Graph;
import graph.Vertex;

public class ZykovAlgorithm {
	
	private int q;
	private Graph graph;
	
	
	private int cor(Graph graph) {
		int n = graph.getVertexes().size();
		
		if(graph.isComplete()) {
			q = Math.min(n, q);
		} else {
			Vertex[] vertexes = new Vertex[2];
			vertexes = graph.getNonAdjacentVertexes();
		}
	}
	
	private int executeZykov(Graph graphTemp) {
		// clonando grafo, vertices e arestas
		graphTemp = graph.clone();
		//recupera o numero cromatico do grafo
		q = graph.getVertexes().size();
		int k = cor(graph);
		
		return k;
	}

}
