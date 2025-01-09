public class digestivo extends medico{
	private static final int COMISION=20;
	private String nombreEnfermera;
	digestivo(String nombre,double precioVisita,int nmaxPacientes,boolean tarde,int nColegiado,String nombreEnfermera){
		super(nombre,precioVisita,nmaxPacientes,tarde,nColegiado);
		this.nombreEnfermera=nombreEnfermera;
	}
		
	public double calcularCobrado(double precioVisita,double nvisitasAtendidas){
		return precioVisita*nvisitasAtendidas;
	}	
		
	public double calcularComision(double precioVisita){
		return (precioVisita*COMISION)/100;
	}		
	public double calcularFacturacionTotal(int dias,double precioVisita,int pacientes){
		double temp=pacientes*precioVisita;
		return temp*dias;
	}
		
	public double calcularComisionTotal(double precioVisita,int nTotalVisitas)	{
		double temp=(precioVisita*COMISION)/100;
		return temp*nTotalVisitas;
	}		
	public int getCOMISION(){
		return COMISION;
	}	
	
	public String toString(){
		return super.toString()+" enfermera: "+nombreEnfermera +" Comision: "+COMISION+" %\n";
	}
	
	
			
		
}

