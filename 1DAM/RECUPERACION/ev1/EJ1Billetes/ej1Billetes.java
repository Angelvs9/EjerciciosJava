import java.util.Scanner;
public class ej1Billetes {
	
	public static void main (String[] args) {
		int billete50,billete20,billete10,billete5,euro;
		billete50=0;
		billete20=0;
		billete10=0;
		billete5=0;
		euro=0;
		
		Scanner escaner=new Scanner(System.in);
		System.out.print("cantidad: ");
		int cantidad=escaner.nextInt();
		
		while (cantidad!=0)
		{
			
			if (cantidad>=50)
			{
				billete50++;
				cantidad-=50;
			}
			else if (cantidad>=20)
			{
				billete20++;
				cantidad-=20;
			}
			else if (cantidad>=10)
			{
				billete10++;
				cantidad-=10;
			}
			else if (cantidad>=5)
			{
				billete5++;
				cantidad-=5;
			}
			else if(cantidad<5)
			{
				euro++;
				cantidad-=1;
			}
		}
		System.out.println("---------------------------------");
		System.out.println("billete 50: "+billete50);
		System.out.println("billete 20: "+billete20);
		System.out.println("billete 10: "+billete10);
		System.out.println("billete 5: "+billete5);
		System.out.println("monedas de euro: "+euro);
		System.out.println("---------------------------------");
		
	}
}

