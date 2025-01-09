
public class entregable4Angel {
	
		public static void ordenarLista(Manzana[] vec){
		Manzana aux;
		boolean cambio=true;
		int z;
		z=1;
		while(z<vec.length && cambio) {
			cambio=false;
			for(int j=0;j<(vec.length-z);j++) {
                 if(vec[j].compareTo(vec[j+1])>0){
					aux = vec[j];
					vec[j] = vec[j+1];
					vec[j+1] = aux;
					cambio=true;
				 }
			}
			z++;
		}

}
	

	
	public static void main (String[] args) {
	Manzana [] vectorManzanas=new Manzana[10];
		
		vectorManzanas[0]=new Manzana("roja","variedad",25);
		vectorManzanas[1]=new Manzana("verde","variedad",36);
		vectorManzanas[2]=new Manzana("amarilla","variedad",45);
		vectorManzanas[3]=new Manzana("verde","variedad",22);
		vectorManzanas[4]=new Manzana("roja","variedad",11);
		vectorManzanas[5]=new Manzana("amarilla","variedad",27.33333);
		vectorManzanas[6]=new Manzana("verde","variedad",12);
		vectorManzanas[7]=new Manzana("verde","variedad",25);
		vectorManzanas[8]=new Manzana("amarilla","variedad",22);
		vectorManzanas[9]=new Manzana("verde","variedad",29);

		for (int i = 0; i <vectorManzanas.length; i++)
		{
			System.out.println(vectorManzanas[i]);
		}
		System.out.println("________________________________");
		System.out.println("ahora ordenado");
		ordenarLista(vectorManzanas);
		for (int i = 0; i <vectorManzanas.length; i++)
		{
			System.out.println(vectorManzanas[i]);
		}
		
		

	}
}

