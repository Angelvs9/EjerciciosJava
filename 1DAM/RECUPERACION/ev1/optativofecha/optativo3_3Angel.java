import java.util.Scanner;
public class optativo3_3Angel {
	
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		String fechaSiguiente="";
		int dia=0;
		int mes=0;
		int anyo=0;

		System.out.print("introduce una dia: ");
		dia=sc.nextInt();
		System.out.print("introduce un mes: ");
		mes=sc.nextInt();
		System.out.print("introduce anyo: ");
		anyo=sc.nextInt();
		String fecha=dia+"-"+mes+"-"+anyo;
		dia++;
		if (dia>30)
		{
			mes++;
			dia=1;
		}
		if (mes>12)
		{
			anyo++;
			mes=1;
		}
		fechaSiguiente=dia+"-"+mes+"-"+anyo;
		
		System.out.println("fecha introducida: "+fecha);
		System.out.println("dia siguiente: "+ fechaSiguiente);

		
	}
}

