
package EjercicioBiblioteca;


public class Main {

    public static void main(String[] args) {
        
        Usuario usr=new Usuario("98789787H","pep", 7);
        Usuario user1 = new Usuario("98789787H", "Pep", 30);
        Usuario user2 = new Usuario("12345678Z", "Ana", 25);
        Usuario user3 = new Usuario("98789787H", "Carlos", 35); 
 
        Reserva manager=new Reserva(new Usuario("0k","manager",0),15);
        Reserva er=new Reserva(usr,12);
        
        if (usr.compareTo(user1)==-1) {
            System.out.println("el primero es menor al segundo es decir "+usr.getNombre()+" es mas joven que "+user1.getNombre());
        }else if(usr.compareTo(user1)==1){
            System.out.println("el primero es mayor al segundo es decir "+usr.getNombre()+" es mas viejo que "+user1.getNombre());
        }
        else{
            System.out.println("tienen la misma edad "+usr.getNombre()+" que "+user1.getNombre());
        }
        if(usr.equals(user1)){
            System.out.println("son el mismo porque coincide el dni que es unico");
        }
        else{
            System.out.println("son distintos");
        }
        if(user2.equals(user3)){
            System.out.println("son el mismo porque coincide el dni que es unico");
        }
        else{
            System.out.println("son distintos");
        }
        
        manager.anyadir(usr, 87);
        manager.anyadir(usr, 12);
        manager.anyadir(usr, 45);
        manager.anyadir(usr, 87);

        manager.anyadir(user1, 87);
        manager.anyadir(user1, 99);
        manager.anyadir(user1, 45);
        manager.anyadir(user1, 65);

        manager.anyadir(user2, 45);
        manager.anyadir(user2, 30);
        manager.anyadir(user2, 58);
        manager.anyadir(user2, 12);

        manager.anyadir(user3, 99);
        manager.anyadir(user3, 22);
        manager.anyadir(user3, 87);
        manager.anyadir(user3, 75);

        System.out.println(manager.imprimirArchivoReservas());
        
        System.out.println("el usuario con más reservasssss: "+manager.usuarioMasReservas());
        manager.anularReservas(user1);
        System.out.println(manager.imprimirArchivoReservas());
        System.out.println("el usuario con más reserva: "+manager.usuarioMasReservas());
    }
    
}
