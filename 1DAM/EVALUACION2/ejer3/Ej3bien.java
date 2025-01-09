import java.util.Random;
public class Ej3bien {
	
	public static String numNoAparecen(int [] vec){
		int max=Max(vec);
		String numeros="";
		boolean prueba=false;
		for(int i=1;i<max;i++){
			prueba=false;
			for (int j = 0; j < vec.length; j++)
				if (vec[j]==i)
					prueba=true;	
			
			if (prueba==false)
				numeros+=i+" ";

		}
	
		return numeros;
	}
	
	public static int Max(int [] vec){
		int max=0;
		for (int i = 0; i < vec.length; i++)
			if (vec[i]>max)
				max=vec[i];
				
		return max;
		
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
	
	public static void main (String[] args) {
		Random rnd=new Random();	
		int [] vec= new int[20];
		String n="";
		
		for (int i = 0; i < vec.length; i++)
			vec[i]=rnd.nextInt(50)+1;

	
	System.out.println("desordenado");
	for (int i = 0; i < vec.length; i++)
		System.out.print(vec[i]+" ");
		
	System.out.println("\nordenado");
	ordenarVector(vec);
	
	for (int i = 0; i < vec.length; i++)
		System.out.print(vec[i]+" ");

	System.out.println("\nnumeros que no aparecen: ");
	
		n=numNoAparecen(vec);
		System.out.println(n);
	}

}


