
package aerolillas;
import modelo.Piloto;
import modelo.Persona;
import modelo.Azafata;
import modelo.Billete;
import modelo.Avion;
import static modelo.Piloto.mostrarPilotos;
import static modelo.Piloto.mostrarVuelosPiloto;
import static modelo.Piloto.asignarVuelo;
import static modelo.Piloto.cancelarVuelos;
import static modelo.Avion.mostrarVuelos;
import static modelo.Azafata.mostrarAzafatas;
import static modelo.Billete.mostrarBilletes;
import static modelo.Persona.mostrarPersonas;
import static modelo.Persona.mostrarBilletesPersona;
import utilidades.bbdd.Bd;
import static utilidades.bbdd.Bd.crearBBDD;
import utilidades.bbdd.Gestor_conexion_POSTGRE;






public class Main {
    public static void main(String[] args) {
        try {
        crearBBDD(true);
        Gestor_conexion_POSTGRE gestor = new Gestor_conexion_POSTGRE("juego",true);
        Bd.importar("\\Aerolillas\\lib\\juego.sql",gestor);         
        ////////////////////////////////////BILLETE//////////////////////////////////////////////
        
        // Crear billetes
        Billete billete1 = new Billete(20, 10);
        Billete billete2 = new Billete(21, 20);
        
        // Agregar billetes
        billete1.addBillete(billete1);
        billete2.addBillete(billete2);
        
        String vecBilletes[][]=mostrarBilletes();
        
        System.out.println("-----------------------------------");
        for (int i = 0; i < vecBilletes.length-1; i++) {
            for (int j = 0; j < vecBilletes[0].length-1; j++) {
                System.out.print(" "+vecBilletes[i][j] + " ");
            }
        System.out.println();
        }
        System.out.println("-----------------------------------");

        
        // Borrar billete
        billete1.borrarBillete(billete1);
   
        
        ////////////////////////////////////PILOTO//////////////////////////////////////////////
        
        Piloto juancho=new Piloto(40,"m","1534869D","juancho","fernandez",123654789,"juancho@aerolillas.com","contraseñasupersegura");
        Piloto juanvi=new Piloto(45,"a","54785662F","juanvi","sanchez",547896547,"juanvi@aerolillas.com","contraseñasuesegura");
        juancho.addPiloto(juancho);
        juanvi.addPiloto(juanvi);
        juanvi.borrarPiloto(juanvi);
        
        if (asignarVuelo(juanvi)==true) {
            mostrarVuelosPiloto(juanvi);
        }

        String[][] pilotos = mostrarPilotos();
 
        for (int i = 0; i < pilotos.length; i++) {
            for (int j = 0; j < pilotos[i].length; j++) {
               System.out.print(pilotos[i][j] + " ");
            }
            System.out.println(); 
        }
        
       
        String[][] Vuelospilotos = mostrarVuelosPiloto(juancho);

        for (int i = 0; i < Vuelospilotos.length; i++) {
            for (int j = 0; j < Vuelospilotos[i].length; j++) {
               System.out.print(Vuelospilotos[i][j] + " ");
            }
            System.out.println(); 
        }
       
        if (cancelarVuelos(juanvi)==true) {
            String[][] VuelospilotoJuancho = mostrarVuelosPiloto(juancho);
            for (int i = 0; i < VuelospilotoJuancho.length; i++) {
                for (int j = 0; j < VuelospilotoJuancho[i].length; j++) {
                    System.out.print(VuelospilotoJuancho[i][j] + " ");
                }
                System.out.println(); 
            }
            
        }
       
       
        
        ////////////////////////////////////AZAFATA//////////////////////////////////////////////
        
        Azafata nuria=new Azafata(27,true,"Nuria","Martinez",643254464,"nuriamartinez@aerolillas.com","1245388E","nuria10");
        Azafata lorena=new Azafata(29,false,"Lorena","Vazquez",642132277,"lorenavazquez@aerolillas.com","7698337Q","lorena12");
        nuria.addAzafata(nuria);
        lorena.addAzafata(lorena);
        String[][] vec = mostrarAzafatas();
        System.out.println("-----------------------------------");
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[0].length; j++) {
                System.out.print(vec[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");

        lorena.borrarAzafata(lorena);
        //despues de borrar a lorena
        System.out.println("-----------------------------------");
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[0].length; j++) {
                System.out.print(vec[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
        
        
        Azafata.asignarVuelo(nuria);
        
        
        
        
        ////////////////////////////////////PERSONA//////////////////////////////////////////////

          
        Persona paco = new Persona("97898778A","paco", "García", 123456789, "paco@correo.com", "contraseña"); 
        Persona pep = new Persona("15478964Y","pep", "terro", 968542717, "pep@correo.com", "asssword"); 
        Persona maria = new Persona("66666964Y","maria", "fernadnez", 999542717, "maria@correo.com", "paswor"); 
        Persona pili = new Persona("11178964Y","pili", "lagorda", 9968542, "pililagor@correo.com", "pas"); 
        pep.addPersona(pep);
        paco.addPersona(paco);
        pili.addPersona(pili);
        maria.addPersona(maria);
        String[][] vecPersona = mostrarPersonas();
        System.out.println("-----------------------------------");
        for (int i = 0; i < vecPersona.length; i++) {
            for (int j = 0; j < vecPersona[0].length; j++) {
                System.out.print(vecPersona[i][j] + " ");
            }
        System.out.println();
        }
        System.out.println("-----------------------------------");
        
        
        pep.comprarBillete("castellon","Oropesa","15478964Y");
        paco.comprarBillete("villareal","ibiza","97898778A");
        paco.comprarBillete("castellon","oropesa","97898778A");
        pili.comprarBillete("villareal","ibiza","11178964Y");
        paco.cancelarBillete("castellon","oropesa","97898778A");
        pep.cancelarBillete("castellon","Oropesa","15478964Y");
        
       String[][] vecBilletePersona=mostrarBilletesPersona(paco);
       
        for (int i = 0; i < vecBilletePersona.length; i++) {
            for (int j = 0; j < vecBilletePersona[0].length; j++) {
                System.out.print(vecBilletePersona[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
        
        ////////////////////////////////////AVION//////////////////////////////////////////////

        //Gestor_conexion_POSTGRE gestor = new Gestor_conexion_POSTGRE("juego", true);
	Avion boeing777	= new Avion(8,"boeing777", 15000, 1000, 750, 2, 200, 175);
        Avion b6785gvj	= new Avion(9,"b6785gvj", 15000, 1000, 750, 2, 200, 175);
       
        Avion.addAvion(boeing777);
        Avion.addAvion(b6785gvj);
        
        boeing777.hacerVuelo(19,"castellon","españa", 800, 6, 1);
        b6785gvj.hacerVuelo(20,"villareal","ibiza",600, 6, 2);
        b6785gvj.hacerVuelo(22,"castellon","Oropesa",600, 6, 2);

        String[][] listaPilotos = mostrarPilotos();
        if (listaPilotos!=null){
                 System.out.println("-----------------------------------");
                 for (int i = 0; i < listaPilotos.length; i++) {
                     for (int j = 0; j < listaPilotos[0].length; j++) {
                         System.out.print(listaPilotos[i][j]+" ");
                     }
                     System.out.println();
                 }
             }
             System.out.println("-----------------------------------");
        
        String[][] listaVuelos = mostrarVuelos();     
        if (listaVuelos!=null){
            System.out.println("-----------------------------------");
            for (int i = 0; i < listaVuelos.length; i++) {
                for (int j = 0; j < listaVuelos[0].length; j++) {
                    System.out.print(listaVuelos[i][j]+" ");
                }
                    System.out.println();
                }
             }
             System.out.println("-----------------------------------");
   
        String[][] listaVuelosAvion = mostrarVuelos(boeing777);     
        if (listaVuelosAvion!=null){
            System.out.println("-----------------------------------");
            for (int i = 0; i < listaVuelosAvion.length; i++) {
                for (int j = 0; j < listaVuelosAvion[0].length; j++) {
                    System.out.print(listaVuelosAvion[i][j]+" ");
                }
                    System.out.println();
                }
             }
             System.out.println("-----------------------------------");
        }

        catch(NullPointerException e){
            System.out.println("al algun dato que falta rellenar");
        }

    }      
}
