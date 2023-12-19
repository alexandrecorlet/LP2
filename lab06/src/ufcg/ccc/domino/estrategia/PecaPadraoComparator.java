package ufcg.ccc.domino.estrategia;

import java.util.Comparator;

import ufcg.ccc.domino.Peca;

/**
 * Um comparador de peças que ordena as peças primeiro
 * pelos números da direita e depois pelos números da esquerda.
 *
 * @author Alexandre B. Corlet dos Santos
 */
public class PecaPadraoComparator implements Comparator<Peca> {

    /**
     * Compara duas peças. Primeiro compara o número
     * da direita e depois da esquerda.
     *
     * @param p1 A peça1 a ser comparada
     * @param p2 A peça2 a ser comparada.
     * @return
     */
    @Override
    public int compare(Peca p1, Peca p2) {
        int NumDireitoP1 = p1.getNumDireito(), NumDireitoP2 = p2.getNumDireito();
        int NumEsquerdoP1 = p1.getNumEsquerdo(), NumEsquerdoP2 = p2.getNumEsquerdo();

        if (NumDireitoP1 < NumDireitoP2) {
            // p1 é menor
            return -1;
        } else if (NumDireitoP1 > NumDireitoP2) {
            // p1 é maior
            return 1;
        } else if (NumEsquerdoP1 < NumEsquerdoP2) {
            // p1 é menor
            return -1;
        } else if (NumEsquerdoP1 > NumEsquerdoP2) {
            // p1 é maior
            return 1;
        }

        // as duas peças são iguais
        return 0;

    }
}
