package seleccion;

import cromosoma.Cromosoma;

public class Torneos extends SeleccionAbstracta {

	private int tamTorneo;
	
	public Torneos (Cromosoma[] pob, int tamTorneo) {
		this.poblacion = pob;
		this.tamTorneo = tamTorneo;
	}
	
	public Torneos (Cromosoma[] pob) {
		this.poblacion = pob;
		this.tamTorneo = 2;
	}	
		
	private Cromosoma torneoMin(Cromosoma[] muestra) {
		Cromosoma mejor = muestra[0].copiarCromosoma();
			for(int i = 1; i < muestra.length; i++) {
				if(muestra[i].getFitness() < mejor.getFitness()) {
					mejor = muestra[i].copiarCromosoma();
				} 	
			}
		
		return mejor;
	}

	@Override
	public void seleccion() {
		Cromosoma[] muestra = new Cromosoma[tamTorneo];
		Cromosoma[] pob_nueva = new Cromosoma[this.poblacion.length];
		 
		  
		 for (int i = 0; i < this.poblacion.length; i++) {
			 
			 
			 for(int j = 0; j < this.tamTorneo; j++) {
				 int aleatorio = (int) (Math.random() * this.poblacion.length);
				 muestra[j] = this.poblacion[aleatorio].copiarCromosoma();
			 }
			 
			 pob_nueva[i] = torneoMin(muestra);
		 }
		 
			for(int i = 0; i < poblacion.length; i++) {
				this.poblacion[i] = pob_nueva[i].copiarCromosoma();
			}

	}
	
}
