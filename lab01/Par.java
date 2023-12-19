/**
* LP2 - lab 1
*
* @author Alexandre Santos - 119210883
*/

import java.util.Scanner;

public class Par {
   
    public static boolean ehPar(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Somatorio dos numeros pares
        int num, soma = 0;
        do {
            num = scan.nextInt();
            if (ehPar(num)) {
                soma += num;
            }
        } while (num != -1);

        System.out.println(soma);
    }
}
