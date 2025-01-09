import java.util.Scanner;
public class ej4_2optativo {
	
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean booleano=false;
		System.out.println("introduce caracteres");
		String resultado=sc.nextLine();
		if (resultado.equals(resultado.toLowerCase()))
			booleano=true;
		if (booleano==false)
			System.out.println("no son minusculas");
		else
			System.out.println("Son minusculas");
	}
}

