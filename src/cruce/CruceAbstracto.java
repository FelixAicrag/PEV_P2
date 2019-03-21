package cruce;

import cromosoma.Cromosoma;

public abstract class CruceAbstracto {
	double probCruce;
	int tamPoblacion;
	Cromosoma[] poblacion;
	
	public CruceAbstracto() {}
	
	public CruceAbstracto(double probCruce, int tamPoblacion, Cromosoma[] pob) {
		this.probCruce = probCruce;
		this.tamPoblacion = tamPoblacion;
		this.poblacion = pob;
	}
	
	public void cruzar() {
		boolean[] progenitores = new boolean[this.tamPoblacion];
		Cromosoma soltero = null;
		//seleccionamos las cromosomas a cruzar
		for(int i = 0; i < this.tamPoblacion; i++) {
			double aleatorio = Math.random();
			if(aleatorio < this.probCruce) { progenitores[i] = true;}
			else progenitores[i] = false;
		}
		
		
		//de los seleccionados, va haciendo parejas y las cruza.
		for(int i = 0; i < this.tamPoblacion; i++) {
			if(progenitores[i]) {
				if(soltero != null) {
					cruzarGenes(soltero, this.poblacion[i]);
					soltero = null;
				}
				else soltero =  this.poblacion[i];
			}
		}		
	}
	
	abstract void cruzarGenes(Cromosoma padre, Cromosoma madre);
}
