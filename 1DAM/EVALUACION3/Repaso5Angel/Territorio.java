
public class Territorio {
	
	private String nombre;
	private int nHabitantes;
	private double superficie;
	
	Territorio(String nombre,int nh,double s){
		this.nombre=nombre;
		nHabitantes=nh;
		superficie=s;
	}
	
	
	public void setNombre(String n){
		nombre=n;
	}
	public String getNombre(){
		return nombre;
	}
	
	public void setnHabitantes(int n){
		nHabitantes=n;
	}
	public void setSuperficie(double s){
		superficie=s;
	}
	public int getnHabitantes(){
		return nHabitantes;
	}
	public double getSuperficie(){
		return superficie;
	}
	
	public String toString(){
		return "\nNombre: "+nombre+" numero Habitantes: "+nHabitantes+" superficie: "+superficie+"\n";	
	}
}

