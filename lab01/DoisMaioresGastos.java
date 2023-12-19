/**
* LP2 - lab 1
*
* @author Alexandre Santos, 119210883
*/

import java.util.Scanner;
import java.util.Arrays;

public class DoisMaioresGastos {
    
    // Converte array de string em array de inteiro
    public static int[] meuMap(String[] arr) {
        int n = arr.length;
        int[] novoArr = new int[n];
        for (int i = 0; i < n; i++) {
            novoArr[i] = Integer.parseInt(arr[i]);
        }
        return novoArr;
    }
         
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] linha = scan.nextLine().split(" ");
        int[] gastos = meuMap(linha);
        int n = gastos.length;
        Arrays.sort(gastos);
        System.out.println(gastos[n-1] + gastos[n-2]);
    }
}
