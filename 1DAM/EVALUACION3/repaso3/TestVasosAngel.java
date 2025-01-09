

public class TestVasosAngel {
	
	public static double calcularVolumen(Vaso v){
		return Math.PI/12*v.getAltura()*(Math.pow(v.getAncho(),2)+v.getBase()*v.getAncho()+Math.pow(v.getBase(),2));
	}
		public static void ordenarLista(Vaso[] vec){
		Vaso aux;
		boolean cambio=true;
		int z;
		z=1;
		while(z<vec.length && cambio) {
			cambio=false;
			for(int j=0;j<(vec.length-z);j++) {
                 if(vec[j].compareTo(vec[j+1])>0 && vec[j]!=null && vec[j+1]!=null){
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
		Dia nuevoDia=new Dia();
		Dia otroDia=new Dia();
		Vaso vaso1=new Vaso(20,12,15);
		Vaso vaso2=new Vaso("rojo","carton",20.4,12.3,14.9);
		Vaso vaso3 = new Vaso("azul", "plastico", 18.0, 11.8, 15.6);
        Vaso vaso4 = new Vaso("amarillo", "plastico", 22.1, 13.7, 17.3);
        Vaso vaso5 = new Vaso("amarillo", "plastico", 22.1, 13.7, 17.3);
        
		
		//añado
		nuevoDia.addVaso(vaso1);
		nuevoDia.addVaso(vaso2);
		nuevoDia.addVaso(vaso3);
		otroDia.addVaso(vaso4);
		
		System.out.println("_________Nuevo dia_________");
		System.out.println(nuevoDia.toString());
		System.out.println("_________otro dia_________");
		System.out.println(otroDia.toString());
		
		
		System.out.println("calculo de volumen del 4 vaso");
		System.out.println(calcularVolumen(vaso4));
		if (vaso4.compareTo(vaso5)==0)
		{
			System.out.println("son igu ales");
		}
		else if (vaso4.compareTo(vaso5)==1)
		{
			System.out.println("primer vaso mayor al segundo");
		}
		else
		{
			System.out.println("primer vaso menor al segundo");
		}
		
		ordenarLista(nuevoDia.vectorVasos);
		
		
		
	}
}

