/**
* Lab Programacao 2 - Lab 1
*
* @author Alexandre Santos - 119210883
*/

import java.util.Scanner;

public class PalavraIngrata {
    
    public static boolean ehPalavraIngrata(String palavra) {
        // Checa se uma palavra e ingrata palavras 
        // ingratas sao palavras que nao possuem vogais
        String vogais = "aeiou";
        for (char letra : palavra.toCharArray()) {
            if (vogais.indexOf(letra) > -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        do {
            String palavra = scan.nextLine();
            if (ehPalavraIngrata(palavra)) {
                System.out.println(palavra);
                count++;
            }
        } while (count < 3);
    }
}
