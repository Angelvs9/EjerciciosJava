
public class Repaso5Angel {
	
	public static void main (String[] args) {
		
		Territorio [] vec=new Territorio[5];
		vec[0]=new Continente("Europa", 5000, 80000,5);//el orden es distinto pero es lo mismo
		Pais p=new Pais("España",300,5000,5);
		p.insertar("Valencia", 5, 100, "fallas", "valenciano");
		p.insertar("Castilla", 500, 2000, "castillos", "castellano");
        p.insertar("Leon", 211, 500, "castillos", "castellano");
        vec[1]=p; 
        Comunidad c1=new Comunidad("asjasjk",5,56,"magdalena","castellano");
        Comunidad c2=new Comunidad("aaaaaaakkkskd",3,6,"magdalena","castellano");
        System.out.print("\n");
        
        if (c1.equals(c2)==true)
		{
			System.out.println("la c1 y c2 son hermanas");
		}
		else
		{
			System.out.println("la c1 y c2 son hermanas");
		}
		   
		System.out.println(p.toString());
		p.ordenar();
		System.out.println("-----------------ahora-ordenado-----------------");
		System.out.println(p.toString());
	}
}

