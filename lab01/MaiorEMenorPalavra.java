import java.util.Scanner;

public class MaiorEMenorPalavra {
    
    public static void ImprimeMaiorMenorPalavra(String[] palavras) {
          // Imprime a maior e menor palavra de uma sequencia de palavras.
          // NOTE: caso as palavras possuam tamanhos iguais, imprime a mais antiga.
          String maior = palavras[0];
          String menor = palavras[0];
          for (String palavra : palavras) {
              int tamanhoPalavra = palavra.length();
              if (maior.length() < tamanhoPalavra) {
                  maior = palavra;
              }
              if (menor.length() > tamanhoPalavra) {
                  menor = palavra;
              }
          }
          System.out.println(menor);
          System.out.println(maior);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] palavras = new String[5];
        for (int i = 0; i < 5; i++) {
            String palavra = scan.nextLine();
            palavras[i] = palavra;
        }
        ImprimeMaiorMenorPalavra(palavras);
    }
}
