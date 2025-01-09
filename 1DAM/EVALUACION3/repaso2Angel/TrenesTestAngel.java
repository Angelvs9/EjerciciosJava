public class TrenesTestAngel {
	private static final int LONGITUD=3;
	
	public static void main (String[] args) {
		Tren [] vectorTrenPasajeros=new Pasajeros[LONGITUD];
		Tren [] vectorTrenMercancias=new Mercancias[LONGITUD];
		
		Pasajeros trenpasajeros1=new Pasajeros("trenpasajeros",250,90,80,100,true);
		Mercancias trenmercancias1=new Mercancias("trenmercancias",250,90,300.3,25,450);
		
		vectorTrenPasajeros[0]=trenpasajeros1;
		vectorTrenPasajeros[1] = new Pasajeros("TrenRapido", 300, 150, 131, 14, false);
		vectorTrenPasajeros[2] = new Pasajeros("TrenLocal", 180, 80, 60, 20, true);
		
		//en el primero de mercancias intento que hayan mas de 20 vagones pero como maximo pondrá 20
		vectorTrenMercancias[0]=trenmercancias1;
		vectorTrenMercancias[1] = new Mercancias("carguero", 200, 80, 400.5, 10, 500);
		vectorTrenMercancias[2] = new Mercancias("trenpesado", 180, 70, 250.8, 18, 600);


		System.out.println("trenes de pasajeros");
		System.out.println("__________________________\n");
		for (int i = 0; i < vectorTrenPasajeros.length; i++)
		{
			System.out.println(vectorTrenPasajeros[i]);
		}
		System.out.println("__________________________");


		System.out.println("trenes de mercancias");
		System.out.println("__________________________\n");
		for (int i = 0; i < vectorTrenMercancias.length; i++)
		{
			System.out.println(vectorTrenMercancias[i]);
		}
		
		System.out.println("__________________________");
		System.out.println("trenpasajeros1");
		if (trenpasajeros1.reservarAsiento("52697485G")==true)
		{
			System.out.println("\n"+"has reservado asiento 52697485G"+" hay libres:"+trenpasajeros1.getAsientosLibres());
		}
		if (trenpasajeros1.reservarAsiento("43279119S")==true)
		{
			System.out.println("has reservado asiento 43279119S"+" hay libres:"+trenpasajeros1.getAsientosLibres());
		}
		if (trenpasajeros1.cancelarAsiento("43279119S")==true)
		{
			System.out.println("has cancelado asiento 43279119S"+" hay libres:"+trenpasajeros1.getAsientosLibres());
		}
		if (trenpasajeros1.reservarAsiento("12345678S")==true)
		{
			System.out.println("has reservado asiento 12345678S"+" hay libres:"+trenpasajeros1.getAsientosLibres());
		}
		if (trenpasajeros1.reservarAsiento("34978524H")==true)
		{
			System.out.println("has reservado asiento 34978524H"+" hay libres:"+trenpasajeros1.getAsientosLibres());
		}
		System.out.println("__________________________");
		System.out.println("trenmercancias1\n");
		
		
		System.out.println("tren de mercancias 1 + 20km/h: "+vectorTrenMercancias[0].aumentarVelocidad(20));
		System.out.println("tren de mercancias 1 - 40km/h: "+vectorTrenMercancias[0].disminuirVelocidad(40));
		
		if (trenmercancias1.cargarVagon(80,9)==true)
		{
			System.out.println("\n"+"cargado el vagon 9 con 80 kilos\n");
		}
		System.out.println("vagon 9 rellenado: "+trenmercancias1.getVagonesMercancia(9)+"\n");
		trenmercancias1.cargarVagon(120,9);
		System.out.println("pongo 120 kilos extra"+"\n");
		System.out.println("vagon 9: "+trenmercancias1.getVagonesMercancia(9)+"\n");
		System.out.println("quito 110 al vagon 9"+"\n");
		trenmercancias1.descargarVagon(110,9);
		System.out.println("vagon 9: "+trenmercancias1.getVagonesMercancia(9)+"\n");

	}
}

