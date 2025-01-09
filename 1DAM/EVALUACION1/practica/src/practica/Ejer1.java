/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenjesus;

import java.util.Scanner;


public class Ejer1 {

    public static void main(String[] args) {

        //si pones 5 te deja de pedir
        boolean terminar = false;
        double total = 0.0;
        Scanner sc = new Scanner(System.in);
        System.out.println("cuantos comensales sois: ");
        int comensales = sc.nextInt();
        if (comensales <= 0) {
            throw new ArithmeticException("El número de comensales no puede ser 0.");
        }
        while (terminar == false) {
            System.out.println("Menú");
            System.out.println("1.Pizza 12,50");
            System.out.println("2 Hamburguesa 10");
            System.out.println("3 Agua 1.50");
            System.out.println("4 Refresco 2.50");
            System.out.println("5 terminar");
            System.out.println("Tu opción: ");
            int opcion = sc.nextInt();
            char seguir = ' ';
            switch (opcion) {
                case 1:
                    total += 12.50;
                    while (seguir != 'n' && seguir != 's') {
                        System.out.println("quieres pedir más:(s/n)?");
                        seguir = sc.next().charAt(0);
                        if (seguir == 'n')
                            terminar = true;
                    }
                    break;
                case 2:
                    total += 10;
                    while (seguir != 'n' && seguir != 's') {
                        System.out.println("quieres pedir más:(s/n)?");
                        seguir = sc.next().charAt(0);
                        if (seguir == 'n')
                            terminar = true;
                    }
                    break;
                case 3:
                    total += 1.50;
                    while (seguir != 'n' && seguir != 's') {
                        System.out.println("quieres pedir más:(s/n)?");
                        seguir = sc.next().charAt(0);
                        if (seguir == 'n')
                            terminar = true;
                    }
                    break;
                case 4:
                    total += 2.50;
                    while (seguir != 'n' && seguir != 's') {
                        System.out.println("quieres pedir más:(s/n)?");
                        seguir = sc.next().charAt(0);
                        if (seguir == 'n')
                            terminar = true;
                    }
                    break;
                case 5:
                    terminar = true;
                    System.out.println("saliendo....");
            } //fin switch   
        } //fin while  
        if(comensales==1)
            System.out.println("Precio a pagar: " + total);
        else
            System.out.println("Precio a pagar: " + total + "\nsalís a : " + total / comensales + " cada uno");
    }


}

