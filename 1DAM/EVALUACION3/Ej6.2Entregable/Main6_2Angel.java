
public class Main6_2Angel {
	private static final int LONGITUD=7;
	
	public static void main (String[] args) {
		
		MetodosAngel lista=new MetodosAngel(LONGITUD);
		pizza pj = new pizza("Pepperoni", "jamón");
		pizza qt = new pizza("queso", "tomatee");
		palabra p1=new palabra("dormir");
		palabra p2=new palabra("comer");
		coche c1=new coche("HTG147859632");
		coche c2=new coche("GHT64786689");
		pizza bc = new pizza("bacon", "cebolla");
		
		//guardo
		if (lista.guardarObjeto(c1,0)==true){
			System.out.println("guardado correctamente\n");
		}
		else{
			System.out.println("No se puedo guardar\n");
		}	
		if (lista.guardarObjeto(pj,1)==true){
			System.out.println("guardado correctamente\n");
		}
		else{
			System.out.println("No se puedo guardar\n");
		}	
		if (lista.guardarObjeto(p2,2)==true){
			System.out.println("guardado correctamente\n");
		}
		else{
			System.out.println("No se puedo guardar\n");
		}	
		if (lista.guardarObjeto(c2,0)==true){
			System.out.println("guardado correctamente\n");
		}
		else{
			System.out.println("No se puedo guardar\n");
		}	
		if (lista.guardarObjeto(p1,4)==true){
			System.out.println("guardado correctamente\n");
		}
		else{
			System.out.println("No se puedo guardar\n");
		}	

		if (lista.guardarObjeto(bc,7)==true){
			System.out.println("guardado correctamente\n");
		}
		else{
			System.out.println("No se puedo guardar\n");
		}	
		if (lista.guardarObjeto(qt,5)==true){
			System.out.println("guardado correctamente\n");
		}
		else{
			System.out.println("No se puedo guardar\n");
		}	

		if (lista.guardarObjeto(p1,6)==true){
			System.out.println("guardado correctamente\n");
		}
		else{
			System.out.println("No se puedo guardar\n");
		}			
		
		
		//listo los objetos
		for (int i = 0; i < LONGITUD; i++)
		{
			lista.ObtenerObjeto(i);
		}

		
		if (lista.EliminarObjeto(0)) {
			System.out.println("objeto en la posicion 0 borrrado");
		}else {
			System.out.println("No se puede borrar el objeto");
		}
		if (lista.EliminarObjeto(5)) {
			System.out.println("objeto en la posicion 5 borrrado");
		}else {
			System.out.println("No se puede borrar el objeto");
		}
		System.out.println("-----------------------");
		System.out.println("listo contenido de la posicion 0");
		System.out.println(lista.ObtenerObjeto(0));
		System.out.println("listo contenido de la posicion 5");
		System.out.println(lista.ObtenerObjeto(5));
		System.out.println("-----------------------");
		
		lista.EliminarTodos();
		for (int i = 0; i < LONGITUD; i++)
		{
			lista.ObtenerObjeto(i);
		}
		


		
		
	}
}

