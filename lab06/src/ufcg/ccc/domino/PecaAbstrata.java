package ufcg.ccc.domino;

/**
 * Representação abstrata de uma peça de dominó brutal. Define todas
 * as operações e características em comum entre as diferentes peças
 * criadas para jogar dominor brutal.
 *
 * @author Alexandre B. Corlet dos Santos
 *
 */
public abstract class PecaAbstrata implements PecaInterface {

    /**
     * O número direto da peça
     */
    private int numDireito;

    /**
     * O número esquerdo da peça
     */
    private int numEsquerdo;

    /**
     * Constrói uma peça abstrata.
     *
     * @param numDireito  O número da direita da peça.
     * @param numEsquerdo O número da esquerda da peça
     */
    public PecaAbstrata(int numDireito, int numEsquerdo) {
        this.numDireito = numDireito;
        this.numEsquerdo = numEsquerdo;
    }

    /**
     * @return O número da esquerda.
     */
    public int getNumEsquerdo() {
        return this.numEsquerdo;
    }

    /**
     * @return O número da direita.
     */
    public int getNumDireito() {
        return this.numDireito;
    }

    /**
     * Testa se a peça encaixa com um número.
     *
     * @param numero O número a testar.
     * @return true se um dos lados ao menos combinar com o número, false caso o contrário.
     */
    public boolean encaixa(int numero) {
        return this.numDireito == numero || this.numEsquerdo == numero;
    }


    /**
     * Inverte os lados dos números na peça.
     */
    public void gira() {
        int temp = this.numDireito;
        this.numDireito = this.numEsquerdo;
        this.numEsquerdo = temp;
    }

}
