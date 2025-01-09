

public abstract class Vpersona extends Vehiculo {
	public static final double PRECIODIAVP = 1.5;
	
	Vpersona(String matricula){
		super(matricula);
	}
	
	public double calcularPrecio(int dias, int plazas){
		double temp1=PRECIODIAVP * plazas;
		double temp2=PRECIODIAVP * dias;
		return (super.calcularPrecio(dias) + temp2+temp1 );
	}
	
	public String toString(){
		return super.toString();
	}
	
}

