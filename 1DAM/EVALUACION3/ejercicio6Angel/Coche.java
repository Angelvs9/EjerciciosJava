

public class Coche extends Vpersona {
	
	private int plazas;
	private static final int NUMRUEDAS = 5;
	
	Coche(String matricula, int plazas){
		super(matricula);
		this.plazas = plazas;
	}
	
	public double calcularPrecio(int dias){
		return (super.calcularPrecio(dias,plazas));
	}
	
	public int num_ruedas(){
		return NUMRUEDAS; 
	}
	
	public String toString(){
		return super.toString() + ", Plazas: " + plazas + "}";
	}
	
	
}

