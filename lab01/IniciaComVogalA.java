import java.util.Scanner;

public class IniciaComVogalA {
    
    public static boolean iniciaComA(String palavra) {
        char letraInicial = palavra.charAt(0);
        return letraInicial == 'a';
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String palavra = scan.nextLine();
            if (iniciaComA(palavra)) {
                System.out.println("s");
            } else {
                System.out.println("n");
            }
        }
    }
}
