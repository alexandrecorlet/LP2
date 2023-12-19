/**
* Lab Prog 2 - Lab 1
*
* @author Alexandre Santos - 119210883
*/

import java.util.Scanner;

public class Advinhacao {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int resposta = scan.nextInt();
        int tentativa;
        do {
            tentativa = scan.nextInt();
            if (tentativa < resposta) {
                System.out.println("MENOR");
            } else if (tentativa > resposta) {
                System.out.println("MAIOR");
            }

        } while (tentativa != resposta);

        System.out.println("ACERTOU");
    }
}
