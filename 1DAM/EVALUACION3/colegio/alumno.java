public class alumno extends persona {
	
	private String ciclo;
	private int curso;
	private boolean online;
	
	alumno(String nombre,String apellidos,int edad,String ciclo,int curso,boolean online)
	{
		super(nombre,apellidos,edad);
		this.ciclo=ciclo;
		this.curso=curso;
		this.online=online;
	}
	
	public void setCiclo(String c)
	{
		ciclo=c;
	}
	public void setOnline(boolean o)
	{
		online=o;
	}
	public void setCurso(int c)
	{
		curso=c;
	}
	
	public String getCiclo()
	{
		return ciclo;
	}
	public boolean getOnline()
	{
		return online;
	}
	public int getCurso()
	{
		return curso;
	}
	
	public int ver_precio()
	{
		if(online)
			return 100;
		else
			return 200;
	}
}

