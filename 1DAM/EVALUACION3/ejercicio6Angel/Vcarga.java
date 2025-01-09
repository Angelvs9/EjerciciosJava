

public abstract class Vcarga extends Vehiculo {
	
	private double pma;
	private static final int PMA = 20;
	
	Vcarga(String matricula, double pma){
		super(matricula);
		this.pma = pma;
	}
	
	public double calcularPrecio(int dias){
		double precioBase = super.calcularPrecio(dias);//metodo del padre
		return ( precioBase + pma * PMA);
	}
	
	public String toString(){
		String temp=super.toString() + ",PMA: " + this.pma;
		return temp;
	}
}

