/*
 lucky number
dd/mm/aaaaaaaaaa
* 
 */

import java.util.Scanner;
public class luckyNumberAngel {
	
	public static void main (String[] args) {
		//String.valueoff y Integer.parseInt
		String fecha;
		String aux;
		int dia;
		int mes;
		int aa;//esto es el año
		
		Scanner sc=new Scanner (System.in);
		System.out.println("introduce fecha de nacimiento");
		fecha=sc.nextLine();
		//esto es para pasar numero por numero de un string a un int	
		dia=Integer.parseInt((fecha.substring(0,2)));
		mes=Integer.parseInt((fecha.substring(3,5)));
		aa=Integer.parseInt((fecha.substring(6,fecha.length())));
		
		System.out.println();
		
		System.out.print( dia+ " " + mes+ " " + aa);
		int suma1=dia+mes+aa;
		System.out.println();
		
		System.out.println(suma1);
		//ej.1995
		String s= String.valueOf(suma1);
		//ej."1995"
		while (s.length() > 1)
		{	
			suma1=0;
			
			for (int i= 0; i < s.length(); i++)
			{
				char prueba=s.charAt(i);
				suma1=suma1+Integer.parseInt(prueba+"");
				suma1=suma1;
				
				
			}
				
		System.out.println("el numero de la suerte es: " + suma1);	
		s=String.valueOf(suma1);
	
		}

		
		
		
	}
}
