import java.util.Random;
public abstract class Aula  implements Comparable<Aula>{
	
private String nombre;
Ordenador [] vecOrdenadores;
Ticket [] historial;


	Aula(String n,int nor){
		nombre=n;
		vecOrdenadores=new Ordenador[nor];
		historial=new Ticket[nor];
	}



	public int compareTo(Aula a){
		int n=0;
		if(a!=null){
			if(this instanceof AulaNormal && a instanceof AulaNormal){
				if(this.getNordenadores() > a.getNordenadores())
					n=1;
				else if(this.getNordenadores() < a.getNordenadores())
					n=-1;
			
			}
			
			if(this instanceof AulaVIP && a instanceof AulaVIP){
				if(this.getNordenadores() > a.getNordenadores())
					n=1;
				else if(this.getNordenadores() < a.getNordenadores())
					n=-1;
			
			}
			
			if(this instanceof AulaVIP && a instanceof AulaNormal)
				n=1;/*porque va de mayor a menor esto lo mueve a la derecha*/
		
			if(this instanceof AulaNormal && a instanceof AulaVIP)
				n=-1;
			
		}
		
		return n;
	}

	

	public int getNordenadores(){
		return vecOrdenadores.length;
	}

	public String getNombre(){
		return nombre;
	}

	public boolean desinstalarPc(Ordenador pc){
		boolean b=false;
		String id=pc.getId();
		for (int i = 1; i < vecOrdenadores.length-1; i++)
			if(vecOrdenadores[i]!=null && vecOrdenadores[i].getId().equals(id))
				vecOrdenadores[i]=null;
				
		return b;
	}

	public boolean instalarPc(Ordenador pc){
		boolean b=false;
		boolean apuntado=false;
		/*pongo i=1 porque en el vector el 0 es el del profesor y eso no se puede desisntalar si instalar*/
		for (int i = 1; i < vecOrdenadores.length-1; i++)
			if(vecOrdenadores[i]==null && apuntado==false){
				vecOrdenadores[i]=pc;
				apuntado=true;
				b=true;
			}
			
			return b;
	}

	private String generarIdTicketAleatoria(){
		String caracteres="ABCDEFGHIJKLMNOPQRSTUWXYZVabcdefghijklmnopqrstuvwxyz";
		boolean booleano=true;
		Random rnd=new Random();
		String n="";
		String completa="";
		boolean repetido=true;
		while(repetido==true){
			for (int i = 0; i < historial.length; i++)
			{
				n=caracteres.charAt(rnd.nextInt(caracteres.length()))+"";
				completa+=n;
			}
			repetido=RepiteId(completa);
			
		}
		return completa;
	}

	private boolean RepiteId(String id){
		boolean r=false;
		for (int i = 0; i < historial.length; i++)
			if(historial[i]!=null && historial[i].getIdTicket().equals(id))
				r=false;
				
		return r;
	}

	public boolean CrearTicket(Ordenador o){
		boolean apuntado=false;
		if(o!=null){
			Ticket temp=new Ticket(generarIdTicketAleatoria(),this.nombre,o);
			for (int i = 0; i < historial.length; i++)
				if (historial[i]==null && apuntado==false){
					historial[i]=temp;
					apuntado=true;
				}

		}
		return apuntado;
	}



	public String toString(){
		String red="\033[31m"; 
		String reset="\u001B[0m";
		String temp="";
		String temp2="";
		for (int i = 0; i < vecOrdenadores.length; i++)
			if(vecOrdenadores[i]!=null)
				temp+=vecOrdenadores[i];
				
		for (int i = 0; i < vecOrdenadores.length; i++)
			if(historial[i]!=null)
				temp2+=historial[i];
				
		
		return "\nnombre del aula: "+nombre+"\nNumero Maximo de ordenadores de esta aula: "+this.getNordenadores()+"\nOrdenadores\n"+temp+"\nHistorial de tickets\n--------------------------"+red+temp2+reset+"\n--------------------------\n";
	}


}

