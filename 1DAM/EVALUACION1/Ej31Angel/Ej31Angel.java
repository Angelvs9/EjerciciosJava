



//funciona bien
import java.util.Scanner;
public class Ej31Angel {
   public static void main(String[] args) {

      int fallos = 0;
      int aciertos = 0;
      Scanner sc = new Scanner(System.in);
      boolean ganar = false;
      boolean resultado = false; //si has acertado alguna letra
      System.out.print("Introduce la palabra a adivinar:");
      String palabra = sc.nextLine();
      System.out.println("____________");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|______");
      System.out.println();

      char[] vec;
      vec = new char[palabra.length()];
      char[] respuesta = new char[palabra.length()];
      String resuelta;
	//esto coge el vector que ya tiene la longitud con el length de 
	//la palabra y lo va cogiendo letra por letra
      for (int i = 0; i < palabra.length(); i++) {
         vec[i] = palabra.charAt(i);
      }
	//esto rellena de guiones
      for (int i = 0; i < respuesta.length; i++) {
         respuesta[i] = '-';
      }

      while (fallos <4 && ganar!=true) {
         char letra;
         System.out.println("Introduce una letra: ");
         letra = sc.nextLine().charAt(0);//con esto se hace charAt la String
         boolean encontrado = false;
         for (int i = 0; i < vec.length; i++) {
            if (letra == vec[i]) {
               respuesta[i] = letra;
               encontrado = true;
            }
            System.out.print(respuesta[i]+" ");
            
         }
         System.out.println();
         
         if (encontrado == false) {
            fallos++;
            switch (fallos) {
               case 1:
                  System.out.println("____________");
                  System.out.println("|           0");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|______");
                  break;
               case 2:
                  System.out.println("____________");
                  System.out.println("|           0");
                  System.out.println("|           |");
                  System.out.println("|           |");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|");
                  break;

               case 3:
                  System.out.println("____________");
                  System.out.println("|           0");
                  System.out.println("|          /|7");
                  System.out.println("|           |");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|______");
                  break;

               case 4:
                  System.out.println("____________");
                  System.out.println("|           0");
                  System.out.println("|          /|7");
                  System.out.println("|           |");
                  System.out.println("|          / |");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|");
                  System.out.println("|______");

                  System.out.print("HAS PERDIDO");
                  System.out.println();
                  System.out.print("LA PALABRA ERA " + palabra);

            }
         }
         
         ganar=true;
         for (int i = 0; i < respuesta.length; i++) {
            if (respuesta[i] == '-') {
               ganar = false;
            }
         }

         
      }

   }
}
