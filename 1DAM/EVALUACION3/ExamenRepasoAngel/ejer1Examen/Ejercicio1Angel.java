
public class Ejercicio1Angel {
	private static final int LONGITUD=10;
	public static void main (String[] args) {
		Rombo [] vectorRombos=new Rombo[LONGITUD];
		int D=10;
		int d=1;
		int L=2;
		int j=0;
		
		for (int i = 0; i < LONGITUD; i++)
		{
			vectorRombos[i] = new Rombo(D, d, L);
			D++;
			d++;
			L++;
		}

		for (int i = 0; i < vectorRombos.length; i++){
			Rombo r=vectorRombos[i];//porque cuando los he metido al vector no les he puesto nombre
			System.out.println("Rombo "+(j+1)+": "+vectorRombos[i]);
			System.out.println("Area:"+vectorRombos[i].calcularArea(r));
			System.out.println("Perimetro:"+vectorRombos[i].calcularPerimetro(r)+"\n");
			j++;
		}
		
		//a partir de aqui he creado el metodo equals para comparar objetos y he creado algunos 
		
		
		Rombo rombo1=new Rombo(11,2,4);
		Rombo rombo2=new Rombo(11,2,4);
		
		if (rombo1.equals(rombo2))
		{
			System.out.println("los rombos son iguales en todo");
		}
		else{
			System.out.println("los rombos no son iguales");
			}
		Rombo rombo3=new Rombo(11,2,4);
		Rombo rombo4=new Rombo(22,2,4);
		
		if (rombo3.equals(rombo4))
		{
			System.out.println("los rombos son iguales en todo");
		}
		else{
			System.out.println("los rombos no son iguales");
			}
		
	}
}

