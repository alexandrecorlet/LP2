import java.util.Scanner;

public class PalavrasPoeticas {
    
    public static boolean ehPalavrasPoeticas(String palavra1, String palavra2) {
        // Verifica se duas palavra sao poeticas. Para duas palavras serem
        // as primeiras e ultimas letras das palavras precisam ser iguais
        char primeiraLetra1 = palavra1.charAt(0);
        char ultimaLetra1 = palavra1.charAt(palavra1.length()-1);
        char primeiraLetra2 = palavra2.charAt(0);
        char ultimaLetra2 = palavra2.charAt(palavra2.length()-1);
        return primeiraLetra1 == primeiraLetra2 && ultimaLetra1 == ultimaLetra2;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String palavra1 = scan.nextLine();
        String palavra2 = scan.nextLine();

        if (ehPalavrasPoeticas(palavra1, palavra2)) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }
    }
}
