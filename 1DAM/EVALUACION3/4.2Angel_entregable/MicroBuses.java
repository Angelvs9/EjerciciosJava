
public class MicroBuses extends Vehiculos{
	private static final double EXTRABUS=2;
	
	MicroBuses(String matricula){
		super(matricula);
	}


	public double calcularAlquilerBus(int plazasOcupadas){
		double temp;
		temp=getPRECIOBASE()+(EXTRABUS*plazasOcupadas);
		return temp;
	}


}

