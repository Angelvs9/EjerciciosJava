
public class main {
	
	public static void main (String[] args) {
		Centro agil =new Centro("agilcentros",12);
		Aula aula1=new AulaNormal("aula1",12);
		Aula aula2=new AulaNormal("aula2",10);
		Aula aula3=new AulaNormal("aula3",19);
		Aula aula4=new AulaNormal("aula4",13);
		//~ Aula aula12=new Aula("aula12",40);
		//~ Aula aula8=new Aula("aula8",33);
		
		Aula aulavip1=new AulaVIP("vip1",44,"proyetor",true);
		Aula aulavip2=new AulaVIP("vip2",5,"prodtor",false);
		Aula aulavip3=new AulaVIP("vip3",17,"hitachi",true);
		Aula aulavip4=new AulaVIP("vip4",4,"pr",false);
		

		agil.InsertarAula(aulavip3);
		agil.InsertarAula(aulavip1);
		agil.InsertarAula(aula2);
		agil.InsertarAula(aulavip4);
		agil.InsertarAula(aulavip2);
		agil.InsertarAula(aula3);
		agil.InsertarAula(aula1);

		//~ agil.InsertarAula(aula12);
		agil.InsertarAula(aula4);
		//~ agil.InsertarAula(aula8);
		
		
		
		
		Ordenador pc1 = new Ordenador("PC1", "Intel Core i5", 16.0, 500.0, true);
		Ordenador pc2 = new Ordenador("PC2", "AMD Ryzen 7", 32.0, 1000.0, false);
		Ordenador pc3 = new Ordenador("PC3", "Intel Core i3", 8.0, 250.0, false);
		Ordenador pc4 = new Ordenador("PC4", "AMD Ryzen 5", 12.0, 500.0, true);
		Ordenador pc5 = new Ordenador("PC5", "Intel Core i9", 64.0, 2000.0, true);
		Ordenador pc6 = new Ordenador("PC6", "AMD Threadripper", 32.0, 1500.0, false);
		Ordenador pc7 = new Ordenador("PC7", "Intel Xeon", 128.0, 4000.0, true);
		Ordenador pc8 = new Ordenador("PC8", "AMD EPYC", 64.0, 3000.0, false);
		Ordenador pc9 = new Ordenador("PC9", "Raspberry Pi 4", 4.0, 64.0, true);
		Ordenador pc10 = new Ordenador("PC10", "Nvidia Jetson Nano", 4.0, 16.0, false);


		
		/*se hace el cuenta el ordenamiento teniendo en cuenta el maxim de pcs que caben no el maximo actual*/
		
		
		/*aula2-aula1-aula4-aula3-aulavip4-aulavip2-aulavip3-aulavip1*/
		agil.ordenar();
		System.out.println("clases ordenadas \n-------------------------------");
		System.out.println(agil.toString());
		
		/*inserto pcs*/
		aula1.instalarPc(pc1);
		aula1.instalarPc(pc4);
		aula1.instalarPc(pc8);
		aula1.instalarPc(pc2);
		aulavip1.instalarPc(pc3);
		aulavip1.instalarPc(pc5);
		aulavip1.instalarPc(pc9);
		aulavip4.instalarPc(pc6);
		aulavip4.instalarPc(pc7);
		aulavip3.instalarPc(pc10);
		
		aulavip1.CrearTicket(pc9);
		aulavip1.CrearTicket(pc7);
		aulavip1.CrearTicket(pc6);
		aula1.CrearTicket(pc8);
		aula1.CrearTicket(pc1);
		aula1.CrearTicket(pc2);
		
		System.out.println("\n-------------------------------clases con pcs y tickets-------------------------------\n");
		System.out.println(agil.toString());
		
	}
}

