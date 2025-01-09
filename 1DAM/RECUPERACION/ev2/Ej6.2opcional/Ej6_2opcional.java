
public class Ej6_2opcional {
	
	public static void main (String[] args) {
		Coche peugeot = new Coche(4,"blanco",2500,"peugeot207",33000);
		System.out.println(peugeot.toString());
		peugeot.conducir(100);
		System.out.println(peugeot.toString());
	}
}

