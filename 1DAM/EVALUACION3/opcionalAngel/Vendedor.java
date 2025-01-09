
public class Vendedor extends Empleado {
	private String areaVenta;
	private double porcentajePorVenta;
	private Coche[] vecCoche;
	private Clientes[] vecClientes;
	private static final int COCHES=1;
	private static final int CLIENTES=2;

	Vendedor(String nombre,String apellidos,String dni,String direccion,int anyosTrabajando,double salario){
		super(nombre,apellidos,dni,direccion,anyosTrabajando,salario);
		vecCoche=new Coche[COCHES];
		vecClientes=new Clientes[CLIENTES];
	}
	
	public boolean darAltaCliente(Clientes c){
		boolean booleano=false;
		int contador=0;
		for (int i = 0; i < vecClientes.length; i++)
		{
			if (vecClientes[i]==null && contador==0)
			{
				vecClientes[i]=c;
				booleano=true;
				contador++;
			}
		}	
		return booleano;
	}
	
	public boolean darBajaCliente(Clientes c){
		boolean booleano=false;
		for (int i = 0; i < vecClientes.length; i++)
		{
			if (vecClientes[i]==c)
			{
				vecClientes[i]=null;
				booleano=true;
			}
		}	
		return booleano;
	}
	
	public void cambiarCoche(Coche c){
		vecCoche[0]=c;
	}
	
	public Clientes ImprimirCliente(int indice){
		return vecClientes[indice];
	}
	
	public Coche ImprimirCoche(){
		return vecCoche[0];
	}
	
	public double calcularSalario(){
		return super.Getsalario()*1.10;
	}

	
	
	
	
	public String toString(){
		String temp="";
		temp=super.toString()+"\ncoche:{\n"+vecCoche[0]+"\nclientes{\n"+vecClientes[0];

		for (int i = 0; i < vecClientes.length; i++)
		{
			if (vecClientes[i]!=null)
			{
				temp=temp+vecClientes[i];
			}
			
		}
		return temp+"}";
		
	}
	
	
}

