import java.util.Scanner;

public class ConjeturaCollatzAngel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.print("pon el numero: ");
        a = sc.nextInt();

        while (a > 1) {

            if (a%2==0) {

                a = a / 2;
                System.out.println("el número es " + a);

            } else {
                a = 3 * a + 1;
                System.out.println("el número es " + a);

            }
        }
    }
}

