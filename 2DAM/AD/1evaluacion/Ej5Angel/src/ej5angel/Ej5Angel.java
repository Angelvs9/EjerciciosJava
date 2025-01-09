package ej5angel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej5Angel {

    public static String generarCalendario(int numeroMes , char dia){
        String calendario = "";
        String temp="";
        String nombre="mes"+numeroMes+".txt";
        int diasMes=0;
        if(numeroMes>12 || numeroMes<1){
            temp="MES NO VALIDO";
        }else{
            //se decide si son 30 o 31
            if(numeroMes%2!=0 || numeroMes==8 || numeroMes==10 || numeroMes==12){
                diasMes=31;
            }else if(numeroMes==2){
                diasMes=28;
            }
            else if(numeroMes==9 || numeroMes==11 || numeroMes==6){
                diasMes=30;
            }
            temp="Generando mes"+numeroMes+".txt...";

            calendario +="L\tM\tX\tJ\tV\tS\tD\n";
            int diaenNumero=obtenerNumeroDia(dia);
            boolean apuntado=false;


            for (int i = 1; i < 8; i++) {
                if(apuntado==false && i==diaenNumero){
                    calendario+="1\t";
                    apuntado=true;
                }
                if(apuntado==false){
                    calendario+="\t";
                }
            }
            boolean apuntar=false;
            int restantes=7-diaenNumero;
            int diaActual = obtenerNumeroDia(dia);
            int contador=2;
            boolean booleano=false;
            while(booleano==false){
                restantes=7-diaActual;
               
                if(restantes==0){
                    booleano=true;
                }
                else if(restantes!=0){
                    calendario+=contador+"\t";
                    contador++;
                    diaActual++;
                }
            }
            calendario+="\n";
            int semana=1;
            int contador2=contador;
            for (int i = -1; i < diasMes-contador2; i++) {
                calendario+=contador+"\t";
                if(semana==7){
                    calendario+="\n";
                    semana=0;
                }
                semana++;
                contador++;
            }

            System.out.println(calendario);
            
            try{

            FileWriter fw=new FileWriter(nombre);
            PrintWriter pw=new PrintWriter(fw);
            pw.println(calendario);
            
            fw.close();
            pw.close();
            
            }catch(IOException e ){}
            catch(InputMismatchException e){}
            
            
            

        }//fin else
        
        return temp;
    }
    
    private static int obtenerNumeroDia(char dia) {
            int numeroDia = -1; 
            //-1 para que se pasara algo sea mas facil ubicar el error
            switch (dia) {
                case 'L': 
                    numeroDia = 1; 
                    break;
                case 'M': 
                    numeroDia = 2;
                    break;
                case 'X': 
                    numeroDia = 3; 
                    break;
                case 'J': 
                    numeroDia = 4; 
                    break;
                case 'V': 
                    numeroDia = 5; 
                    break;
                case 'S': 
                    numeroDia = 6; 
                    break;
                case 'D': 
                    numeroDia = 7; 
                    break;
            }

            return numeroDia;
        }

    
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int temp;
        char temp2 = ' ';
        System.out.println("introduce numero del mes: ");
        temp=sc.nextInt();

        while (temp2 != 'L' && temp2 != 'M' && temp2 != 'X' && temp2 != 'J' && temp2 != 'V' && temp2 != 'S' && temp2 != 'D'){
            System.out.println("Introduce char de día (L M X J V S D): ");
            temp2 = sc.next().charAt(0);
        }

        System.out.println(generarCalendario(temp, temp2));
    }
    
    
    
}
