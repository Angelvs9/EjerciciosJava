
public class Ordenador {
	
	private String id;
	private String procesador;
	private double memoria;
	private double capacidad;
	private boolean Ssd;
	
	
	Ordenador(String id,String procesador,double memoria,double capacidad,boolean b){
		this.id=id;
		this.procesador=procesador;
		this.memoria=memoria;
		this.capacidad=capacidad;
		Ssd=b;
	}
	
	public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public double getMemoria() {
        return memoria;
    }

    public void setMemoria(double memoria) {
        this.memoria = memoria;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public boolean getSsd() {
        return Ssd;
    }

    public void setSsd(boolean Ssd) {
        this.Ssd = Ssd;
    }
	
	public String getId(){
		return id;
	}
	
	public boolean equals(Object o){
		boolean b=false;
		if(o!=null)
			if(o instanceof Ordenador){
				Ordenador temp=(Ordenador)o;
				if(this.procesador.equals(temp.getProcesador()) && this.memoria==temp.getMemoria() && this.capacidad==temp.getCapacidad() && this.Ssd==temp.getSsd())
					b=true;
				
			}	
			
		return b;
	}
	
	public String toString() {
		return "\nidentificador: " + id + "\nprocesador: " + procesador + "\nmemoria: " + memoria + "\ncapacidad: " + capacidad + "\nSsd: " + Ssd+"\n";
	}
	
	
}

