/**
* Lab Prog 2 - Lab 1
*
* @author Alexandre Santos - 119210883
*/

import java.util.Scanner;

public class AlturaAviao {
   
    public static int calculaAprox(int altura, int alturaIdeal) {
        // Calcula as aproximacoes da aeronave
        return Math.abs(altura - alturaIdeal);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int alturaIdeal = scan.nextInt();
        int alturaInicial = scan.nextInt();
        int aproxInicial = calculaAprox(alturaInicial, alturaIdeal);
        
        while (alturaInicial != alturaIdeal) {
            int altura = scan.nextInt();
            int aproximacao = calculaAprox(altura, alturaIdeal);
            
            if (altura == alturaIdeal) {
                break;
            } else if (aproximacao < aproxInicial) {
                System.out.println("ADEQUADO");
            } else {
                System.out.println("PERIGO");
            }

            alturaInicial = altura;
            aproxInicial = aproximacao;
        }

        System.out.println("OK");
    }
}
