public class main {
	
	public static void main (String[] args) {
		Pila viejaPila=new Pila(5);
		Pila nuevaPila=new Pila(5);
		Coche c=new Coche("48549676FHT");
		Coche c2=new Coche("76482395HFC");
		Zanahoria z=new Zanahoria(1);
		Zanahoria z2=new Zanahoria(2);
		viejaPila.push(c);
		viejaPila.push(c2);
		viejaPila.push(z);
		viejaPila.push(z2);
		
		nuevaPila.push(z2);
		nuevaPila.push(z);
		nuevaPila.push(c);
		nuevaPila.push(c2);
		
		System.out.println(viejaPila.toString());
		System.out.println("\n---------------------------\n");
		System.out.println(nuevaPila.toString());
		/*hasta aqui bien*/
		Object objeto1 = viejaPila.pop();
		Object objeto2 = nuevaPila.pop();

		
	}
}

