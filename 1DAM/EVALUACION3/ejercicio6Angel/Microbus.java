

public class Microbus extends Vpersona {
	
	private int plazas;
	private static final int PRECIOPORPLAZA = 2;
	private static final int NUMRUEDAS = 7;
	
	Microbus(String matricula, int plazas){
		super(matricula);
		this.plazas = plazas;
	}
	
	public double calcularPrecio(int dias){
		double temp1=PRECIOPORPLAZA * plazas;
		return (super.calcularPrecio(dias, plazas) + temp1);
	} 
	
	public int num_ruedas(){
		return NUMRUEDAS; 
	}
	
	public String toString(){
		return super.toString() + ", Plazas: " + plazas + "}";
	}
}

