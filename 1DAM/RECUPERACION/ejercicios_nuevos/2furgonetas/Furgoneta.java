
public class Furgoneta {
	
	private String marca;
	private String modelo;
	private String matricula;
	private double kilometraje;
	private double dgasolina;

	Furgoneta(String m,String mm,String mmm,double k,double dg){
		marca=m;
		modelo=mm;
		matricula=mmm;
		kilometraje=k;
		dgasolina=dg;
	}

	public void conducir(double k){
		kilometraje+=k;
		dgasolina=(5*k)/100;
	}

	public String GetMatricula(){
		return matricula;
	}
	public void SetMatricula(String matricula){
		this.matricula=matricula;
	}
	
	public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca =marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo =modelo;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje= kilometraje;
    }

    public double getDgasolina() {
        return dgasolina;
    }

    public void setDgasolina(double dgasolina) {
        this.dgasolina=dgasolina;
    }
    
    public String toString(){
		return "\nmarca: "+marca+"\nmodelo: "+modelo+"\nmatricula: "+matricula+"\nkilometraje: "+kilometraje+"\ndgasolina: "+dgasolina;
	}
	
}

