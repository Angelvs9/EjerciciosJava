import java.util.Scanner;
public class scannergood {
	
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		String resultado="";
		int numero=0;
		boolean texto=false;
		while(numero<=0){
				System.out.print("introduce un numero entero: ");
				resultado=sc.nextLine();
				texto=false;
				for (int i = 0; i < resultado.length(); i++)
					if(resultado.charAt(i)>'9' || resultado.charAt(i)<'0')
						texto=true;
						
				if(resultado.equals(""))	
					texto=true;
					
				if(texto==false)
					numero=Integer.parseInt(resultado);
				
		}
		
		System.out.println("este es el numero que has introducido: "+numero);
	}

}

