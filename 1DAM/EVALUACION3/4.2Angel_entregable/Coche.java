
public class Coche extends Vehiculos{
	private static final double EXTRACOCHE=1.5;
	
	
	Coche(String matricula){
		super(matricula);
	}


	public double calcularAlquilerCoche(int dia){
		double temp;
		temp=(getPRECIOBASE()+EXTRACOCHE)*dia;
		return temp;
	}


}

