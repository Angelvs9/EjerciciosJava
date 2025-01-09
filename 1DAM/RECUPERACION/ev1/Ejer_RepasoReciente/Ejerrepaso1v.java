import java.util.Scanner;
import java.util.Random;
public class Ejerrepaso1v {
	
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rnd=new Random();
		boolean seguir=true;
		int longitud=0;
		String aux;
		int [] vec;
		boolean valido=true;
		while (longitud<=0)
		{
			System.out.println("introduce numero que sea entero");
			aux=sc.nextLine();

			for (int i = 0; i < aux.length(); i++)
				if (aux.charAt(i)<'0' || aux.charAt(i)>'9')
					valido=false;
			
			if(aux.equals(""))
				aux="0";
			
			if (valido==true)
				longitud=Integer.parseInt(aux);
		}

		vec=new int[longitud];
		
		for (int i = 0; i < vec.length; i++)
			vec[i]=rnd.nextInt(68)+20;
			
		int naleatorio;
		for (int i = 0; i < vec.length; i++)
		{
			naleatorio=rnd.nextInt(2);
			if (naleatorio==0)
				vec[i]=vec[i]-(vec[i]*2);
		}
		
			
		boolean acabado=false;
		int i=0;
		while (acabado==false)
		{
			if (i>=vec.length)
				i=0;//acabado=true;

			System.out.print(vec[i]+"["+i+"]"+"\t");
			i++;
		}
	}
}

