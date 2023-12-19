/**
* LP2 - lab 1
*
* @author Alexandre Santos, 119210883
*/

import java.util.Scanner;

public class ProgressaoAritmetica {
    
    // Converte array de String para array de Int
    public static int[] meuMap(String[] arr) {
        int n = arr.length;
        int[] novoArr = new int[n];
        for (int i = 0; i < n; i++) {
            novoArr[i] = Integer.parseInt(arr[i]);
        }
        return novoArr;
    }
    
    public static void imprimePA(int primeiroTermo, int razao,
    int quantidadeTermos) {
        System.out.print(primeiroTermo + " ");
        for (int i = 1; i < quantidadeTermos; i++) {
            primeiroTermo += razao;
            System.out.print(primeiroTermo + " ");
        }
        System.out.println();
    }
            
        
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] linha = scan.nextLine().split(" ");
        int[] dadosPA = meuMap(linha);
        int primeiroTermo = dadosPA[0];
        int razao = dadosPA[1];
        int quantidadeTermos = dadosPA[2];
        imprimePA(primeiroTermo, razao, quantidadeTermos);
    }
}
        
