
public class pieza {
	
	private String idPieza;
	private double precio;
	
	pieza(String idPieza,double precio){
		this.idPieza=idPieza;
		this.precio=precio;
	}
	
	public double getPrecio(){
		return precio;
	}
	
	public String toString(){
		String temp="";
		temp=temp+"\nidpieza: "+idPieza+"\nprecio: "+precio+"\n";
		return temp;
	}
}

