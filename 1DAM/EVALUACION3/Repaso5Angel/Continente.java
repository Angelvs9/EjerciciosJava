
public class Continente extends Territorio{
	
	private static final double COEFICIENTE=0.876;
	private int nPaises;
	
	Continente(String nombre,int nh,double s,int np){
		super(nombre,nh,s);
		nPaises=np;
	}
	
	public double calcularDesplazamientoContinente(double derivaAnyo,int anyos){
		return (derivaAnyo*anyos)/(COEFICIENTE*super.getSuperficie());
	}
	
	public void setnPaises(int n){
		nPaises=n;
	}
	public int getnPaises(){
		return nPaises;
	}
	public String toString(){
		return super.toString()+" numero Paises"+nPaises;
	}
	
}

