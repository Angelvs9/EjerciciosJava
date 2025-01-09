
import java.util.Random;
public class Ej4Angel {
	
	public static String mostrar10Mayores(int [] vec){
		int contador=0;
		String num="";
		for (int i = 0; contador!=10; i++)
		{
			if (vec[i]!=vec[i+1])
			{
				System.out.print(vec[i]+" ");
				num=num+i+" ";
				contador++;
			}
		}
		
		return num;
		
		
	}
	
	
	
	
	
	public static void ordenarVector(int [] vec){
		int z=1;
		boolean cambio=true;
		int aux;
		while(z<vec.length && cambio){
			cambio=false;
			for(int j=0;j<vec.length-z;j++){
				if (vec[j]< vec[j+1])
				{
					aux=vec[j];
					vec[j]=vec[j+1];
					vec[j+1]=aux;
					cambio=true;
				}
			}
			z++;
		}

	}

	public static void main (String[] args) {
		
	Random rnd=new Random();	
	int [] vec= new int[50];
	String mayoresNumeros="";
	
	
	int max,min;
	max=101;

	
	for (int i = 0; i < vec.length; i++)
		vec[i]=rnd.nextInt(max);
		
	for (int i = 0; i < vec.length; i++)
		System.out.print(vec[i]+" ");
	System.out.println();
	ordenarVector(vec);	
		System.out.println();
	mayoresNumeros=mostrar10Mayores(vec);	

		
		
	}
}

