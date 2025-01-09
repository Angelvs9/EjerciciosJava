
public class Comunidad extends Territorio{
	
	private String fiestaPrincipal;
	private String lengua;
	
	Comunidad(String nombre,int nh,double s,String fiestaPrincipal,String lengua){
		super(nombre,nh,s);
		this.fiestaPrincipal=fiestaPrincipal;
		this.lengua=lengua;
	}

	public boolean equals(Comunidad c){
		boolean booleano=false;
			if (c!=null)
				if (this.fiestaPrincipal.toLowerCase().equals(c.fiestaPrincipal.toLowerCase()) && this.lengua.toLowerCase().equals(c.lengua.toLowerCase()))
					booleano=true;
					
		return booleano;
	}
	

	public void setFiestaPrincipal(String f){
		fiestaPrincipal=f;
	}
	public String getFiestaPrincipal(){
		return fiestaPrincipal;
	}
	public void setLengua(String lengua){
		this.lengua=lengua;
	}
	public String getLengua(){
		return lengua;
	}
	
	public String toString(){
		return super.toString() +"Comunidades["+"Fiesta Principal: "+fiestaPrincipal+", Lengua: "+lengua+"]"; 
	}
	
	
}

