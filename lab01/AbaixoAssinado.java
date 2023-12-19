/**
* LP2 - Lab 1
*
* @author Alexandre Santos, 119210883
*/

import java.util.Scanner;

public class AbaixoAssinado {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int total = 0;          // somatorio de interesses
        int assinaturas = 0;    // contabiliza assinaturas
        while (true) {
            String nome = scan.next();
            if (nome.equals("fim")) {
                break;
            }
            int interesse = scan.nextInt();
            total += interesse;
            assinaturas++;
        }
        
        int media = total / assinaturas;

        System.out.println(assinaturas);
        System.out.println(media);
    }
}
