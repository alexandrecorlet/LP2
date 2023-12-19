/*
* Laboratório de Programação 2 - Lab 1
*
* @author Alexandre Santos - 119210883
*/

import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float nota1 = sc.nextFloat();
        float nota2 = sc.nextFloat();
        float media = (nota1 + nota2) / 2;
        if (media >= 7) {
            System.out.println("pass: True!");
        } else {
                System.out.println("pass: False!");
        }
    }
}
