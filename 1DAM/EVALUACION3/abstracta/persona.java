
public abstract class persona {
	private String nombre;
	private String apellidos;
	private int edad;
	
	persona(String n,String a, int e)
	{
		nombre=n;
		apellidos=a;
		edad=e;
	}
	
	public String toString(){
		return "Nombre:"+nombre+" Apellidos:"+apellidos+" Edad:"+edad;
	}
	
	public int getEdad(){
		return edad;
	}
	
	public abstract boolean esNini();
	
}

