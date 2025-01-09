
public class Ejercicio2Angel {
	
	public static void main (String[] args) {
		cabezera cabezera1=new cabezera("pepe",20,100,false,165548);
		cabezera cabezera2=new cabezera("juan",25,100,false,364878);
		
		digestivo digestivo1=new digestivo("raul",60,100,true,547898,"juana");
		
		cardiologo cardiologo1=new cardiologo("carlos",50,100,true,657842,"maria");
		
		System.out.println(cabezera1.toString());
		System.out.println("facturacion total de cabezera 1: "+cabezera1.calcularFacturacionTotal(1,20,36)+"\n");
		System.out.println(cabezera2.toString());
		System.out.println("facturacion total de cabezera 2: "+cabezera1.calcularFacturacionTotal(1,25,25)+"\n");
		System.out.println(digestivo1.toString());
		System.out.println("facturacion total de digestivo 1: "+digestivo1.calcularFacturacionTotal(1,60,10)+"\n");
		System.out.println(cardiologo1.toString());
		System.out.println("facturacion total de cardiologo 1: "+cardiologo1.calcularFacturacionTotal(1,50,2)+"\n");	
		

		
	}
}

