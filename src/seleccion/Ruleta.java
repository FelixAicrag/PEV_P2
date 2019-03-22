package seleccion;

import cromosoma.Cromosoma;

public class Ruleta extends SeleccionAbstracta {
	
	int posSuperviviente;
	
	
	public Ruleta (Cromosoma[] pob) {
		this.poblacion = pob;
	}
	
	@Override
	public void seleccion() {
		
		
		
		double prob = 0;
		int[] supervivientes = new int[this.poblacion.length];
		Cromosoma[] pob_nueva = new Cromosoma[this.poblacion.length];
		
		for(int i = 0; i < this.poblacion.length; i++) {
			prob = Math.random();
			this.posSuperviviente = 0;
			
			while((posSuperviviente < this.poblacion.length -1)
					&& (prob > this.poblacion[posSuperviviente].getPuntuacionAcu())) {
				posSuperviviente++;
			}
			
			supervivientes[i] = posSuperviviente;
		}
		
		for(int j = 0; j < this.poblacion.length; j++) {
			pob_nueva[j] = this.poblacion[supervivientes[j]].copiarCromosoma();	
		}
		
		for(int i = 0; i < poblacion.length; i++) {
			this.poblacion[i] = pob_nueva[i].copiarCromosoma();
		}
	}
}
