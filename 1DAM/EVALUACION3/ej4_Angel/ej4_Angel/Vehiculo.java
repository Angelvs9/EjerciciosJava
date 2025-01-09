
public abstract class Vehiculo {

	private String color;
	private String bastidor;
	private char cambio;
	private int peso;

	Vehiculo(String color,String bastidor,char cambio,int peso){
		this.color=color;
		this.bastidor=bastidor;
		this.cambio=cambio;	
		this.peso=peso;
	}
	
	public String getColor(){
		return color;
	}
	public String getbastidor(){
		return bastidor;
	}
	public char getCambio(){
		return cambio;
	}
	public int getPeso(){
		return peso;
	}
	
	
	public void setColor(String color){
		this.color=color;
	}
	public void setBastidor(String bastidor){
		this.bastidor=bastidor;
	}
	public void setCambio(char cambio){
		this.cambio=cambio;
	}
	public void setPeso(char peso){
		this.peso=peso;
	}
	
	public String toString(){
		return "peso: "+peso+"\ncolor: "+color+"\ncambio: "+cambio+"\nbastidor: "+bastidor;
		
	}
		
}

