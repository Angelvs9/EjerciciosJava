
public class Secretario extends Empleado {
	
	private String despacho;
	private int fax;
	
	Secretario(String nombre,String apellidos,String dni,String direccion,int anyosTrabajando,double salario,String despacho,int fax){
		super(nombre,apellidos,dni,direccion,anyosTrabajando,salario);
		this.despacho=despacho;
		this.fax=fax;
	}
	
	public double calcularSalario(){
		return super.Getsalario()*1.05;
	}
	
	
	public String toString(){
		String temp="";
		temp=super.toString()+"\ndespacho: "+despacho+"\nfax: "+fax+"\n";
		return temp+"}\n";
	}
	
}

