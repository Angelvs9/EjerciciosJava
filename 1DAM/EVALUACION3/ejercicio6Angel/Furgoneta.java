

public class Furgoneta extends Vcarga {
	
	private static final int NUMRUEDAS = 6;
	
	Furgoneta(String matricula, double pma){
		super(matricula, pma);
	}
	
	public double calcularPrecio(int dias){
		return(super.calcularPrecio(dias));
	}
	
	public int num_ruedas(){
		return NUMRUEDAS; 
	}
	
	public String toString(){
		return super.toString() + "}";
	}
}

