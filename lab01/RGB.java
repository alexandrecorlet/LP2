/**
* Laboratório de Programação 2 - Lab 1
*
* @author Alexandre Santos - 119210883
*/

import java.util.Scanner;

public class RGB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int R = scan.nextInt();
        int G = scan.nextInt();
        int B = scan.nextInt();

        if (R < 128 || G < 128 || B < 128)
            System.out.println("PRETO");
        else
            System.out.println("BRANCO");
    }
}
