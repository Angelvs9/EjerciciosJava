
public abstract class Empleado {
	
	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;
	private int anyosTrabajando;
	private int telefono;
	private double salario;
	private static final int NSUPERVISORES=1;
	private Empleado[] vecSupervisor;
	
	Empleado(String nombre,String apellidos,String dni,String direccion,int anyosTrabajando,double salario){
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.dni=dni;
		this.direccion=direccion;
		this.anyosTrabajando=anyosTrabajando;
		this.telefono=telefono;
		this.salario=salario;
		vecSupervisor=new Empleado[NSUPERVISORES];
	}
	
	public void cambiarSupervisor(Empleado e){
		vecSupervisor[0]=e;
	}
	
	public double Getsalario(){
		return salario;
	}
	

	public abstract double calcularSalario();
	
	
	
	public String toString(){
	String temp="";
	temp="\nnombre: "+nombre+"\napellidos: "+apellidos+"\ndni: "+dni+"\ndireccion: "+direccion+"\nanyosTrabajados: "+anyosTrabajando+"\nsalario: "+salario;
	if (vecSupervisor[0]!=null)
	{
		temp=temp+"\nSupervisor de este empleado:{"+vecSupervisor[0]+"}\n";
	}
	return temp;			
	}
	
	
}

