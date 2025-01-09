

import java.util.Random;
public class ev2practica1Angel {
	
	public static void main (String[] args) {
		//un for rellena y el otro muestra
		Random rnd=new Random();
		int x=10;
		int y=10;
		int [] vec1=new int[x];
		int [] vec2=new int[y];
		

		System.out.println("vector 1 y 2 sin orden");
		for (int i = 0; i < vec1.length; i++)
			vec1[i]=rnd.nextInt(100)+1;
		for (int i = 0; i < vec1.length; i++)
			System.out.print(vec1[i]+" ");
			
		System.out.println();
		for (int i = 0; i < vec2.length; i++)
			vec2[i]=rnd.nextInt(100)+1;		
		for (int i = 0; i < vec2.length; i++)
			System.out.print(vec2[i]+" ");


		System.out.println("\n");
		System.out.println("vector 1 y 2 ordenados");
		ordenarVector(vec1);
		ordenarVector(vec2);
		//esto los muestra ordenados
			for (int i = 0; i < vec1.length; i++)
				System.out.print(vec1[i]+" ");
		System.out.println();
			for (int i = 0; i < vec2.length; i++)
				System.out.print(vec2[i]+" ");

		sumar2Vectores(vec1,vec2);
		
		
 
	}		
	public static void ordenarVector(int [] vec){
		int z=1;
		boolean cambio=true;
		int aux;
		while(z<vec.length && cambio){
			cambio=false;
			for(int j=0;j<vec.length-z;j++){
				if (vec[j]> vec[j+1])
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
		
		
public static int [] sumar2Vectores(int [] vec1,int [] vec2){
	
	int [] vecSuma=new int[vec1.length+vec2.length];
	int x=0;
	int aux=0;
	System.out.println("\n _______________________");
	System.out.println();
	for (x = 0; x < vec1.length; x++)
		vecSuma[x]=vec1[x];

	while (x < vecSuma.length)
	{
		vecSuma[x]=vec2[aux];
		aux++;
		x++;
	}
	System.out.println("vector de 20 ordenado");
	//no me dejaba mostrarlo en el main
	for (int i = 0; i < vecSuma.length; i++)
	{
		ordenarVector(vecSuma);
		System.out.print(vecSuma[i]+" ");
	}
	
	
	return vecSuma;
	

}		
		

}

