
public class ej4_2EntregableAngel {
	
	public static void main (String[] args) {
		Coche c=new Coche("15489763"); 
		MicroBuses m=new MicroBuses("14578965");
		FurgoCarga f=new FurgoCarga("16578490");
		Camiones ca=new Camiones("1845796");
		System.out.println("coche: (2 dias) "+c.calcularAlquilerCoche(2));
		System.out.println("Microbus: "+m.calcularAlquilerBus(5));
		System.out.println("furgoneta de carga: (2750 kilogramos) "+f.calcularAlquilerfurgoCarga(2750));
		System.out.println("camiones: "+ca.calcularAlquilerCamiones(7));
		
	}
}

