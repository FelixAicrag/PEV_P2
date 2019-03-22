package seleccion;

import cromosoma.Cromosoma;

public class Restos extends SeleccionAbstracta {
	
	double probabilidad;
	int numSeleccionados;
	
	public Restos(Cromosoma[] pob, double prob, int numSel) {
		this.poblacion = pob;
		this.probabilidad = prob;
		this.numSeleccionados = numSel;
	}

	//TODO CORREGIR
	public void seleccion() {
		
		int posIndividuo = (int) Math.floor(Math.random() * this.poblacion.length);
		int numCopias = (int) Math.floor(this.probabilidad * numSeleccionados);
		
		Cromosoma[] pob_nueva = new Cromosoma[this.poblacion.length];
		
		for(int i = 0; i < numCopias; i++) {
			pob_nueva[i] = this.poblacion[posIndividuo].copiarCromosoma();
		}

		Ruleta r = new Ruleta(this.poblacion);
		r.seleccion();
		this.ordenarPoblacion();
		
		for(int j = 0; j < numCopias; j++) {
			this.poblacion[j] = pob_nueva[j].copiarCromosoma();
		}
	}
	
	/**
     * Ordena de menor a mayor fitness
     */
	private void ordenarPoblacion() {
		ordenarPoblacionAux(0, this.poblacion.length-1);
	}
	

    private void ordenarPoblacionAux(int izq, int der) {
    	 
        int i = izq;
        int j = der;
        
        Cromosoma pivote = this.poblacion[(i+j)/2];
        
        do {
            while (this.poblacion[i].getFitness() < pivote.getFitness()){
                i++;
            }
            while (this.poblacion[j].getFitness() > pivote.getFitness()){
                j--;
            }
            if (i<=j){
                Cromosoma aux = this.poblacion[i].copiarCromosoma();
                this.poblacion[i] = this.poblacion[j].copiarCromosoma();
                this.poblacion[j] = aux.copiarCromosoma();
                i++;
                j--;
            }
        }while(i<=j);
        if (izq<j){
            ordenarPoblacionAux(izq, j);
        }
        if (i<der){
            ordenarPoblacionAux(i, der);
        }
    }

	
}
