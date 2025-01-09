
import java.util.Random;
public class Hotel {
	Random rnd =new Random();
	private int nHab;//por planta no en total
	private int nHabOcupadas;
	private int nHabLibres;
	private int plantas;
	Clientes[][] vecClientes;
	
	Hotel(int nHab,int plantas){
		this.nHab=nHab;
		this.plantas=plantas;
		nHabOcupadas=nHab-nHabLibres;	
		vecClientes=new Clientes[plantas][nHab];
	}
	public boolean reserva(int plantas,int habitaciones,Clientes c){
		boolean SeHaceReserva=false;
	if (plantas>0 && habitaciones>0 && plantas<=this.plantas && habitaciones<=nHab)
	{
			if (vecClientes[plantas][habitaciones]==null)
			{
			vecClientes[plantas][habitaciones]=c;
			SeHaceReserva=true;

			}
			else if(vecClientes[plantas][habitaciones]==c){
				for (int i = 0; i < this.plantas; i++)
				{
					for (int j = 0; j < vecClientes[i].length; j++)
					{
						if (vecClientes[i][j]==null && SeHaceReserva==false)
						{
							vecClientes[i][j]=c;
							SeHaceReserva=true;
						}
					}
				}
			
			
			}
	}

	return SeHaceReserva;
	}
	
	public int getPlanta(){
		return plantas;
	}
	public int getnHab(){
		return plantas;
	}
	
	public String toString(){
	String temp="";	
	for (int i = 0; i < vecClientes.length; i++)
	{
		for (int j = 0; j < vecClientes[i].length; j++)
		{
			if (vecClientes[i][j]!=null)
			{
				temp=temp+vecClientes[i][j];
			}
		
		}
		
	}
	
	return temp;
		
	}
}

