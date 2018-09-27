package exact_algorithms;

import graph.Graph;
import graph.Vertex;

public class ZykovAlgorithm {
	
	private int q;
	private Graph graph;
	
	
	private int cor(Graph graphTemp) {
		int n = graphTemp.getVertexes().size();
		
		if(graphTemp.isComplete()) {
			q = Math.min(n, q);
		} else {
			Vertex[] vertexes = new Vertex[2];
			vertexes = graphTemp.getNonAdjacentVertexes();
			//Contrai vertices
			Graph graphCon = graphTemp.clone();
			graphCon.mergeVertexes(vertexes[0], vertexes[1]);
			cor( graphCon );
			
			//Inicia caminho de adição de arestas
			graphTemp.addEdge(vertexes[0], vertexes[1]);
			cor(graphTemp);
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
