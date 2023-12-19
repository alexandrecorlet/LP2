package ufcg.ccc.domino.estrategia;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

/**
 * Representa a estratégia Joga Primeira Possível Comparadora. A estratégia
 * ordena as peças da mão do jogador de acordo com a ordem recebida pelo
 * Comparator e depois utiliza a estrategia JogaPrimeiraPossivel para
 * decidir a próxima jogada.
 *
 * @author Alexandre B. Corlet dos Santos
 */
public class JogaPrimeiraPossivelComparadora extends JogaPrimeiraPossivel {

    /**
     * O comparador de peças.
     */
    private Comparator<Peca> cmp;

    /**
     * Constrói a estratégia joga primeira possivel comparadora
     *
     * @param cmp O comparador de peças
     */
    public JogaPrimeiraPossivelComparadora(Comparator<Peca> cmp) {
        this.cmp = cmp;
    }

    /**
     * Decide a jogada a próxima jogada do jogador.
     *
     * @param mao   As peças que o jogador possui em sua mão
     * @param mesa  A mesa.
     * @return A jogada escolhida pela estratégia do jogador
     */
    @Override
    public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
        // ordena as peças da mão jogador antes de cada jogada
        Collections.sort(mao, this.cmp);

        // joga primeira peça possível da mão ordenada
        return super.decideJogada(mao, mesa);
    }

    public String toString() { return "Estratégia Joga Pirmeira Possível Comparadora"; }
}
