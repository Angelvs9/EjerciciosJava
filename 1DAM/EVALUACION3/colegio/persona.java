
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
	
	public void setNombre(String n)
	{
		nombre=n;
	}
	public void setApellidos(String a)
	{
		apellidos=a;
	}
	public void setEdad(int e)
	{
		edad=e;
	}
	public String getNombre()
	{
		return nombre;
	}
	public String getApellidos()
	{
		return apellidos;
	}
	public int getEdad()
	{
		return edad;
	}
	
	
}

