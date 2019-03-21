package seleccion;

import cromosoma.Cromosoma;

public class Ruleta {
	
	int posSuperviviente;
	
	
	public Ruleta () {
	}
	

	public Cromosoma[] seleccionRuleta(Cromosoma[] pob) {
		
		
		
		double prob = 0;
		int[] supervivientes = new int[pob.length];
		Cromosoma[] pob_nueva = new Cromosoma[pob.length];
		
		for(int i = 0; i < pob.length; i++) {
			prob = Math.random();
			this.posSuperviviente = 0;
			
			while((posSuperviviente < pob.length -1)
					&& (prob > pob[posSuperviviente].getPuntuacionAcu())) {
				posSuperviviente++;
			}
			
			supervivientes[i] = posSuperviviente;
		}
		
		for(int j = 0; j < pob.length; j++) {
			pob_nueva[j] = pob[supervivientes[j]].copiarCromosoma();	
		}
		
		return pob_nueva;
		
		
	}
	// TODO hacer!
}
