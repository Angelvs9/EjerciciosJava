
public class Ej4Angel {
	
	public static void main (String[] args) {
		
		Coche Ford=new Coche("rojo","1343Bv343HJ",'M',"fiesta","Ford",5,1500,12500);
		System.out.println(Ford.toString());
		Ford.setPuertas(3);
		Ford.setCambio('A');
		System.out.println(" --------------- ");
		System.out.println(Ford.toString());
		
	}
}

