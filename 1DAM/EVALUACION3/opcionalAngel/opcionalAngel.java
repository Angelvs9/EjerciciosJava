
public class opcionalAngel {
	
	private static final int LONGITUD=8;

	
	public static void main (String[] args) {
	Object [] vectorTodo=new Object[LONGITUD];

		Clientes juan = new Clientes("474578624K", "Juan", "Gomez", 30, 1000.0);
        Clientes maria = new Clientes("285136974M", "Maria", "Lopez", 25, 1500.0);

        Coche toyota= new Coche("1234ABC", "Toyota", "Corolla");
        Coche ford= new Coche("5678DEF", "Ford", "Focus");

       JefeZona carlos = new JefeZona("Carlos", "Perez", "357246981L", "Calle Principal", 10, 3000.0, "Despacho 1");
       JefeZona laura = new JefeZona("Laura", "Sanchez", "931468257G", "Calle Secundaria", 8, 2800.0, "Despacho 2");

       Vendedor luis = new Vendedor("Luis", "Gonzalez", "592836174R", "Calle Principal", 2, 1500.0);
       Vendedor elena = new Vendedor("Elena", "Fernandez", "748512936P", "Calle Secundaria", 4, 1700.0);
		
		Secretario pep = new Secretario("Pep", "Perez", "784246912J", "Calle Principal", 10, 3000.0, "Despacho 1", 123456789);
		Secretario josepe = new Secretario("Josepe", "Sanchez", "33648257G", "Calle Secundaria", 8, 2800.0, "Despacho 2", 987654321);
	
		
		
		vectorTodo[0]=juan;
		vectorTodo[1]=maria;
		vectorTodo[2]=carlos;
		vectorTodo[3]=laura;
		vectorTodo[4]=luis;
		vectorTodo[5]=elena;
		vectorTodo[6]=pep;
		vectorTodo[7]=josepe;
		
		
		carlos.cambiarSecretario(pep);
		carlos.cambiarCoche(toyota);
		carlos.altaVendedor(elena);
		carlos.altaVendedor(luis);

		
		
		
		System.out.println("__________________________\nJefe de zona\n");
		System.out.println(vectorTodo[2]);
		System.out.println("calculo de carlos: "+carlos.calcularSalario());
		
		System.out.println("__________________________\nSecretario\n");
		System.out.println(vectorTodo[6]);
		System.out.println("calculo de pep: "+pep.calcularSalario());
				
		luis.cambiarCoche(ford);
		luis.darAltaCliente(maria);
		System.out.println("__________________________\nVendedor\n");
		System.out.println(vectorTodo[4]);
		System.out.println("calculo de luis: "+luis.calcularSalario());
		
		
	}
}

