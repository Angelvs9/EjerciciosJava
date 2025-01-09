import java.util.Scanner;
public class Ej5Notas {
	
	public static void main (String[] args) {
		double nota=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce tu nota");
		nota=sc.nextDouble();
			if (nota<4.9)
				System.out.println("Suspenso");
			else if(nota<6)
				System.out.println("aprobado");
			else if (nota<7.5)
				System.out.println("Bien");
			else if (nota<9)
				System.out.println("notable");			
			else if (nota<10)
				System.out.println("sobresaliente");
			else
				System.out.println("Excelente");
		
	}
}

