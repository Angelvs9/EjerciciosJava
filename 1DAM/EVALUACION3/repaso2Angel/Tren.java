public abstract class Tren {
	private String identificador;
	private int velocidadMaxima;
	private int velocidadActual;
	
	Tren(String identificador,int velocidadMaxima,int velocidadActual){
		this.identificador=identificador;
		this.velocidadMaxima=velocidadMaxima;
		this.velocidadActual=velocidadActual;
	}

	public void SetVelocidadMaxima(int velocidad){
			this.velocidadMaxima=velocidad;
	}

	public void SetVelocidadActual(int velocidad){
			this.velocidadActual=velocidad;
	}

	public int aumentarVelocidad(int velocidadExtra){
		int temp=0;
		if (velocidadActual+velocidadExtra<=velocidadMaxima)
		{
			temp=this.velocidadActual+velocidadExtra;
		}
		this.velocidadActual=temp;
		return temp;
	}

		
	public int disminuirVelocidad(int velocidadExtra){
		   int temp=0;
		   if (this.velocidadActual-velocidadExtra>0)
		   {
				temp=this.velocidadActual-velocidadExtra;
		   }
		   	this.velocidadActual=temp;
		   return temp;
	}
	
	public int getVelocidadMaxima() {
		return this.velocidadMaxima;
	}

	public int getVelocidadActual() {
		return this.velocidadActual;
	}


	public String toString() {
    return "Identificador: " + identificador + "\nVelocidad Maxima: " + velocidadMaxima + "\nVelocidad Actual: " + velocidadActual;
	}


}

