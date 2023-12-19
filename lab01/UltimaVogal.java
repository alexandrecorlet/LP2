/**
* LP2 - lab 1
*
* @author Alexandre Santos, 119210883
*/

import java.util.Scanner;

public class UltimaVogal {
    
    public static boolean ehVogal(char letra) {
        String vogais = "aeiou";
        return vogais.indexOf(Character.toLowerCase(letra)) > -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String vogais = "";
        for (int i = 0; i < 5; i++) {
            String palavra = scan.nextLine();
            int j = palavra.length() - 1;
            char ultimaLetra = palavra.charAt(j); 
            if (ehVogal(ultimaLetra)) {
                vogais += ultimaLetra;
            }
        }
        System.out.println(vogais);
    }
}
