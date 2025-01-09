
public class main2 {
	
	public static void main (String[] args) {
		Furgoneta furgo=new Furgoneta("marca ","modelopeugeot","456556HJY",3547,45);
		Motocicleta motito=new Motocicleta("verde",150,true);
		Motocicleta motoo=new Motocicleta(250,true);
		System.out.println(furgo.toString());
		System.out.println("\nconducimos la furgo 200km");
		furgo.conducir(200);
		System.out.println("kilometraje: "+furgo.getKilometraje());
		System.out.println("gasolina: "+furgo.getDgasolina());
		System.out.println("____________________________");
		System.out.println(motoo.toString());
		System.out.println(motito.toString());
	}
}

