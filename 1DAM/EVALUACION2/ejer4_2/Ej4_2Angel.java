import java.util.Random;
public class Ej4_2Angel {
	
	public static void main (String[] args) {
		crearEspacio();
		String viaje="";
		int [][][][] universo1;
		universo1=crearEspacio();
		contadorInalterables(universo1);
		int contador=contadorInalterables(universo1);
		viaje=viajar(universo1,16,35,34,38);
		System.out.println(viaje);
		int [][][][] universo2;
		universo2=universoParalelo(universo1);
		viaje=viajar(universo2,16,35,34,38);
		System.out.println(viaje);
		System.out.println(contador);
	}
	
	
	public static int [][][][] crearEspacio(){	
		int [][][][] universo=new int [50][50][50][50];
		Random rnd=new Random();
		for (int i = 0; i < universo.length; i++){
			
			for (int j = 0; j < universo.length; j++){
				
				for (int x = 0; x < universo.length; x++){
					
					for (int y = 0; y < universo.length; y++){
						universo[i][j][x][y]=rnd.nextInt(3);
					}	
				}
			}
		}
				


		return universo;
	}
	
	
	
	private static void modificar(){
		System.out.println("Modificado");
	}
	
	
	
	public static String viajar(int [][][][] universo1,int x,int y,int z, int t){
			String viaje="";
			if (universo1[x][y][z][t]==2)
			{
				viaje="punto inalterable";
			}
			else if(universo1[x][y][z][t]==0 )
			{
				modificar();
			}
			else if(universo1[x][y][z][t]==1)
			{
				viaje="ya visitado";
			}
		return viaje;
	}
	
	public static int contadorInalterables(int [][][][] universo1) {
		int contador=0;
		for (int i = 0; i < universo1.length; i++){
			
			for (int j = 0; j < universo1.length; j++){
				
				for (int x = 0; x < universo1.length; x++){
					
					for (int y = 0; y < universo1.length; y++){
						
						if (universo1[i][j][x][y]==2)
						{
							contador++;
							
						}
					}	
				}
			}
		}
		return contador;
	}

	public static int [][][][] universoParalelo(int [][][][] universo1){
		int [][][][] universo2=new int [50][50][50][50];
		Random rnd=new Random();
		
		for (int i = 0; i < universo2.length; i++){
			
			for (int j = 0; j < universo2.length; j++){
				
				for (int x = 0; x < universo2.length; x++){
					
					for (int y = 0; y < universo2.length; y++){
						
						if (universo1[i][j][x][y]==2)
						{
							universo2[i][j][x][y]=universo1[i][j][x][y];				
						}
						else
						{
							universo1[i][j][x][y]=rnd.nextInt(2);
							
						}
						
					}	
				}
			}
		}
		return universo2;
		
	}
	
}
