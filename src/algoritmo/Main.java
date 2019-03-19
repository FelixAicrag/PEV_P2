package algoritmo;

import org.math.plot.*;

import cromosoma.Cromosoma;

public class Main {
	
	public static Plot2DPanel plot;

	public static void main(String[] args) {
		
		Cromosoma individuo = new Cromosoma();
		
		individuo.generarCromosomaRandom();
		
		for(int i = 0; i < individuo.getLongitud(); i++) {
			System.out.print(" " + individuo.getGenes()[i] + " ");
		}
		
		
		
		
		// TODO Auto-generated method stub

	}

}
