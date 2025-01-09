import java.util.Scanner;
public class Extra2Ev1{
	
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean booleano=false;
		boolean espuente=false;
		String puente="";
		/*comprueba que lo que pongas por lo menos es un puente sea válido o no*/
		while (espuente==false)
		{
			System.out.print("ingrese un puente: ");
			puente=sc.nextLine();
			for (int i = 0; i < puente.length(); i++)
				if (puente.charAt(i)=='*' || puente.charAt(i)=='=' || puente.charAt(i)=='+')
					espuente=true;
		}

		if (puente.equals("**"))
			booleano=true;	
		else
			for (int i = 1; i < puente.length()-1; i++)
				if (puente.charAt(0)=='*' && puente.charAt(puente.length()-1)=='*')
				{
					if (puente.charAt(i)=='=')
						if (puente.charAt(i+1)=='=')
							if(puente.charAt(i+2)=='=' || puente.charAt(i+2)=='*')
								booleano=true;
	
					if(puente.charAt(i)=='+' && puente.charAt(puente.length()-1)=='+')
						if (puente.charAt(i+1)=='+' && puente.charAt(puente.length()-2)=='+')
							if(puente.charAt(i+2)=='=' && puente.charAt(i+3)=='*' || puente.charAt(i+3)=='=')
								booleano=true;							
					
				}
	
		for (int i = 0; i < puente.length()-1; i++)
			if (puente.charAt(0)=='*' && puente.charAt(puente.length()-1)=='*')
			{
				if (puente.charAt(i)=='=')
					if (puente.charAt(i+1)=='=' && puente.charAt(i+2)=='=' && puente.charAt(i+3)=='=' )
						booleano=false;
			}
		
		if (booleano==true)
			System.out.println("valido");
		
		
		else if(booleano==false)
			System.out.println("NO valido");
		
	}
}

