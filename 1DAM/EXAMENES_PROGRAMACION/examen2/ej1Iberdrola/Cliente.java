
public class Cliente {
	
	private int ncontrato;
	private String cups;
	private String direccion;
	private String ciudad;
	private double cuenta_corriente;
	private double potencia_contratada;
	
	Cliente(int nc,String cups,String d,String c,double cc,double pc){
		ncontrato=nc;
		this.cups=cups;
		direccion=d;
		ciudad=c;
		cuenta_corriente=cc;
		potencia_contratada=pc;
	}
	
	Cliente(int nc,String d,String c,double cc,double pc){
		ncontrato=nc;
		direccion=d;
		ciudad=c;
		cuenta_corriente=cc;
		potencia_contratada=pc;
	}
	
	public double CalcularMes(double kw){
		return (potencia_contratada*kw)/15;
	}
	public double CalcularMes(double pc,double kw){
		return (pc*kw)/15;
	}
	
	public void SetPotencia_contratada(double p){
		potencia_contratada=p;
	}
	
	public void SetCups(String cups){
		this.cups=cups;
	}
	
	public String toString(){
		return "\nnumero cliente contrato: "+ncontrato+"\nCUPS: "+cups+"\ndireccion: "+direccion+"\nciudad: "+ciudad+"\nCuenta Corriente: "+ cuenta_corriente+"\npotencia Contratada: "+potencia_contratada;
	}
	
	
}

