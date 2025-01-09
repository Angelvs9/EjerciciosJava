

public class Coche {
	
	private int nruedas;
	private String color;
	private String marca;
	private double peso;
	private double km;

	Coche(int r,String c,double p,String m,double km){
		nruedas=r;
		color=c;
		peso=p;
		marca=m;
		this.km=km;
	}
	
	public void conducir(double km){
			this.km+=km;
	}
	public String toString(){
		return "numero ruedas:"+nruedas+" color: "+color+" marca: "+marca+" peso:"+peso+" km:"+km;
	}
	
	
}

