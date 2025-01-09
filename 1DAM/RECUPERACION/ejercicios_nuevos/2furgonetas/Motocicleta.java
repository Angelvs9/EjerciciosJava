
public class Motocicleta {
	
	private String color;
	private double cilindrada;
	private boolean haycaja;
	
	Motocicleta(String c,double cc, boolean caja){
		color=c;
		cilindrada=cc;
		haycaja=caja;
	}
	Motocicleta(double cc, boolean caja){
		color="roja";
		cilindrada=cc;
		haycaja=caja;
	}
/*no tiene setters porque no se pueden modificar los datos ya que no son de la empresa*/
	public String getColor(){
		return color;
	}
	public double getCilindrada(){
		return cilindrada;
	}
	public boolean getHaycaja(){
		return haycaja;
	}

	public String toString(){
		return "\ncolor: "+color+"\ncilidrada: "+cilindrada+"\nhay caja?: "+haycaja;
	}
}

