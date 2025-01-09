
import java.util.Random;
public class Ej4Angel {

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

	for (int i = 0; i < vec.length; i++)
		vec[i]=rnd.nextInt(101);
		
	for (int i = 0; i < vec.length; i++)
		System.out.print(vec[i]+" ");
			
	System.out.println("\n");
	ordenarVector(vec);	

	for (int i = 0; i < 10; i++)
		System.out.print(vec[i]+" ");
		

		
		
	}
}

