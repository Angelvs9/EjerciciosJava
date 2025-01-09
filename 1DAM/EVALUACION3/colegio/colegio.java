
public class colegio {
	
	public static void main (String args[]) {
		
		alumno pepe=new alumno("pepe","Gonzalez",34,"DAM",1,false);
		alumno luis=new alumno("Luis","Rodrigez",23,"DAM",2,true);
		
		System.out.println("Nombre: "+pepe.getNombre());
		System.out.println("Apellidos: "+pepe.getApellidos());
		System.out.println("Edad: "+pepe.getEdad());
		System.out.println("Ciclo: "+pepe.getCiclo());
		System.out.println("Curso: "+pepe.getCurso());
		System.out.println("Online: "+pepe.getOnline());
		System.out.println("Precio: "+pepe.ver_precio());
		System.out.println("-------------------------------");
		System.out.println("Nombre: "+luis.getNombre());
		System.out.println("Apellidos: "+luis.getApellidos());
		System.out.println("Edad: "+luis.getEdad());
		System.out.println("Ciclo: "+luis.getCiclo());
		System.out.println("Curso: "+luis.getCurso());
		System.out.println("Online: "+luis.getOnline());
		System.out.println("Precio: "+luis.ver_precio());
		System.out.println("-------------------------------");
		pepe.setNombre("Jose");
		System.out.println("Nombre: "+pepe.getNombre());
		System.out.println(pepe.toString());
		
		
		
	}
}

