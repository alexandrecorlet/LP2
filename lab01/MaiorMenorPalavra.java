/**
* Laboratório de Programação 2 - Lab 1
*
* @author Alexandre Santos - 119210883
*/


import java.util.Scanner;

public class MaiorMenorPalavra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String palavra1 = scan.nextLine();
        String palavra2 = scan.nextLine();

        int tamanho1 = palavra1.length();
        int tamanho2 = palavra2.length();

        if (tamanho1 > tamanho2) {
            System.out.println(palavra2);
            System.out.println(palavra1);
        } else if (tamanho2 > tamanho1) {
            System.out.println(palavra1);
            System.out.println(palavra2);
        } else {
            System.out.println(palavra1);
            System.out.println(palavra1);
        }
    }
}
