
public class main {
	
	public static void main (String[] args) {
		Sala cinesa =new Sala("cs",5);
		Sala cinesSalera=new Sala("cinesaa","cs","direccion",11);
		System.out.println(cinesSalera.anyadirPelicula("tirurlo","direccion",1.5,"fantasia"));
		System.out.println(cinesSalera.anyadirPelicula("tirurlo","direccion",1.5,"fantasia"));
		//la segunda no porque esta repetida
		System.out.println(cinesSalera.anyadirPelicula("sam","direccion",1.5,"fantasia"));
		System.out.println(cinesSalera.anyadirPelicula("paco","direccion",1.5,"fantasia"));
		System.out.println(cinesSalera.anyadirPelicula("lamonja","direccion",1.5,"terror"));
		
		System.out.println(cinesSalera.toString());
		
		System.out.println(cinesSalera.eliminarPelicula("sam"));
		System.out.println(cinesSalera.toString());
		/*elimino las peliculas de fantasia*/
		System.out.println(cinesSalera.eliminarPeliculaGenero("fantasia"));
		System.out.println(cinesSalera.toString());
	}
}

