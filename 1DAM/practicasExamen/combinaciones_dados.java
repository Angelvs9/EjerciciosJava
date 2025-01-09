import java.util.Scanner;
public class combinaciones_dados {
public static void main (String args[]) {
Scanner sc=new Scanner(System.in);
int puntuacion;
int [] dado1={1,2,3,4,5,6};
int [] dado2={5,6,7,8,9,0};
int contador=0;
System.out.print("Introduce un resultado: ");
puntuacion=sc.nextInt();
for (int i=0;i<=dado1.length-1;i++) {
for (int j=0;j<=dado2.length-1;j++) {
if(dado1[i]+dado2[j]==puntuacion){
contador++;
}
}
}
System.out.println("Hay "+contador+" puntuaciones");
}
}
