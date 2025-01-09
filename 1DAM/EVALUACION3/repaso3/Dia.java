
public class Dia{
	private static final int NMAXVASOS=100;
	Vaso [] vectorVasos;

	Dia(){
		vectorVasos=new Vaso[NMAXVASOS];
	}

	public void addVaso(Vaso v){
		boolean apuntado=false;
		for (int i = 0; i < vectorVasos.length; i++)
		{
			if (vectorVasos[i]==null && apuntado==false)
			{
				vectorVasos[i]=v;
				apuntado=true;
			}
		}
		

	}


	public String toString(){
		String temp="";
		for (int i = 0; i < vectorVasos.length; i++)
		{
			if (vectorVasos[i]!=null)
			{
				temp=temp+vectorVasos[i];
			}
		}
	return temp;	
		
	}

}

