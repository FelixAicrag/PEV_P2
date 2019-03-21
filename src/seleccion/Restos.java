package seleccion;


public class Restos {
	/*
	Cromosoma[] poblacion_original, poblacion_nueva;
	int tamPob, indSel;
	double prob;
	
	public Restos(Cromosoma[] pob, int tamPob, double prob, int indSel) {
		this.pob = pob;
		this.nuevaPob = new Cromosoma[tamPob];
		this.tamPob = tamPob;
		this.prob = prob;
		this.supervivientes = new int[this.tamPob];
		this.indSeleccionados = indSel;
	}
	
	public void seleccionRestos() {
		int posIndividuo = (int) (Math.random() * this.tamPob) + 1;
		int numCopias = (int) this.prob * this.indSeleccionados;
		
		boolean[] crom = this.pob[posIndividuo].getCromosoma();
		
		for(int i = 0; i < numCopias; i++) {
			this.nuevaPob[i].setCromosoma(crom);
		}
		
		int tamRestante = this.tamPob - numCopias;
		
		Ruleta r = new Ruleta(this.pob, tamRestante);
		r.seleccionRuleta();
		
		int k = 0;
		for(int j = numCopias; j < this.tamPob; j++) {
			this.nuevaPob[j].setCromosoma(this.pob[k].getCromosoma());
			k++;
		}
		
		this.pob = this.nuevaPob;
	}
	*/
}
