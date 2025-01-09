public abstract class alumno extends persona {
	
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
	
	
	
	public String toString(){
		return super.toString()+" Ciclo:"+ciclo+" Curso:"+curso+" Online:"+online;
	}
}

