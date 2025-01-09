import java.util.Random;
import java.util.Scanner;
public class opcionalExtra1 {
	
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		String aux="";
		int longitud=0;
		boolean entero=true;
		while (longitud<=0)
		{
			System.out.println("introduce numero que sea entero");
			aux=sc.nextLine();
			entero=true;
			for (int i = 0; i < aux.length(); i++)
				if (aux.charAt(i)<'0' || aux.charAt(i)>'9')/*por ejemplo 424 cuando i=0 si el primer cuatro es menor a 0 o mayor a 9 entonces no es un entero */
					entero=false;
			
			if (entero==true)
				longitud=Integer.parseInt(aux);
		
			/*detecta ademas de letras también los decimales y te lo vuelve a pedir*/
			/*h92 no funciona*/
			/*9h2 tampoco*/
			/*92h tampoco*/
			/*92.ghjk tampoco*/
		}
		
		int [] vec= new int[longitud];
		Random rnd=new Random();
		for (int i = 0; i < vec.length; i++)
			vec[i]=rnd.nextInt(100)+1;
		
		for (int i = 0; i < vec.length; i++)
			System.out.print(vec[i]+" ");
		
		String numeros="";
		int napariciones=0;
		for (int i = 0; i < vec.length; i++)
		{
			napariciones=1;
			for (int j = 0; j < vec.length; j++)
			{
				if (vec[i]==vec[j] && vec[i]!=0 && i!=j)
				{
					napariciones++;
					vec[j] = 0;
				}
				
			}
			
			if(napariciones > 1)
				numeros+=vec[i]+"="+napariciones+" veces, ";	
		}
		
		if (numeros!="")
		{
			System.out.print("\nnumeros repetidos: "+numeros);
		}
		else
		{
			System.out.print("\nno se han repetido");
		}
	}
}

