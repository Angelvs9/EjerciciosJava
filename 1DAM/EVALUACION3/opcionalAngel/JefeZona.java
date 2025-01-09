
public class JefeZona extends Empleado{
	Coche [] vecCoche;
	Secretario [] vecSecretario;
	Vendedor[] vecVendedores;
	private static final int NCOCHE=1;
	private static final int NSECRETARIO=1;
	private static final int NVENDEDORES=2;
	private String despacho;
	
	JefeZona(String nombre, String apellidos, String dni, String direccion, int anyosTrabajando, double salario,String despacho) {
		super(nombre, apellidos, dni, direccion, anyosTrabajando, salario);
		vecCoche=new Coche[NCOCHE];
		vecSecretario=new Secretario[NSECRETARIO];
		vecVendedores=new Vendedor[NVENDEDORES]; 
		this.despacho=despacho;
	 }
	 
	 public void cambiarSecretario(Secretario s){
		vecSecretario[0]=s;
	 }
	 
	 public boolean altaVendedor(Vendedor v){
		boolean booleano=false;
		int contador=0;
		for (int i = 0; i < vecVendedores.length; i++){
			if (vecVendedores[i]==null && contador==0){
					vecVendedores[i]=v;
					booleano=true;
					contador++;
			}
		}	
		return booleano;//una vez lleno hasta que des de baja no se podrá poner otro
	 }

	 	 
	 public boolean bajaVendedor(Vendedor v){
		boolean booleano=false;
		for (int i = 0; i < vecVendedores.length; i++)
			if (vecVendedores[i].equals(v))
				vecVendedores[i]=v;
				booleano=true;
				
		return booleano;			
	 }
	 public void cambiarCoche(Coche c){
		vecCoche[0]=c;
	}
	 
	 
	 
	public double calcularSalario(){
		return super.Getsalario()*1.20;
	} 
	 
	 
	 
	 
	public String toString(){
		String temp="";
		temp=super.toString()+"\ndespacho: "+despacho+"\nSecretario:{\n"+vecSecretario[0]+"\n"+"Coche del Jefe de zona \n"+vecCoche[0]+"\nvendedores:{\n";
		for (int i = 0; i < vecVendedores.length; i++)
			temp=temp+"\n"+vecVendedores[i]+"\n";
			
		return temp+"}";
		
		
	}
	 
	 
	 
}

