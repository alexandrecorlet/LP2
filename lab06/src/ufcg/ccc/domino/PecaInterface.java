// TODO: ALTERAR O getNumDireito PARA getValorDireito E getNumEsquerdo PARA getValorEsquerdo.

package ufcg.ccc.domino;

/**
 * Uma peça para jogar uma partida de dominó brutal.
 *
 * @author Alexandre B. Corlet dos Santos
 */
public interface PecaInterface {

    /**
     * Gira a peça fazendo com o que número da direita se torne
     * o número da esquerda e o da esquerda se torne o número
     * da direta.
     */
    void gira();

    /**
     * @return O valor no lado esquerdo da peça.
     */
    int getNumEsquerdo();

    /**
     * @return O valor no lado direito da peça.
     */
    int getNumDireito();

    /**
     * @return Verifica se a peça encaixa em algum lado da mesa.
     */
    boolean encaixa(int numero);

}
