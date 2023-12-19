/*
* Laboratório de Programação 2 - Lab 1
*
* @author Alexandre Santos - 119210883
*/

import java.util.Scanner;

public class AcimaDaMedia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        
        int tam = nums.length;

        // Somatorio dos numeros
        int soma = 0;
        for (int i = 0; i < tam; i++) {
            soma += Integer.parseInt(nums[i]);
        }

        float media = soma / tam;

        // Numeros acima da media
        String acima = "";
        for (int i = 0; i < tam; i++) {
            if (Integer.parseInt(nums[i]) > media) {
                acima += nums[i] + " ";
            }
        }

        System.out.println(acima);
    }
}
        
