public class Pasajeros extends Tren{
	private int maximoPasajeros;
	private int asientosLibres;
	private boolean comedor;
	private String [] vagonPasajeros;
	private static final int NMAXVAGONES=20;
	
	Pasajeros(String identificador,int velocidadMaxima,int velocidadActual,int maximoPasajeros,int asientosLibres,boolean comedor){
		super(identificador,velocidadMaxima,velocidadActual);
		this.maximoPasajeros=maximoPasajeros;
		this.asientosLibres=asientosLibres;
		this.comedor=comedor;
		vagonPasajeros=new String[NMAXVAGONES];
	}


	public boolean reservarAsiento(String dni){
			for (int i = 0; i < vagonPasajeros.length; i++)
			{
				if (vagonPasajeros[i]==null)
				{
					vagonPasajeros[i]=dni;
					asientosLibres--;
					return true;
				}
			}
		return false;
	}
	public boolean cancelarAsiento(String dni){
			for (int i = 0; i < vagonPasajeros.length; i++)
			{
				if (vagonPasajeros[i].equals(dni))
				{
					vagonPasajeros[i]=null;
					asientosLibres++;
					return true;
				}
			}
		return false;
	}
	
	public int getAsientosLibres() {
		return asientosLibres;
	}	



	public String toString(){
		return super.toString()+"\nMaximo de pasajeros permitidos: "+ maximoPasajeros + "\nAsientos Libres: " + asientosLibres + "\nComedor: " + comedor+"\n";
	}

}

