import java.util.Scanner;
public class ejerexamen1{
	
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		String p="";
		boolean esnumero=true;
		double x=0.0;
		double aprox=0.0;
		while(x<=0){
			System.out.print("pon una x valida: ");
			p=sc.nextLine();
			int puntos=0;
			for (int i = 0; i < p.length(); i++)
			if(p.charAt(i)=='.')
				puntos++;
				
			if (p.equals(""))
				p="0";

			for (int i = 0; i < p.length(); i++)
				if(p.charAt(i)<'0' || p.charAt(i)>'9')
					esnumero=false;
					
			if(esnumero=true && puntos<=1)
				x=Double.parseDouble(p);
		}
		p="";
		boolean booleano=true;
		while(aprox<=0){
			System.out.print("pon la aproximacion valida: ");
			p=sc.nextLine();
			int puntos=0;
			for (int i = 0; i < p.length(); i++)
			if(p.charAt(i)=='.')
				puntos++;
				
			if (p.equals(""))
				p="0";

			for (int i = 0; i < p.length(); i++)
				if(p.charAt(i)<'0' || p.charAt(i)>'9')
					booleano=false;
					
			if(esnumero=true && puntos<=1)
				aprox=Double.parseDouble(p);
		}
		
		// estimacion al principio 25 osea x=25 y aproximacion aprox=3
		boolean acabar=false;
		double cuociente=0.0;
		double promedio=0.0;
		while (acabar==false)
		{	
			if(Math.abs(x - Math.pow(aprox, 2)) < 0.0001){
				System.out.println("Resultado: "+aprox);
				acabar=true;
			}
			else{
				System.out.print(aprox+"/");
				cuociente=x/aprox;
				System.out.print(cuociente+"/");
				promedio=(cuociente+aprox)/2;
				System.out.print(promedio+"\n");
				aprox=promedio;
				}
		}
		
			//~ //también se puede hacer así mas simple
				//~ //mientras que la resta de 25 - la aproximacion al cuadrado (que al principio es 3 ) sea mayor a 0.0001
				//~ //también se puede hacer con do-while
			//~ while (Math.abs(x - Math.pow(aprox, 2)) > 0.0001){
			
				//~ System.out.print(aprox+"/");
				//~ cuociente=x/aprox;
				//~ System.out.print(cuociente+"/");
				//~ promedio=(cuociente+aprox)/2;
				//~ System.out.print(promedio+"\n");
				//~ aprox=promedio;
				
		//~ }
		
			
			//~ System.out.println("Resultado: "+aprox);
			
			
			
			
	}
}

