
public class Rombo {

	private int dmy;
	private int dmn;
	private int lado;
	
	Rombo(int dmy,int dmn,int lado){
		this.dmy=dmy;
		this.dmn=dmn;
		this.lado=lado;
	}
	
	public int calcularArea(Rombo r){
		return (r.Getdmy()*r.Getdmn())/2;
	}
	
	public int calcularPerimetro(Rombo r){
		return 4*r.Getlado();
	}
	
	public boolean equals(Object o){
		boolean iguales=false;
		Rombo r=null;
		if(o!=null){
			if(o instanceof Rombo){
				r=(Rombo)o;
				if(r.dmy==dmy && r.dmn==dmn &&  r.lado==lado)
					iguales=true;
			}
		}
		//si no coinciden en todo, no los considero iguales
		return iguales;
	}


	
	//getters
	public int Getdmy(){
		return this.dmy;
	}
	public int Getdmn(){
		return this.dmn;
	}
	public int Getlado(){
		return this.lado;
	}
	
	//setters
	public void Setdmy(int dmy){
		this.dmy=dmy;
	}
	public void Setdmn(int dmn){
		this.dmn=dmn;
	}
	public void Setlado(int lado){
		this.lado=lado;
	}
	
	public String toString(){
		String temp="";
		temp=temp+"D:"+dmy+" d:"+dmn+" L:"+lado;
		return temp;
	}

}
