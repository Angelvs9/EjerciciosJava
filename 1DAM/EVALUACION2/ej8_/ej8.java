
public class ej8 {
	
	public static void main (String[] args) {
		
		coche renault=new coche("154236987K","LCFGTSQ115542","arkana","renault",1458);
		coche touran=new coche("55555555U","OKWGY124582","volkswagen","touran",1458);
		coche peugeot=new coche("789654231H","modelo207","peugeot");
		pieza resorte =new pieza("587496210",154);
		pieza freno =new pieza("684748523",250);
		pieza volante =new pieza("124587",150);
		pieza embrage =new pieza("19995847",700);
		taller nuevotaller=new taller();
		
		if (nuevotaller.anyadirCocheTaller(peugeot)==true)
		{
			System.out.println("agregado al taller el matricula : "+peugeot.getMatricula()+" modelo:" +peugeot.getModelo());
		}
		if (nuevotaller.anyadirCocheTaller(touran)==true)
		{
			System.out.println("agregado al taller el matricula : "+touran.getMatricula()+" modelo:" +touran.getModelo());
		}
		if (nuevotaller.anyadirCocheTaller(renault)==true)
		{
			System.out.println("agregado al taller el matricula : "+renault.getMatricula()+" modelo:" +renault.getModelo());
		}
		System.out.println("__________taller__________\n");
		System.out.println(nuevotaller.toString());
		System.out.println("__________ahora elimino el matricula 55555555U modelo:volkswagen__________\n");
		if (nuevotaller.eliminarCocheTaller(touran)==true)
		{
			System.out.println("se ha eliminado el matricula: "+touran.getMatricula()+" modelo:" +touran.getModelo());
		}

		System.out.println(nuevotaller.toString());
		
		
		System.out.println();
		peugeot.setBastidor("GHSWOJUHT0098");
		peugeot.setKmRecorridos(124582);
		//añadir piezas
		peugeot.anyadirPieza(resorte);
		peugeot.anyadirPieza(freno);
		renault.anyadirPieza(freno);
		renault.anyadirPieza(embrage);


		System.out.println("El coste de la reparacion del peugeot es: "+peugeot.CosteReparacion(7));
		System.out.println("El coste de la reparacion del renault es: "+touran.CosteReparacion(18));
		System.out.println("El coste de la reparacion del renault es: "+renault.CosteReparacion(3));
		
		
	}
}

