import java.util.Scanner;

public class CalculaPosFinal {
    
    public static int calculaPosicaoFinal(int posicaoInicial, int velocidade, int tempo) {
        // Calcula a posicao final de um objeto utilzando a
        // funcao horaria do espaco
        return posicaoInicial + velocidade * tempo;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Dados relativos ao primeiro objeto
        int posInicial1 = scan.nextInt();
        int velocidade1 = scan.nextInt();
        // Dados relativos ao segundo objeto
        int posInicial2 = scan.nextInt();
        int velocidade2 = scan.nextInt();
        // Tempo decorrido
        int tempo = scan.nextInt();
        int posFinal1 = calculaPosicaoFinal(posInicial1, velocidade1, tempo);
        int posFinal2 = calculaPosicaoFinal(posInicial2, velocidade2, tempo);
        // Diferenca absoluta entre as posicoes dos objetos
        int dif = Math.abs(posFinal1 - posFinal2);
        System.out.println(dif);
    }
}
