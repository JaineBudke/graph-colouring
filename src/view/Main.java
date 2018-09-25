package view;

import manager.Engine;

public class Main {

	public static void main(String[] args) {
	
		Engine engine = new Engine( );
		
		int ctIndex = 1;
		
		// lê arquivo com o índice indicado
		engine.readArchive(ctIndex);
		// cria o grafo
		engine.createGraph();
		
	}

}
