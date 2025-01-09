
import java.util.Scanner;
public class AngelPalindromos{
	
	public static boolean palindromo(String f){
		boolean palindromo=false;
		String frase="";
		frase=f;
		String temp1="";
		String temp2="";
		
		for (int i = 0; i < frase.length(); i++)
			if (frase.charAt(i)!=' ')
			{
				temp1=frase.charAt(i)+"";			
			}
		
		
		
		for (int j = frase.length()-1; j >= 0; j--)
			{	
			temp2=frase.charAt(j)+"";						
			}
	
		System.out.println("-----------------------");
		if (temp1.equals(temp2))
		{
			palindromo=true;
		}else
			palindromo=false;

		return palindromo;
	}
	
	
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		String frase="";
		System.out.println("pon la frase: ");
		System.out.println("");
		frase=sc.nextLine();
		System.out.println(palindromo(frase));
		if (palindromo(frase)==true)
		{
			System.out.println(frase +" ES palindromo");
		}else
			System.out.println(frase +" NO ES palindromo");
	}
}

