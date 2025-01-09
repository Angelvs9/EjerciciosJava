import java.util.Scanner;
import java.util.Random;
public class ejer2Ev1 {
	
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rnd=new Random();
		boolean correcto=true;
		int longitud=0;
		String p="";
		
		while(longitud<=50){
			System.out.print("pon la longitud: ");
			p=sc.nextLine();
			
			for (int i = 0; i < p.length(); i++)
				if (p.charAt(i)>'9' || p.charAt(i)<'0')
					correcto=false;
			
			if(p.equals(""))
				correcto=false;
			
			if(correcto==true)
				longitud=Integer.parseInt(p);

		}
		
		int [] vec=new int[longitud];
		
		for (int i = 0; i < vec.length; i++)
			vec[i]=rnd.nextInt(501)+1;
		
		/*transforma algunos de los numeros de antes a negativos*/
		int nrandom;
		for (int i = 0; i < vec.length; i++){
			nrandom=rnd.nextInt(2);
			if (nrandom==1)
				vec[i]=vec[i]-(vec[i]*2);
		}
		
		for (int i = 0; i < vec.length; i++)
			System.out.print(vec[i]+",");
		
		System.out.print("\nNumeros Primos: ");	
		int contador=0;

		for (int i = 0; i < vec.length; i++)
		{
			if(vec[i]>0 && vec[i]!=1)
			{
				
				for (int j = 1; j < vec[i]-1; j++)
					if (vec[i]%j==0)
						contador++;
					
				/*primero se acaba el for de la j y luego ya sale*/					
				if(contador<=2)
				System.out.print(vec[i]+", ");
			
			}
			contador=0;
		}
		

		
	}

}
