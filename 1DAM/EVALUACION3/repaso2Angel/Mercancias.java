
public class Mercancias extends Tren{
	private double pesoMaxVagones;
	private int nVagones;
	private double pesoVagon;
	private static final int NMAXVAGONES=20;
	private double [] vagonesMercancia;
	
	Mercancias(String identificador,int velocidadMaxima,int velocidadActual,double pesoMaxVagones,int nVagones,double pesoVagon){
		super(identificador,velocidadMaxima,velocidadActual);
		this.pesoMaxVagones=pesoMaxVagones;
		this.nVagones=nVagones;
		this.pesoVagon=pesoVagon;
		if (nVagones<=NMAXVAGONES)
		{
			vagonesMercancia=new double[nVagones];
		}
		else
		{
			vagonesMercancia=new double[NMAXVAGONES];
		}

	}
	
	public boolean cargarVagon(double carga,int vagon){
		boolean booleano=false;
		if (carga<pesoMaxVagones && vagon<nVagones)
		{
			if ((vagonesMercancia[vagon]+carga)<=pesoMaxVagones){
				if ((vagonesMercancia[vagon]+carga)<=pesoMaxVagones){
					vagonesMercancia[vagon]+=carga;
					booleano=true;
					return booleano;
				}
			}
			else
			{
				for (int i = 0; i < vagonesMercancia.length; i++)
				{
					if ((vagonesMercancia[i]+carga)<=pesoMaxVagones){
					vagonesMercancia[i]+=carga;
					booleano=true;
					return booleano;	
					}
				}
			}
		}
		return booleano;	
	}
	
	public boolean descargarVagon(double cargaquitar,int vagon){
	if (vagonesMercancia[vagon]>0 && nVagones>vagon)
	{
		vagonesMercancia[vagon]=vagonesMercancia[vagon]-cargaquitar;
		return true;
	}
	return false;
	}
	
	public double getVagonesMercancia(int numero) {
		return vagonesMercancia[numero];
	}

	
	
	public String toString(){
		return super.toString()+ "\nPeso Maximo de los Vagones: " + pesoMaxVagones + "\nNumero de Vagones: " + vagonesMercancia.length + "\nPeso del Vagon: " + pesoVagon+"\n";
	}



}

