
public class Pila implements Stack {
	private Object [] vec;
	int puntero;
	
	Pila(int longitud){
		vec=new Object[longitud];
		puntero=0;
	}
	
	public boolean push(Object o){
		boolean apuntado=false;
		for (int i = 0; i < vec.length-1; i++)
			if(o!=null && apuntado==false && vec[i+1]==null){
				vec[i+1]=o;
				apuntado=true;
				puntero++;
			}
			
		return apuntado;
	}
	
	public Object pop(){
		boolean b=false;
		Object temp=null;
		for (int i = vec.length; i < 0; i--)
			if(b==false && vec[i]!=null){
				temp=vec[i];
				b=true;
				puntero--;
			}
		return temp;
	}
	
	public boolean isEmpty(){
		boolean b=true;
		for (int i = 0; i < vec.length; i++)
			if(vec[i]!=null)
				b=false;
				
		return b;
	}
	
	public int size(){
		return puntero;
	}
	

	
	public String toString(){
		String temp="";
		for (int i = 0; i < vec.length; i++)
			temp+=vec[i];
			
		return "\n"+temp;
		
	}
	
	
	
	
}

