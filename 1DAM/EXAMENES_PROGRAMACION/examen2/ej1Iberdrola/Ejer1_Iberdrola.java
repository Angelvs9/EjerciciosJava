
public class Ejer1_Iberdrola {
	
	public static void main (String[] args) {
		Cliente juan=new Cliente(14,"cupsps","direcciond","cs",14.3,25.9);
		Cliente pepe=new Cliente(24,"diiond","vila",19,28.9);
		
		System.out.println("juan ");
		System.out.println("lo que paga juan al mes: "+juan.CalcularMes(18.4));
		System.out.println("lo que pagaria juan al mes si la potencia contratada fuera 35 y los kw 21: "+juan.CalcularMes(35,21));
		System.out.println("____________________________");
		System.out.println("juan: "+juan.toString());
		System.out.println("____________________________");
		
		System.out.println("\n");
		System.out.println("pepe ");
		System.out.println("lo que paga pepe al mes: "+pepe.CalcularMes(18.4));
		System.out.println("lo que pagaria pepe al mes si la potencia contratada fuera 47 y los kw 33: "+pepe.CalcularMes(47,33));
		System.out.println("____________________________");
		System.out.println("pepe: "+pepe.toString());
		pepe.SetPotencia_contratada(47);
		System.out.println("\ncambiada la potencia contratada y cups anyadido \n");
		pepe.SetCups("cupsdelpepepepe");
		System.out.println(pepe.toString());
		System.out.println("____________________________");
		
	}
}

