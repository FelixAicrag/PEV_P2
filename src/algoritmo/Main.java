package algoritmo;

import javax.swing.JPanel;

import org.math.plot.*;
import utils.*;

import cromosoma.Cromosoma;
import cruce.Ciclos;
import vista.Vista;


public class Main {
	
	public static Plot2DPanel plot;

	public static void main(String[] args) {

		 Vista vista = new Vista();
	        

	        JPanel grafica = vista.getGraficaPanel();

	        // create your PlotPanel (you can use it as a JPanel)
	        plot = new Plot2DPanel();

	        
	        plot.setSize(grafica.getWidth(),grafica.getHeight());
	        
	        // define the legend position
	        plot.addLegend("SOUTH");
	        
	        grafica.add(plot);
	            
	        vista.setVisible(true);
	        
		
			/*
			
			AlgoritmoGenetico ag = new AlgoritmoGenetico(TipoSeleccion.RESTOS, TipoCruce.CICLOS, TipoMutacion.HEURISTICA, 20, 1, 0.0, 0.0, 0.0, 0.0);
			
			ag.inicializaPoblacion();
			ag.evaluaPoblacion();
			
			for(int i =0 ; i < ag.poblacion.length; i++) {
				ag.poblacion[i].print();
			}
			
			System.out.println("NUEVOS:");
			
			for (int i = 0; i < ag.numGeneraciones; i++) {
				ag.seleccionaElite();
				
				ag.seleccionaPoblacion();
				ag.reproducePoblacion();
				
				ag.incluyeElite();
	                     
				ag.evaluaPoblacion();
				ag.aumentaGeneracion();
			}
			
			
			
			for(int i =0 ; i < ag.poblacion.length; i++) {
				ag.poblacion[i].print();
			}
			*/
	}
	
	

}
