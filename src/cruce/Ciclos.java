package cruce;

import cromosoma.Cromosoma;

public class Ciclos extends CruceAbstracto {
		
	/**
	 * 
	 */
	public void cruzarGenes(Cromosoma padre, Cromosoma madre) {
		int[] genesPadre = padre.getGenes();
		int[] genesMadre = madre.getGenes();
		
		int[] genesA = new int[genesPadre.length];
		int[] genesB = new int[genesMadre.length];
		
		genesA[0] = genesPadre[0];
		int elem = genesMadre[0];
		int pos = buscarPos(genesPadre, elem);
		
		for(int i = 0; i < genesA.length; i++) {
			genesA[i] = -1;
			genesB[i] = -1;
		}
		
		while(pos != 0) {
			genesA[pos] = elem;
			
			elem = genesMadre[pos];
			pos = buscarPos(genesPadre, elem);
		}
		
		genesB[0] = genesMadre[0];
		elem = genesPadre[0];
		pos = buscarPos(genesMadre, elem);
		
		while(pos != 0) {
			genesB[pos] = elem;
			
			elem = genesPadre[pos];
			pos = buscarPos(genesMadre, elem);
		}
		
		for(int i = 0; i < genesA.length; i++) {
			if(genesA[i] == -1) { genesA[i] = genesPadre[i]; };
			if(genesB[i] == -1) { genesB[i] = genesMadre[i]; };
		}
		
		padre.setGenes(genesA);
		madre.setGenes(genesB);
	}
	
	private int buscarPos(int[] genes, int elem) {
		int pos = 0;
		boolean encontrado = false;
		while(!encontrado && pos < genes.length) {
			if(genes[pos] == elem) encontrado = true; 
			else pos++;
		}
		
		if(!encontrado) pos = -1;
		return pos;
	} 

}
