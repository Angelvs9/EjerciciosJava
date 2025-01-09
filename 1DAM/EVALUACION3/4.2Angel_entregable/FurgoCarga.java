
public class FurgoCarga extends Vehiculos{
	private static final double EXTRACARGA=20;
	
	FurgoCarga(String matricula){
		super(matricula);
	}


	public double calcularAlquilerfurgoCarga(double PMA){
		double temp;
		temp=(getPRECIOBASE()+EXTRACARGA)*PMA;
		return temp;
	}


}

