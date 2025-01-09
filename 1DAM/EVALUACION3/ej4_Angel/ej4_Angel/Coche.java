
public class Coche extends Vehiculo{
	private String modelo;
	private String marca;
	private int puertas;
	private int cilindrada;
	
	Coche(String color,String bastidor,char cambio,String modelo,String marca,int puertas,int cilindrada,int peso){
		super(color,bastidor,cambio,peso);
		this.modelo=modelo;
		this.marca=marca;
		this.puertas=puertas;
		this.cilindrada=cilindrada;
	}

	public String getModelo(){
		return modelo;
	}
	public String getMarca(){
		return marca;
	}
	public int getPuertas(){
		return puertas;
	}
	public int getCilindrada(){
		return cilindrada;
	}
	
	public void setModelo(String m){
		modelo=m;
	}
	public void setMarca(String marca){
		this.marca=marca;
	}
	public void setCilindrada(char cilindrada){
		this.cilindrada=cilindrada;
	}
	public void setPuertas(int p){
		puertas=p;
	}


	public String toString(){
		String temp="";
		temp=temp+"marca: "+marca+"\nmodelo: "+modelo+"\n"+super.toString()+"\ncilindrada: "+cilindrada+"\npuertas: "+puertas;
		return temp;
	}

}

