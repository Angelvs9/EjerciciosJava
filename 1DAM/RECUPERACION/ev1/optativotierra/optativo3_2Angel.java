import java.util.Scanner;
public class optativo3_2Angel {
	
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean bisiesto=false;
		System.out.print("introduce anyo ");
		int anyo=sc.nextInt();
		if (anyo % 4==0 && anyo%10 !=9)
			bisiesto=true;
		System.out.println("------------------------");
		System.out.println("bisiesto: "+bisiesto);
		System.out.println("------------------------");
	}
}

