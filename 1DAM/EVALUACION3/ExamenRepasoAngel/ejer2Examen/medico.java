
public abstract class medico {
	
	private String nombre;
	private double precioVisita;
	private int nmaxPacientes;
	private boolean tarde=false;
	private int nColegiado;
	
	
	medico(String nombre,double precioVisita,int nmaxPacientes,boolean tarde,int nColegiado){
		this.nombre=nombre;
		this.precioVisita=precioVisita;
		this.nmaxPacientes=nmaxPacientes;
		this.tarde=tarde;
		this.nColegiado=nColegiado;	
	}
	
	public abstract double calcularCobrado(double precioVisita,double nvisitasAtendidas);
	public abstract double calcularComision(double precioVisita);
	
	public String toString(){
		String temp="";
		temp=temp+"nombre: "+nombre+"\nPrecio por visita: "+precioVisita+"\nnumero maximo de pacientes: "+nmaxPacientes+"\ntrabaja por la tarde:"+tarde+"\nnumero de colegiado: "+nColegiado;
		return temp+"\n";
		
	}
	
	
	
	
	
}

