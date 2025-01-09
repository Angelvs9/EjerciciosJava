import java.util.Scanner;
public class Ej4Calculadora{
	
	public static void main (String[] args) {
		double numero1=0;
		double numero2=0;
		double resultado=0;
		int opcion=0;
		Scanner sc =new Scanner(System.in);
		System.out.print("Introduce el numero 1=");
		numero1=sc.nextDouble();
		System.out.print("Introduce el numero 2=");
		numero2=sc.nextDouble();
		System.out.print("\n1-Sumar"+"\n2-Restar"+"\n3-Multiplicar"+"\n4-Dividir\n\n");
		opcion=sc.nextInt();
		switch (opcion)
		{
			case 1:
				resultado=numero1+numero2;
				break;
			case 2:
				resultado=numero1-numero2;
			break;
			case 3:
				resultado=numero1*numero2;
			break;
			case 4:
				resultado=numero1/numero2;
			break;
		}
		System.out.print("\nopcion seleccionada:"+opcion);
		System.out.println("\nresultado="+resultado);	
	}
}

