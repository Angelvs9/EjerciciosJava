
public class coche {
	
	private String matricula;
	private String bastidor;
	private String modelo;
	private String marca;
	private double kmRecorridos;
	private static final int NPIEZAS=5;
	private static final int PRECIOHORA=50;
	private int contador=0;
	pieza [] vecPiezas;


	coche(String matricula,String bastidor,String modelo,String marca,double kmRecorridos){
		this.matricula=matricula;
		this.bastidor=bastidor;
		this.modelo=modelo;
		this.marca=marca;
		this.kmRecorridos=kmRecorridos;
		vecPiezas=new pieza[NPIEZAS];
	}
	
	coche(String matricula,String modelo,String marca){
		this.matricula=matricula;
		this.modelo=modelo;
		this.marca=marca;
		vecPiezas=new pieza[NPIEZAS];
	}
	public void anyadirPieza(pieza p){
				vecPiezas[contador]=p;
				contador++;
	}
	
	public double CosteReparacion(int horas){
		double temp=0;
		double h=horas*PRECIOHORA;
		for (int i = 0; i < NPIEZAS; i++)
		{
			if (vecPiezas[i]!=null)
			{
				temp+=vecPiezas[i].getPrecio();
			}
			
		}
		return temp+h;
		
		}
	
	
	
//----------------------------------------------------------------------------------------
	public void setBastidor(String bastidor){
		this.bastidor=bastidor;
	}
	public void setKmRecorridos(double kmRecorridos){
		this.kmRecorridos=kmRecorridos;
	}
	
	public String getModelo(){
		return modelo;
	}
	public String getMatricula(){
		return matricula;
	}
	
	public String toString(){
		String temp="";
		temp="----------------------------------------------\n"+temp+"matricula: "+matricula+"\nbastidor: "+bastidor+"\nmodelo: "+modelo+"\nmarca: "+marca+"\nkm recorridos: "+kmRecorridos+"\n\n";
		for (int i = 0; i < vecPiezas.length; i++)
		{
			if (vecPiezas[i]!=null)
			{
				temp=temp+vecPiezas[i]+" ";
			}
		}
		return temp+"\n";
	}

}

