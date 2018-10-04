package exact_algorithms;

import java.util.logging.Logger;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class ZykovAlgorithm {
	
	private int q;
	private Graph graph;
	private int nodes;
	
	public int cont=0;
	
	private static final Logger LOGGER = Logger.getLogger( ZykovAlgorithm.class.getName() );
	
	
	private void cor(Graph graphTemp) {
		int n = graphTemp.getVertexes().size();
		nodes++;
		
		if(graphTemp.isComplete()) {
			q = Math.min(n, q);
		
		} else {
			
			Vertex[] vertexes = new Vertex[2];
			vertexes = graphTemp.getNonAdjacentVertexes();
			
			if(vertexes != null) {
				
				//Contrai vertices
				Graph graphCon = (Graph) graphTemp.clone();
				graphCon.mergeVertexes(graphCon.findVertexFromLabel(vertexes[0].getLabel()), graphCon.findVertexFromLabel(vertexes[1].getLabel()));
				//LOGGER.info("Contrai "  + vertexes[0].getLabel() + " e " + vertexes[1].getLabel());
				cor( graphCon );
				
				//Inicia caminho de adição de arestas
				Graph graphAdd = (Graph) graphTemp.clone();
				Vertex v1 = graphAdd.findVertexFromLabel(vertexes[0].getLabel());
				Vertex v2 = graphAdd.findVertexFromLabel(vertexes[1].getLabel());
				graphAdd.addEdge(v1, v2);
				
				//LOGGER.info("Adiciona aresta entre " + vertexes[0].getLabel() + " e " + vertexes[1].getLabel());
				cor(graphAdd);
			}  
		}
		
	}
	
	public int executeZykov(Graph graphTemp) {
		// clonando grafo, vertices e arestas
		graph = graphTemp;
		//recupera o numero cromatico do grafo
		q = graph.getVertexes().size();
		nodes = 0;
		cor(graph);
		
		LOGGER.info("cor:"+q);
		LOGGER.info("nos:"+nodes);
		return q;
	}

}
