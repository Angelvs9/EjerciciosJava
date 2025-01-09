

public class MetodosAngel implements Ej6_2Angel{
	
	private Object[] vectorObjetos;
	
	MetodosAngel(int longitud){
		vectorObjetos=new Object[longitud];
	}
	
	public boolean guardarObjeto(Object o,int indice){	
		boolean booleano=false;
		if (indice<vectorObjetos.length && indice>=0 && vectorObjetos[indice]==null){
			vectorObjetos[indice]=o;
			booleano=true;
		}
		return booleano;
	}
	
	public Object ObtenerObjeto(int indice){
		return vectorObjetos[indice];
	}
	
	public boolean EliminarObjeto(int indice){
		boolean booleano=false;
		if (indice<=vectorObjetos.length)
		{
			vectorObjetos[indice]=null;
			booleano=true;
		}
		return booleano;
	}
	
	public boolean EliminarTodos(){
		boolean booleano=false;
		
		if (vectorObjetos!=null)
		{
			for (int i = 0; i < vectorObjetos.length; i++)
			vectorObjetos[i]=null;
		}

		booleano=true;
		return booleano;
	}
	
}

