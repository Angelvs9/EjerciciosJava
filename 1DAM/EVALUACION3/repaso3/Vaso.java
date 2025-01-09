
public class Vaso implements Comparable <Vaso>{
	
	private String color;
	private String material;
	private double base;
	private double altura;
	private double ancho;

	
	Vaso(String color,String material,double base,double altura,double ancho){
        this.color = color;
        this.material = material;
        this.base = base;
        this.altura = altura;
        this.ancho = ancho;		
	}
	
	Vaso(double base,double altura,double ancho){
        this.color = "blanco";
        this.material = "plastico";
        this.base = base;
        this.altura = altura;
        this.ancho = ancho;		
	}
	
	public int compareTo(Vaso v){
		if (this.color.equals(v.color) && this.material.equals(v.material))
		{
			if (this.base==v.base && this.altura==v.altura && this.ancho==v.ancho)
			{
				return 0;
			}
			if (this.base<v.base&& this.altura<v.altura && this.ancho<v.ancho)
			{
				return -1;
			}
			else if (this.base>v.base&& this.altura>v.altura && this.ancho>v.ancho){
				return 1;
			}
		}
		else if (v==null)
		{
			return 1;//si el segundo es null entonces es mayor
		}
		return 1;// si no son del mismo color y material dice que es mayor el primero
	}
	
	
	
	
	public String getColor(){
		return color;
	}
	
	public void SetColor(String c){
		this.color=c;
	}
	
	public String getMaterial(){
		return material;
	}
	
	public void SetMaterial(String m){
		material=m;
	}
	
	

	public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

	public String toString(){
		String temp="";
		temp=temp+"\ncolor: "+color+"\nmaterial: "+material+"\nbase: "+base+"\naltura: "+altura+"\nancho: "+ancho+"\n";
		return temp;
	}


}

