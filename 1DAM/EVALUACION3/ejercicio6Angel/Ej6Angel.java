
public class Ej6Angel {
	
	public static void main (String[] args) {
		Vehiculo vecVehiculos []=new Vehiculo[4];
		
		vecVehiculos[0]=new Coche("145789654YUJ",5);
		vecVehiculos[1]=new Microbus("57896588FHN",15);
		vecVehiculos[2]=new Furgoneta("785412963CVB",2);
		vecVehiculos[3]=new Camion("145782648LZH",7);
		
		for (int i = 0; i < vecVehiculos.length; i++){
			System.out.println("info vehiculo: "+vecVehiculos[i].toString());
			System.out.println("Coste del alquiler: "+vecVehiculos[i].calcularPrecio(9)+"$");
			System.out.println("ruedas: "+vecVehiculos[i].num_ruedas()+"\n");
		}
		
	}
}

