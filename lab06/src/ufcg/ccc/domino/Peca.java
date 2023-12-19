package ufcg.ccc.domino;

/**
 * Uma peça de dominó com dois lados.
 *
 */
public class Peca extends PecaAbstrata {

	/**
	 * O número esquerdo da peça
	 */
	private int numEsquerdo;

	/**
	 * O número direito da peça
	 */
	private int numDireito;

	/**
	 * Cria uma peça.
	 * 
	 * @param numEsquerdo Número do lado esquerdo.
	 * @param numDireito  Número do lado direito.
	 */
	public Peca(int numEsquerdo, int numDireito) {
		super(numEsquerdo, numDireito);
	}

	/**
	 * @return A representação em String da peça no formato "NUMESQUERDO:NUMDIREITO"
	 */
	@Override
	public String toString() {
		return this.getNumEsquerdo() + ":" + this.getNumDireito();
	}

	/**
	 * Calcula a soma do direito e esquerdo da peça.
	 *
	 * @return A soma dos números na peça
	 */
	public int getSoma() {
		return getNumDireito() + getNumEsquerdo();
	}

}
