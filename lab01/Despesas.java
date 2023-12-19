/**
* LP2 - lab 1
*
* @author Alexandre Santos - 119210883
*/

import java.util.Scanner;
import java.util.stream.IntStream;

public class Despesas {
    
    // Converte todos elementos de um arr de String
    // para o tipo primitivo int
    public static int[] MapParaInt(String[] arr) {
        int n = arr.length;
        int[] novoArr = new int[n];
        for (int i = 0; i < n; i++) {
            novoArr[i] = Integer.parseInt(arr[i]);
        }
        return novoArr;
    }
    
    // Calcula a menor de todas despesas
    public static int menorDespesa(int[] despesas) {
        int menor = Integer.MAX_VALUE;
        for (int despesa : despesas) {
            menor = Math.min(despesa, menor);
        }
        return menor;
    }
    
    // Calcula a maior de todas despesas
    public static int maiorDespesa(int[] despesas) {
        int maior = Integer.MIN_VALUE;
        for (int despesa : despesas) {
            maior = Math.max(despesa, maior);
        }
        return maior;
    }
    
    // Somatorio de todas despesas
    public static int totalDespesas(int[] despesas) {
        int total = 0;
        for (int despesa : despesas) {
            total += despesa;
        }
        return total;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            String[] linha = scan.nextLine().split(" ");
            
            int[] despesas = MapParaInt(linha);

            int total = totalDespesas(despesas);
            int menor = menorDespesa(despesas);
            int maior = maiorDespesa(despesas);

            System.out.println(total + " " + menor + " " + maior);
        }
    }
}
