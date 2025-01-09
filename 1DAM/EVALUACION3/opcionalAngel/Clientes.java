
public class Clientes {
	
	private String nif;
	private String nombre;
	private String apellidos;
	private int edad;
	private double eurosPagados;
	
	Clientes(String nif,String nombre,String apellidos,int edad,double eurosPagados){
		this.nif=nif;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.edad=edad;
		this.eurosPagados=eurosPagados;
		
	}
	public String toString(){
	String temp="";
	temp="\n"+temp+"nif: "+nif+"\nnombre: "+nombre+"\napellidos: "+apellidos+"\nedad: "+edad+"\neurosPagados: "+eurosPagados;
	return temp;			
	}
	
}

