package cromosoma;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import utils.Ciudades;

public class Cromosoma{
	//podemos cambiar la longitud a 9
	//y hacemos los mismos ejemplos de clase
	//para ver si lo hacemos bien
	
	int[] genes;
	double fitness;
	double puntuacion;
	double puntuacion_acu;
	int longitudCromosoma;
	
	public Cromosoma() {
		this.genes = new int[27];
		this.fitness = 0.0;
		this.puntuacion = 0.0;
		this.puntuacion_acu = 0.0;
		this.longitudCromosoma = 27;
	}
	
	public Cromosoma(int[] genes, int longitud) {
		this.genes = genes;
		this.fitness = 0.0;
		this.puntuacion = 0.0;
		this.puntuacion_acu = 0.0;
		this.longitudCromosoma = longitud;
	}
	
	public int[] getGenes() {
    	int cromo[] = new int[this.genes.length];
    	for(int i = 0; i < this.genes.length; i++) {
    		cromo[i] = this.genes[i];
    	}
        return cromo;
	}
	
	public void setGenes(int[] genes) {
    	for(int i = 0; i < this.genes.length; i++) {
    		this.genes[i] = genes[i];
    	}
	}
	
	public double getFitness() {
		return this.fitness;
	}
	
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public double getPuntuacion() {
		return this.puntuacion;
	}
	
	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public double getPuntuacionAcu() {
		return this.puntuacion_acu;
	}
	
	public void setPuntuacionAcu(double puntuacion_acu) {
		this.puntuacion_acu = puntuacion_acu;
	}
	
	public int getLongitud() {
		return this.longitudCromosoma;
	}
	
	public void setLongitud(int longitud) {
		this.longitudCromosoma = longitud;
	}
	
	public void generarCromosomaRandom() {
		int[] genoma = new int[this.longitudCromosoma];
		for(int i = 0; i < Ciudades.MADRID.ordinal(); i++) {
			genoma[i] = i;
		}
		
		for(int i = Ciudades.MADRID.ordinal(); i < this.longitudCromosoma; i++) {
			genoma[i] = i+1;
		}
		
		shuffleArray(genoma);
		
		this.genes = genoma;
	}
	
	  // Implementing Fisher–Yates shuffle
	  private void shuffleArray(int[] ar)
	  {
	    
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
	
}
