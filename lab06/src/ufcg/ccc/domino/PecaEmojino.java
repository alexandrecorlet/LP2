package ufcg.ccc.domino;

import java.util.Map;
import java.util.HashMap;

/**
 * Representa peças Emojinó utilizadas para jogar o Dominó Brutal 3.0.
 *
 * @author Alexandre B. Corlet dos Santos
 */
public class PecaEmojino extends PecaAbstrata {

    /**
     * Mapeia o código unicode inteiro do emoji para o emoji
     */
    private char emojiEsquerdo;
    private char emojiDireito;

    public PecaEmojino(char emojiEsquerdo, char emojiDireito) {
        super((int) emojiEsquerdo, (int) emojiDireito);
        this.emojiEsquerdo = emojiEsquerdo;
        this.emojiDireito = emojiDireito;
    }

    /**
     * @return O emoji esquerdo da peça emojinó.
     */
    public char getValorEsquerdo() {
        return this.emojiEsquerdo;
    }

    /**
     * @return O emoji direito da peça emojinó.
     */
    public char getEmojiDireito() {
        return this.emojiDireito;
    }

}
