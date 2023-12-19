/*
* Laboratório de Programação 2 - Lab 1
*
* @author Alexandre Santos - 119210883
*/

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op = sc.nextLine();
        
        if (!(op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*"))) {
            System.out.println("ENTRADA INVALIDA");
        } else {
            float n1 = sc.nextFloat();
            float n2 = sc.nextFloat();

            if (op.equals("+")) {
                System.out.println("RESULTADO: " + (n1+n2));
            } else if (op.equals("-")){
                System.out.println("RESULTADO: " + (n1 - n2));
            } else if (op.equals("*")) {
                System.out.println("RESULTADO: " + n1*n2);
            } else if (op.equals("/") && n2 != 0) {
                System.out.println("RESULTADO: " + n1/n2);
            } else {
                System.out.println("ERRO");
            }
        }
    }
}
