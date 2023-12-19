/**
* Laboratório de Programação 2 - Lab 1
*
* @author Alexandre Santos - 119210883
*/

import java.util.Scanner;

public class Wally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String nomes = sc.nextLine();
            
            if (nomes.equals("wally"))
                break;
            
            // Encontra ultimo nome valido
            String nomeValido = "?";
            for (String nome: nomes.split(" ")) {
                if (nome.length() == 5) {
                    nomeValido = nome;
                }
            }

            System.out.println(nomeValido);
        }
    }
}
