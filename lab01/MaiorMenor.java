/**
* Laboratorio de Prog 2 - Lab 1
*
* @author Alexandre Santos - 119210883
*/

import java.util.Scanner;

public class MaiorMenor {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Determinando o maior e menor numero
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            int numero = scan.nextInt();
            maior = Math.max(numero, maior);
            menor = Math.min(numero, menor);
        }
        
        // Diferenca entre maior e menor
        System.out.println(maior - menor);
    }
}
