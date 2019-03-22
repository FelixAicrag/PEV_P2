package utils;

import cromosoma.Cromosoma;

public class CorrespondeciaCiudades {
	
	public CorrespondeciaCiudades () {}
	
	public void printCromosoma(Cromosoma crom) {
		
		for(int i = 0; i < crom.getLongitud(); i++) {
			switch (crom.getGenes()[i]) {
			case 0:
				System.out.print(" ALBACETE ");
				break;
			case 1:
				System.out.print(" ALICANTE ");
				break;
			case 2:
				System.out.print(" ALMERIA ");
				break;
			case 3:
				System.out.print(" AVILA ");
				break;
			case 4:
				System.out.print(" BADAJOZ ");
				break;
			case 5:
				System.out.print(" BARCELONA ");
				break;
			case 6:
				System.out.print(" BILBAO ");
				break;
			case 7:
				System.out.print(" BURGOS ");
				break;
			case 8:
				System.out.print(" CACERES ");
				break;
			case 9:
				System.out.print(" CADIZ ");
				break;
			case 10:
				System.out.print(" CASTELLON ");
				break;
			case 11:
				System.out.print(" CIUDAD_REAL ");
				break;
			case 12:
				System.out.print(" CORDOBA ");
				break;
			case 13:
				System.out.print(" A_CORUNYA ");
				break;
			case 14:
				System.out.print(" CUENCA ");
				break;
			case 15:
				System.out.print(" GIRONA ");
				break;
			case 16:
				System.out.print(" GRANADA ");
				break;
			case 17:
				System.out.print(" GUADALAJARA ");
				break;
			case 18:
				System.out.print(" HUELVA ");
				break;
			case 19:
				System.out.print(" HUESCA ");
				break;
			case 20:
				System.out.print(" JAEN ");
				break;
			case 21:
				System.out.print(" LEON ");
				break;
			case 22:
				System.out.print(" LLEIDA ");
				break;
			case 23:
				System.out.print(" LOGRONYO ");
				break;
			case 24:
				System.out.print(" LUGO ");
				break;
			case 25:
				System.out.print(" MADRID ");
				break;
			case 26:
				System.out.print(" MALAGA ");
				break;
			case 27:
				System.out.print(" MURCIA ");
				break;
			}
		}
	}
}
