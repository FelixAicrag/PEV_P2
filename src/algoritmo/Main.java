package algoritmo;

import javax.swing.JPanel;

import org.math.plot.*;

import cromosoma.Cromosoma;
import cruce.Ciclos;
import vista.Vista;


public class Main {
	
	public static Plot2DPanel plot;

	public static void main(String[] args) {
		
		Cromosoma[] poblacion = new Cromosoma[2];
		
		for(int i =0 ; i < 2; i++) {
			poblacion[i] = new Cromosoma();
			poblacion[i].generarCromosomaRandom();
			poblacion[i].print();
		}
		
		Ciclos ci = new Ciclos();
		
		ci.cruzarGenes(poblacion[0], poblacion[1]);
		
		poblacion[0].print();
		poblacion[1].print();
		
		
		/*
		 Vista vista = new Vista();
	        

	        JPanel grafica = vista.getGraficaPanel();

	        // create your PlotPanel (you can use it as a JPanel)
	        plot = new Plot2DPanel();

	        
	        plot.setSize(grafica.getWidth(),grafica.getHeight());
	        
	        // define the legend position
	        plot.addLegend("SOUTH");
	        
	        grafica.add(plot);
	            
	        vista.setVisible(true);
		
		// TODO Auto-generated method stub 
		 * */
	}
	
	

}
