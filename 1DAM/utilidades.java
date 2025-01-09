/*
 * 
 */
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class utilidades {
	
	public static boolean esPositivo(int numero){
		boolean positivo=false;
		if (numero>0)
			positivo=true;	
			
		return positivo;
	}
	
	public static String rangoNumeros(int x,int y){
		String resultado="";
		
		if (x>y)
			for (int i = x; i >= y; i--)
				resultado+=i+" ";
		
		else
			for (int i = x; i <= y; i++)
				resultado+=i+" ";
		

		return resultado;
		
	}
	
	public static boolean esPrimo(int x){
		boolean primo=false;
		int contador=0;

		for (int i = 1; i < x-1; i++)
			if (x%i==0 && x!=1)
				contador++;
		
		if(contador<=2)
			primo=true;
			
		return primo;	
		
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
		int x;
		int y;
		Scanner in = new Scanner(System.in);
		System.out.println("Introduce un numero");
		x=in.nextInt();
		System.out.println("Introduce otro numero");
		y=in.nextInt();
		System.out.println("primer numero: "+ esPositivo(x));
		System.out.println("segundo numero: "+ esPositivo(y));
		System.out.println("los numeros entre esos 2 son: "+rangoNumeros(x,y));
		System.out.println();
		System.out.println();
		
		System.out.println("es primo x: "+ esPrimo(x));
		System.out.println("es primo y: "+ esPrimo(y));
		

		Scanner sc=new Scanner(System.in);
		String resultado="";
		int numero=0;
		boolean texto=false;
		while(numero<=0){
				System.out.println("introduce un numero");
				resultado=sc.nextLine();
				texto=false;
				for (int i = 0; i < resultado.length(); i++)
					if(resultado.charAt(i)>'9' || resultado.charAt(i)<'0')
						texto=true;
						
				if(resultado.equals(""))	
					texto=true;
					
				if(texto==false){
					numero=Integer.parseInt(resultado);
					System.out.println(resultado);
				}
		}
		
		System.out.println("este es el numero que has introducido: "+numero);
	}
		
		
		
}


