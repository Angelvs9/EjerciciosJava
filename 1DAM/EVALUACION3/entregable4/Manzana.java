
public class Manzana implements Comparable <Manzana> {
	private String color;
	private String variedad;
	private double peso;
	
	Manzana(String c,String v,double p){
		color=c;
		variedad=v;
		peso=p;
	}
	public int compareTo(Manzana m){

		int aux=0;
		if (this.color.equals(m.color))
		{
			if (this.peso<m.peso)
				aux=-1;
			else if (this.peso>m.peso)
				aux=1;		
		}
		else if (this.color!=m.color)
		{
			if (this.color.equals("verde"))
			{
				aux=-1;
			}
			else if(this.color.equals("rojo") && m.color.equals("verde"))
			{
				aux=1;
			}
			else if(this.color.equals("amarillo")){
				aux=1;
			}
		}
		return aux;
	}

    public String getColor() {
        return color;
    }

    public String getVariedad() {
        return variedad;
    }

    public double getPeso() {
        return peso;
    }

	public String toString(){
		return "color: "+color+"\nvariedad: "+variedad+"\npeso:"+peso+"\n";
	}

	
}

