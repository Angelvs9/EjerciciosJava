
public class taller {
	private static final int MAXTALLER=15;
	private int contador=0;
	coche [] vecCoches;
	
	taller(){
		vecCoches=new coche[MAXTALLER];	
	}
	
	public boolean anyadirCocheTaller(coche c){
		boolean puesto=false;
		boolean booleano=false;
		int temp=0;
		for (int i = 0; i < vecCoches.length; i++)
		{
			if (vecCoches[i]==null && vecCoches[i]!=c && puesto==false)
			{
				vecCoches[i]=c;
				puesto=true;
				temp++;
			}
			
		}
		puesto=false;	
		if (temp>0)
		{
			booleano=true;
		}
		return booleano;
	}
	
	public boolean eliminarCocheTaller(coche c){
		boolean puesto=false;
		boolean booleano=false;
		int temp=0;
		for (int i = 0; i < vecCoches.length; i++)
		{
			if (vecCoches[i]!=null && vecCoches[i]==c)
			{
				vecCoches[i]=null;
				temp++;
			}
			
		}
		puesto=false;
		if (temp>0)
		{
			booleano=true;
		}
		return booleano;
			
	}
	
	
	
	
	public int getContador(){
		return contador;
	}
	
	public String toString(){
	String temp="";	
		for (int i = 0; i < MAXTALLER; i++)
		{
			if (vecCoches[i]!=null)
			{
				temp=temp+vecCoches[i];
			}
		}
		return temp;
	}
	
}

