public class cabezera extends medico{
	private static final int COMISION=10;
	
	cabezera(String nombre,double precioVisita,int nmaxPacientes,boolean tarde,int nColegiado){
		super(nombre,precioVisita,nmaxPacientes,tarde,nColegiado);
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
		return super.toString()+" Comision: "+COMISION+" %\n";
	}
	
}

