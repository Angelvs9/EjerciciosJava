
public class Zanahoria {
	private String color;
	private int numero;

	Zanahoria(int n){
		color="naranja";
		numero=n;
	}
	
	public int getNumero(){
		return numero;
	}
	
	public String toString(){
		return "\ncolor: "+color;
	}
}

