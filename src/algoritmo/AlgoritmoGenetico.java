package algoritmo;

import java.util.ArrayList;

import cromosoma.Cromosoma;
import seleccion.Ruleta;
import utils.*;

public class AlgoritmoGenetico {
	
	Cromosoma[] poblacion; //Poblacion total
	ArrayList<Cromosoma> elite; //Elite seleccionada
	private Cromosoma elMejor;
	
	//Parametros del algoritmo.
	TipoSeleccion tipo_seleccion;
	TipoCruce tipo_cruce;
	int tamPoblacion, numGeneraciones, generacionActual;
	double probabilidadCruce, probabilidadMutacion, probabilidadUniforme, elitismo;
	
	//Valores para escribir la grafica.
	private double[] mediasGeneracion;
	private double[] mejoresGeneracion;
	private double[] mejoresAbsolutos;

	
	public static int MADRID = 25;

	public AlgoritmoGenetico(TipoSeleccion tipo_seleccion, TipoCruce tipo_cruce, TipoMutacion tipo_mutacion,
			int tamPoblacion, int numGeneraciones, double probabilidadCruce, double probabilidadMutacion,
			double probabilidadUniforme, double elitismo) {
		
		this.generacionActual = 0;
		this.tipo_seleccion = tipo_seleccion;
		this.tipo_cruce = tipo_cruce;
		this.tamPoblacion = tamPoblacion;
		
		this.numGeneraciones = numGeneraciones;
		this.probabilidadCruce = probabilidadCruce;
		this.probabilidadMutacion = probabilidadMutacion;
		this.probabilidadUniforme = probabilidadUniforme;
		this.elitismo = elitismo;
		
		this.poblacion = new Cromosoma[tamPoblacion];
		this.elite = new ArrayList<Cromosoma>();
		
		this.mediasGeneracion = new double[numGeneraciones];
		this.mejoresGeneracion = new double[numGeneraciones];
		this.mejoresAbsolutos = new double[numGeneraciones];
	}
	
	/**
	 * @author Felix
	 * Runs the genetic algorithm.
	 * All results for plots are stored in
	 *  mediasGeneracion,
	 *  mejoresGeneracion and
	 *  mejoresAbsolutos
	 */
	public void run() {
		
		inicializaPoblacion();
		evaluaPoblacion();
		
		for (int i = 0; i < numGeneraciones; i++) {
			seleccionaElite();
			
			seleccionaPoblacion();
			reproducePoblacion();
			
			incluyeElite();
                     
			evaluaPoblacion();
			aumentaGeneracion();
		}
		
	}
	
	/**
	 * Returns the fitness of a particular chromosome.
	 */
	public int fitness(Cromosoma individuo) {
		Distancias dist = new Distancias();
		int dist_ini, dist_fin;
		
		dist_ini = dist.getDistancia(MADRID, individuo.getGenes()[0]);
		dist_fin = dist.getDistancia(MADRID, individuo.getGenes()[individuo.getLongitud()-1]);
		int valor = dist_ini;
		
		for(int i = 0; i < individuo.getLongitud()-1; i++) {
			valor += dist.getDistancia(individuo.getGenes()[i], individuo.getGenes()[i+1]);
		}
		
		valor += dist_fin;
		return valor;
	}

	private void inicializaPoblacion() {
		for(int i = 0; i < tamPoblacion; i++) {
			this.poblacion[i] = new Cromosoma();
			this.poblacion[i].generarCromosomaRandom();
		}
		
		this.elMejor = this.poblacion[0].copiarCromosoma();
        fitness(elMejor);
        this.generacionActual = 0;
	}

	private void evaluaPoblacion() {
		double fitness, fitness_best, sum_fitness = 0;
		int pos_fitness_best = 0;
		fitness_best = fitness(this.poblacion[0]);
		
		for(int i = 0; i < tamPoblacion; i++) {
			fitness = fitness(this.poblacion[i]);
			
			if(fitness < fitness_best) { fitness_best = fitness; pos_fitness_best = i; }
			sum_fitness += fitness;
			this.poblacion[i].setFitness(fitness);
		}
		
		double puntuacion = 0.0, puntuacion_acu = 0.0;
		
		for(int i = 0; i < this.tamPoblacion; i++) {
			double fitness_loc = this.poblacion[i].getFitness();
			puntuacion = (double) (fitness_loc / sum_fitness);
			puntuacion_acu += puntuacion;
			this.poblacion[i].setPuntuacion(fitness_loc / sum_fitness);
			this.poblacion[i].setPuntuacionAcu(puntuacion_acu);
		}
		
		
		if (elMejor.getFitness() > this.poblacion[pos_fitness_best].getFitness()) {
			elMejor = poblacion[pos_fitness_best].copiarCromosoma(); 
		}
		
		
		this.mediasGeneracion[this.generacionActual] = sum_fitness / this.tamPoblacion;
		this.mejoresGeneracion[this.generacionActual] = fitness_best;
		this.mejoresAbsolutos[this.generacionActual] = this.elMejor.getFitness();
	}

	private void seleccionaElite() {
		// TODO Auto-generated method stub
		
	}

	private void seleccionaPoblacion() {
		
		switch(tipo_seleccion) {
		case RULETA: 
			Ruleta ruleta = new Ruleta();
			this.poblacion = ruleta.seleccionRuleta(this.poblacion);
			break;
		default:
			Ruleta predet = new Ruleta();
			this.poblacion = predet.seleccionRuleta(this.poblacion);
			break;
		}
		
		// TODO Anyadir metodos seleccion
		
	}

	private void reproducePoblacion() {
		switch(tipo_cruce) {
		case CICLOS: 
			//EstocasticoUniversal estocastUniv = new EstocasticoUniversal(this.poblacion, this.tamPoblacion);
			//estocastUniv.seleccionEstocastico(this.funcion, this.precision, this.numGenes);
			break;
		default:
			break;
		}
		
		
		
	}

	public void incluyeElite() {
		// TODO Auto-generated method stub
		
	}

	public void aumentaGeneracion() {
		this.generacionActual++;
	}

	public Cromosoma getMejor() {
		return elMejor.copiarCromosoma();
	}

	public double[] getMejoresAbsolutos() {
		return this.mejoresAbsolutos;
	}

	public double[] getMejoresGeneracion() {
		return this.mejoresGeneracion;
	}

	public double[] getMedias() {
		return this.mediasGeneracion;
	}
	

	
	

}
