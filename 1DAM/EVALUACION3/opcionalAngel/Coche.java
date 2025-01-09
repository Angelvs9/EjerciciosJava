
public class Coche {
	
	private String matricula;
	private String marca;
	private String modelo;
	
	Coche(String matricula,String marca,String modelo){
		this.matricula=matricula;
		this.marca=marca;
		this.modelo=modelo;
	}
	
	public String toString(){
	String temp="";
	temp=temp+"matricula: "+matricula+"\nmarca: "+marca+"\nmodelo: "+modelo;
	return temp;
	}
	
}

