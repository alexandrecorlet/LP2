/**
* LP2 - Lab 1
*
* @author Alexandre Santos, 119210883
*/

import java.util.Scanner;

public class FiltroTemperatura {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int falhas = 0;
        while (true) {
            int temperatura = scan.nextInt();

            if (temperatura == 0) {
                break;
            } else if (temperatura < 0) {
                falhas++;
            }
        }
        
        System.out.println(falhas);
    }
}
