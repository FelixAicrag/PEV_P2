package cruce;

import cromosoma.Cromosoma;

public abstract class CruceAbstracto {
	double probCruce;
	Cromosoma[] poblacion;
	
	public CruceAbstracto() {}
	
	public void cruzar() {
		boolean[] progenitores = new boolean[this.poblacion.length];
		int posAnterior = -1;
		boolean soltero = false;
		//seleccionamos las cromosomas a cruzar
		for(int i = 0; i < this.poblacion.length; i++) {
			double aleatorio = Math.random();
			if(aleatorio < this.probCruce) { progenitores[i] = true;}
			else progenitores[i] = false;
		}
		
		
		//de los seleccionados, va haciendo parejas y las cruza.
		for(int i = 0; i < this.poblacion.length; i++) {
			if(progenitores[i]) {
				
				if(soltero) {
					cruzarGenes(poblacion[posAnterior], poblacion[i]);
					soltero = false;
				}
				else {
					soltero = true; 
					posAnterior = i;
				}
			}
		}		
	}
	
	abstract void cruzarGenes(Cromosoma padre, Cromosoma madre);
	
	public Cromosoma[] getPoblacion() {
		return this.poblacion;
	}
}
