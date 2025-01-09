
public class Pais extends Territorio{
	private Comunidad [] Comunidades;
	
	Pais(String nombre,int nh,double s,int nComunidades){
		super(nombre,nh,s);
		Comunidades=new Comunidad[nComunidades];
	}
	
	public double calcularIndiceHabitabilidad(){
		return super.getnHabitantes()/super.getSuperficie();
	}
	
	 public boolean insertar(String nombre,int nh,double s,String fiestaPrincipal,String lengua){
		boolean apuntado=false;
		for (int i = 0; i < Comunidades.length; i++)
		{
			if (Comunidades[i]==null && apuntado==false)
			{
				Comunidades[i]=new Comunidad(nombre,nh,s,fiestaPrincipal,lengua);
				apuntado=true;
			}
		}
		return apuntado;
	 }
	 
	public boolean eliminarComunidad(String n){
		boolean booleano=false;
		for (int i = 0; i < Comunidades.length; i++)
		{
			if (Comunidades[i].equals(n))
			{
				Comunidades[i]=null;
				booleano=true;
			}
		}
		return booleano;
		
	}
	
public void ordenar(){
		int z=1;
		boolean cambio=true;
		Comunidad aux=null;
		while(z<Comunidades.length && cambio){
			cambio=false;
			for(int i=0;i<Comunidades.length-z;i++){
				if (Comunidades[i]!=null && Comunidades[i+1]!=null && Comunidades[i].getNombre().charAt(0)>Comunidades[i+1].getNombre().charAt(0))
				{
					aux=Comunidades[i];
					Comunidades[i]=Comunidades[i+1];
					Comunidades[i+1]=aux;
					cambio=true;
				}
			}
			z++;
		}
	}

	
	public String toString(){
	String temp="";
	for (int i = 0; i < Comunidades.length; i++)
		if (Comunidades[i]!=null)
			temp=temp+Comunidades[i]+"\n";
		return "Pais:\n"+super.toString()+temp;
	}
	
}

