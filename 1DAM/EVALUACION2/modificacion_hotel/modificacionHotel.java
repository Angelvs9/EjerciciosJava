
public class modificacionHotel {
	
	public static void main (String[] args) {
		
		Clientes juan =new Clientes("Juan","ballester roca","134697G","calle direccion","CS");
		Clientes pepe =new Clientes("Juan","ballester roca","134697G","calle direccion","CS");
		Hotel zapata=new Hotel(2,12);
		System.out.println(zapata.toString());
		if (zapata.reserva(1,2,juan)==true)
		{
			System.out.println("se ha realizado la reserva, planta: "+zapata.getPlanta()+"en la habitacion"+zapata.getnHab());
		}
		else
		{
			System.out.println("se asignara una aleatoria en la planta: "+zapata.getPlanta()+"en la habitacion"+zapata.getnHab());
		}
		System.out.println(zapata.toString());
		
		if (zapata.reserva(1,2,pepe)==true)
		{
			System.out.println("se ha realizado la reserva, planta: "+zapata.getPlanta()+"en la habitacion"+zapata.getnHab());
		}
		else
		{
			System.out.println("se asignara a pepe una aleatoria en la planta: "+zapata.getPlanta()+"en la habitacion"+zapata.getnHab());
		}
		System.out.println(zapata.toString());
		
		
	}
}

