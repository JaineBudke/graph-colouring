package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class Engine {

	
	private ArrayList< ArrayList <String> > students; 
	private Graph graph;
	
	
	private static final Logger LOGGER = Logger.getLogger( Engine.class.getName() );

	
	/**
	 * Constrói objeto da classe Engine.
	 */	
	public Engine() {
		students = new ArrayList< ArrayList<String> >();
	}
	
	
	/**
	 * Lê arquivo de entrada e separa as atividades
	 * @param path Caminho do arquivo
	 */
	public void readArchive(String path) {

		
		try(FileReader arq = new FileReader(path);
			BufferedReader lerArq = new BufferedReader(arq);
			) {

			String linha = lerArq.readLine(); // lê a primeira linha
			
			int p = 0;
			System.out.println("Linha " + p + "lida");
			p++;
			
			while ( linha != null ) {
				ArrayList<String> lectures = new ArrayList<String>(); 

				
				String[] element = linha.split(" "); // separa a linha pelo espaçamento

				for( int i=0; i < element.length; i++ ){

					lectures.add(element[i]); // adiciona atividade
					
				}

				students.add(lectures);
				
				linha = lerArq.readLine(); // lê a próxima linha
			}

		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		}

	}
	
	
	/**
	 * Lê arquivo de entrada e separa as atividades
	 * @param index Indice do arquivo
	 */
	public void readArchive(int index) {


		File f = new File("");
		String absolutePath = f.getAbsolutePath();

		File folder = new File(absolutePath + "/src/data");
		File[] listOfFiles = folder.listFiles();

		String filename = "aaaa.txt";
		/*for (int i = 0; i < index; i++) {
			filename = listOfFiles[i].getName();
		}*/
		
		
		this.readArchive(absolutePath+"/src/data/" + filename);
		
	}

	
	/**
	 * Cria grafo a partir de arquivo de texto:
	 * Vertices: aulas; Arestas: relação dada a aulas assistidas pelo mesmo aluno.
	 */
	public Graph createGraph(  ) {

		graph = new Graph();

		System.out.println("Gerando grafo");
		
		for( int student=0; student < students.size(); student++ ){ // percorre lista de estudantes
			
			// lista com aulas do estudante analisado
			ArrayList<String> lecturesStudent = students.get(student);

			Vertex[] vertexStudent = new Vertex[lecturesStudent.size()];

			// adiciona vertices do estudante ao grafo
			// percorre aulas do estudante analisado
			for( int i=0; i < lecturesStudent.size(); i++ ){

				
				
				// cria um vértice com o rótulo da aula
				Vertex vertex = new Vertex( "v"+lecturesStudent.get(i) );
				// se não contém vertice
				if( graph.containsVertex(vertex) == null ){
					graph.addVertex(vertex);
					vertexStudent[i] = vertex;
					System.out.println("Adicionado vertice");
				} else {
					vertexStudent[i] = graph.containsVertex(vertex);
				}

			}

			System.out.println("Adicionado arestas");
			// adiciona arestas do estudante ao grafo
			for( int j=0; j < lecturesStudent.size(); j++ ){ // percorre todas as aulas
				for( int k=j+1; k < lecturesStudent.size(); k++ ){ // percorre as atividades a partir de j

					Vertex v1 = vertexStudent[j];
					Vertex v2 = vertexStudent[k];

					Edge edge = new Edge( v1, v2 );
					
					if( graph.containsEdge(edge) == null ) {
						graph.addEdge(edge);
						v1.addAdjacent(edge);
						v2.addAdjacent(edge);
						
					} else {
						// aumenta o peso da aresta
						Edge e = graph.containsEdge(edge);
						e.increaseWeight();
					}

				}

			}
			
		}
		
		return graph;
		

		
	}
	
	
	
	
}
