
public class Camiones extends Vehiculos{
	private static final double EXTRACAMIONES=40;
	
	Camiones(String matricula){
		super(matricula);
	}


	public double calcularAlquilerCamiones(int dias){
		double temp;
		temp=(getPRECIOBASE()*dias)+EXTRACAMIONES;
		return temp;
	}


}

