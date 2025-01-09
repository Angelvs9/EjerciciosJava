
public class Coche {
	
	private int ruedas;
	private String matricula;

	Coche(String g){
		ruedas=4;	
		matricula=g;
	}

	public boolean equals(Coche c){
		boolean b=false;
		if(c!=null)
			if(this.matricula.equals(c.matricula))
				b=true;
				
		return b;
	}
	
	public String getMatricula(){
		return matricula;
	}

	public String toString(){
		return "\nruedas: "+ruedas;
	}

}

