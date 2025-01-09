
public class Centro {
	private String nombre;
	Aula [] Aulas ;
	
	Centro(String n,int e){
		nombre=n;
		Aulas=new Aula[e];
	}
	
	Centro(int e){
		Aulas=new Aula[e];
	}	
	public boolean InsertarAula(Aula a){
	boolean apuntado=false;
	for (int i = 0; i < Aulas.length; i++)
		if (Aulas[i]==null && apuntado==false)
		{
			Aulas[i]=a;
			apuntado=true;
		}

		return apuntado;
	}
	public void ordenar(){
		Aula aux;
		boolean cambio=true;
		int z;
		z=1;
		while(z<Aulas.length && cambio==true){
			cambio=false;
			for (int j = 0; j < (Aulas.length-z); j++)
			{
				if (Aulas[j]!=null && Aulas[j+1] !=null && Aulas[j].compareTo(Aulas[j+1])>0)
				{
					aux=Aulas[j];
					Aulas[j]=Aulas[j+1];
					Aulas[j+1]=aux;
					cambio=true;
				}
			}
			
			z++;
		}
		
	}
	public String toString(){
		String temp="";
		for (int i = 0; i < Aulas.length; i++)
			if (Aulas[i]!=null)
				temp+=Aulas[i];
		
		
		
		return "Nombre centro: "+nombre+"\n"+temp;
	}
	
	
}

