
public class Camion extends Vcarga {
	
	private static final int PRECIOPORCAMION = 40;//por ser camion
	private static final int NUMRUEDAS = 10;
	
	Camion(String matricula, double pma){
		super(matricula, pma);
	}
	
	public double calcularPrecio(int dias){
		return(super.calcularPrecio(dias) + PRECIOPORCAMION);//utiliza un meotod del padre y su padre dentro del metodo llama a su padre
	}
	
	public int num_ruedas(){
		return NUMRUEDAS; 
	}

	
	public String toString(){
		return super.toString() + "}";
	}
}

