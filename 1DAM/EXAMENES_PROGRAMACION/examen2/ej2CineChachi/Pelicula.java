
public class Pelicula {
	
	private String titulo;
	private String director;
	private String genero;
	private double duracion;
	
	Pelicula(String t,String d,String genero,double du){
		titulo=t;
		director=d;
		duracion=du;
		this.genero=genero;
	}
	
	
	public String getTitulo(){
		return titulo;
	}
	public String getGenero(){
		return genero;
	}
	
	public String toString(){
		return "\ntitulo: "+titulo+"\ndirector: "+director+"\ngenero: "+genero+"\nduracion: "+duracion+"\n";
	}
}

