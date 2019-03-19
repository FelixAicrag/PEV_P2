package algoritmo;

import java.util.ArrayList;

import cromosoma.Cromosoma;
import utils.Distancias;
import utils.TipoCruce;
import utils.TipoSeleccion;

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
	double[] mediasGeneracion;
	double[] mejoresGeneracion;
	double[] mejoresAbsolutos;
	
	double mediaGeneracion;
	double mejorGeneracion;
	double mejorAbsoluto;

	
	public static int MADRID = 25;

	public AlgoritmoGenetico(TipoSeleccion tipo_seleccion, TipoCruce tipo_cruce,
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
	
	public int fitness(Cromosoma individuo) {
		Distancias dist = new Distancias();
		int valor = dist.getDistancia(MADRID, individuo.getGenes()[0]) +
				dist.getDistancia(MADRID, individuo.getGenes()[individuo.getLongitud()-1]);
		
		for(int i = 0; i < individuo.getLongitud() -1; i++) {
			valor += dist.getDistancia(individuo.getGenes()[i], individuo.getGenes()[i+1]);
		}
		
		return valor;
	}

	public void inicializaPoblacion() {
		for(int i = 0; i < tamPoblacion; i++) {
			this.poblacion[i] = new Cromosoma();
			this.poblacion[i].generarCromosomaRandom();
		}
		
		this.elMejor = duplicarCromosoma(this.poblacion[0]);
        fitness(elMejor);
        this.generacionActual = 0;
	}

	private Cromosoma duplicarCromosoma(Cromosoma c) {
	    Cromosoma nuevo = new Cromosoma();
	    
	        nuevo.setFitness(c.getFitness());
	        nuevo.setGenes(c.getGenes());
	        nuevo.setPuntuacionAcu(c.getPuntuacionAcu());
	                
	    	return nuevo;
	    }

	public void evaluaPoblacion() {
		int fitness, fitness_best, sum_fitness = 0;
		int pos_fitness_best = 0;
		fitness_best = fitness(this.poblacion[0]);
		
		for(int i = 0; i < tamPoblacion; i++) {
			fitness = fitness(this.poblacion[i]);
			
			if(fitness < fitness_best) { fitness_best = fitness; pos_fitness_best = i; }
			sum_fitness += fitness;
			this.poblacion[i].setFitness(fitness);
		}
		
		double puntuacion = 0, puntuacion_acu = 0;
		
		for(int i = 0; i < this.tamPoblacion; i++) {
			puntuacion = fitness(this.poblacion[i]) / sum_fitness;
			puntuacion_acu += puntuacion;
			this.poblacion[i].setPuntuacion(puntuacion);
			this.poblacion[i].setPuntuacionAcu(puntuacion_acu);
		}
		
		
		if (elMejor.getFitness() > this.poblacion[pos_fitness_best].getFitness()) {
			elMejor = this.duplicarCromosoma(poblacion[pos_fitness_best]); 
		}
		
		
		this.mediasGeneracion[this.generacionActual] = sum_fitness / this.tamPoblacion;
		this.mejoresGeneracion[this.generacionActual] = fitness_best;
		this.mejoresAbsolutos[this.generacionActual] = this.elMejor.getFitness();
	}

	public void seleccionaElite() {
		// TODO Auto-generated method stub
		
	}

	public void seleccionaPoblacion() {
		
		switch(tipo_seleccion) {
		case ESTOCASTICO: 
			EstocasticoUniversal estocastUniv = new EstocasticoUniversal(this.poblacion, this.tamPoblacion);
			estocastUniv.seleccionEstocastico(this.funcion, this.precision, this.numGenes);
			break;
		case RESTOS: 
			Restos restos = new Restos(this.poblacion, this.tamPoblacion, 0, 0);
			restos.seleccionRestos();
			break;
		case RULETA: 
			Ruleta ruleta = new Ruleta(this.poblacion, this.tamPoblacion);
			ruleta.seleccionRuleta();
			break;
		case TORNEO:
			Torneos torneos = new Torneos(this.poblacion, this.tamPoblacion);
			torneos.seleccionTorneos(this.funcion, this.precision, this.numGenes);
			break;	
		default:
			Ruleta r = new Ruleta(this.poblacion, this.tamPoblacion);
			r.seleccionRuleta();
			break;
		}
		
		// TODO Auto-generated method stub
		
	}

	public void reproducePoblacion() {
		// TODO Auto-generated method stub
		
	}

	public void incluyeElite() {
		// TODO Auto-generated method stub
		
	}

	public void aumentaGeneracion() {
		// TODO Auto-generated method stub
		
	}

	public Object getMejor() {
		// TODO Auto-generated method stub
		return null;
	}

	public double[] getMejoresAbsolutos() {
		// TODO Auto-generated method stub
		return null;
	}

	public double[] getMejoresGeneracion() {
		// TODO Auto-generated method stub
		return null;
	}

	public double[] getMedias() {
		// TODO Auto-generated method stub
		return null;
	}

}
