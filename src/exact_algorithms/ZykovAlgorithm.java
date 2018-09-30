package exact_algorithms;

import java.util.logging.Logger;

import graph.Graph;
import graph.Vertex;

public class ZykovAlgorithm {
	
	private int q;
	private Graph graph;
	
	private static final Logger LOGGER = Logger.getLogger( ZykovAlgorithm.class.getName() );
	
	
	private void cor(Graph graphTemp) {
		int n = graphTemp.getVertexes().size();
		
		if(graphTemp.isComplete()) {
			q = Math.min(n, q);
			//LOGGER.info("Grafo completo");
		} else {
			Vertex[] vertexes = new Vertex[2];
			vertexes = graphTemp.getNonAdjacentVertexes();
			if(vertexes != null) {

				//Contrai vertices
				Graph graphCon = graphTemp;
				graphCon.mergeVertexes(graphCon.findVertexFromLabel(vertexes[0].getLabel()), graphCon.findVertexFromLabel(vertexes[1].getLabel()));
				//LOGGER.info("Contrai "  + vertexes[0].getLabel() + " e " + vertexes[1].getLabel());
				cor( graphCon );
				
				//Inicia caminho de adição de arestas
				//Graph graphAdd = graphTemp.clone();
				graphTemp.addEdge(vertexes[0],  vertexes[1]);
				
				//LOGGER.info("Adiciona aresta entre " + vertexes[0].getLabel() + " e " + vertexes[1].getLabel());
				cor(graphTemp);
			}  
		}
	}
	
	public int executeZykov(Graph graphTemp) {
		// clonando grafo, vertices e arestas
		graph = graphTemp;
		//recupera o numero cromatico do grafo
		q = graph.getVertexes().size();
		cor(graph);
		
		return q;
	}

}
