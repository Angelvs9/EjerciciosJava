public class Ticket {
	
	private String idTicket;
	private boolean pendiente;
	private String aulaAfectada;
	private Ordenador pcAfectado;

	Ticket(String id,String aula,Ordenador o,boolean p){
		idTicket=id;
		aulaAfectada=aula;
		pcAfectado=o;
		pendiente=p;
	}
		Ticket(String id,String aula,Ordenador o){
		idTicket=id;
		aulaAfectada=aula;
		pcAfectado=o;
		pendiente=true;
	}

	public String getIdTicket(){
		return idTicket;
	}
	public boolean getPendiente(){
		return pendiente;
	}

	public String toString(){
		String temp="";
		temp="\nid Ticket: "+idTicket+"\npendiente: "+pendiente+"\nAula:"+aulaAfectada+"\nOrdenador Afectado:\n"+pcAfectado;
		return temp;
	}
}

