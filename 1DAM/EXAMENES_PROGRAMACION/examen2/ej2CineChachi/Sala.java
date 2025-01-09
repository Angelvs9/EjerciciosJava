

public class Sala {
	
	private String nombre;
	private String ciudad;
	private String direccion;
	Pelicula [] cartelera;
	
	Sala(String n,String c,String direc,int numer){
		nombre=n;
		ciudad=c;
		direccion=direc;
		cartelera=new Pelicula[numer];
	}
	
	Sala(String c,int in){
		ciudad=c;
		cartelera=new Pelicula[in];
	}
	
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String g){
		nombre=g;
	}
	
	private boolean TituloRepetido(Pelicula p){
		boolean repetido=false;
		if (p!=null)
			for (int i = 0; i < cartelera.length; i++)
				if (cartelera[i]!=null && cartelera[i].getTitulo().equals(p.getTitulo()))
					repetido=true;
			
		
		return repetido;
	}
	
	public boolean eliminarPelicula(String t){
		boolean eliminado=false;
		for (int i = 0; i < cartelera.length; i++){
			if (cartelera[i]!=null && cartelera[i].getTitulo().equals(t)){
				eliminado=true;
				cartelera[i]=null;
			}
		}
		return eliminado;
	}
	
	public int peliculasDeTipo(String genero){
		boolean b=false;
		int contador=0;
		for (int i = 0; i < cartelera.length; i++)
			if (cartelera[i].getGenero().equals(genero))
				contador++;
			
		return contador;
	}
	
	public boolean eliminarPeliculaGenero(String t){
		boolean eliminado=false;
		for (int i = 0; i < cartelera.length; i++){
			if (cartelera[i]!=null && cartelera[i].getGenero().equals(t)){
				eliminado=true;
				cartelera[i]=null;
			}
		}
		return eliminado;
	}
	
	
	public boolean anyadirPelicula(String titulo,String direc,double duracion,String genero){
		boolean booleano=false;
		Pelicula temp=new Pelicula(titulo,direc,genero,duracion);
		if(temp!=null)
			for (int i = 0; i < cartelera.length; i++)
				if (booleano==false && cartelera[i]==null && TituloRepetido(temp)==false)
				{
					booleano=true;
					cartelera[i]=temp;
				}
		return booleano;
	}
	
	
	
	public String toString(){
		String temp="";
		for (int i = 0; i < cartelera.length; i++)
			if(cartelera[i]!=null)
				temp+=cartelera[i];
		return "\nnombre: "+nombre+"\nciudad: "+ciudad+"\ndireccion: "+direccion+"\n----------------Peliculas en cartelera:----------------\n"+temp;
	}
	
	
}

