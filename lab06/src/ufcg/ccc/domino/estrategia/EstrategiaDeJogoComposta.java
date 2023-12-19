package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

/**
 * Representa a estratégia de jogo composta. Em cada
 * rodada, a estratégia utiliza uma estratégia diferente
 * para a jogada.
 *
 * @author Alexandre B. Corlet dos Santos
 *
 */
public class EstrategiaDeJogoComposta implements EstrategiaDeJogo {

    /**
     * Lista de estratégias que estratégia composta utilizará em cada jogada
     */
    private List<EstrategiaDeJogo> estrategias;

    /**
     * Constrói uma estratégia composta a partir
     * das estratégias que o jogador irá utilizar
     * em cada jogada
     *
     * @param estrategias A lista de estratégias que serão utilizadas
     */
    public EstrategiaDeJogoComposta(List<EstrategiaDeJogo> estrategias) {
        if (estrategias.size() == 0)
            throw new IllegalArgumentException("lista de estratégias não tem nenhuma estratégia");

        this.estrategias = estrategias;
    }

    @Override
    public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
        EstrategiaDeJogo estrategiaSelecionada = selecionaEstrategia(this.estrategias);
        return estrategiaSelecionada.decideJogada(mao, mesa);
    }

    /**
     * Decide a estratégia que será utilizada na próxima jogada.
     *
     * @param estrategias A lista de estratégias
     * @return A estratégia escolhida.
     */
    private EstrategiaDeJogo selecionaEstrategia(List<EstrategiaDeJogo> estrategias) {
        // escolhe estratégia da próxima jogada
        EstrategiaDeJogo e = this.estrategias.remove(0);

        // põe a estratégia escolhida no final da "fila"
        this.estrategias.add(e);

        return e;
    }

    public EstrategiaDeJogo getEstrategiaAtual() {
        return this.estrategias.get(0);
    }

    /**
     * @return A representação em String da estratégia
     */
    public String toString() { return "Estratégia de Jogo Composta"; }

}
