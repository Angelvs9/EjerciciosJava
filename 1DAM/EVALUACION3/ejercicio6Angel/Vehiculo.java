
public abstract class Vehiculo {
	
	private String matricula;	
	public static final int PRECIODIA = 50;
	
	Vehiculo(String matricula){
		this.matricula = matricula;
	}
	
	public double calcularPrecio(int dias){
		return PRECIODIA * dias;
	}
	
	public String toString(){
		String temp="{Matricula: " + matricula; 
		return temp;
	}
	
	public abstract int num_ruedas();
}

