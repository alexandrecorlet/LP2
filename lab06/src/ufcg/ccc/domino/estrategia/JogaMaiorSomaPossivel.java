package ufcg.ccc.domino.estrategia;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Peca;

import java.util.List;

/**
 * Joga sempre a peça que contém a  maior soma dos números na peça. A estratégia
 * sempre começa jogando a direita da mesa. Caso as peças de maior soma não encaixem,
 * então joga as peças de menor soma. Se as peças possuírem somas iguais, então joga
 * a primeira possível.
 *
 * @author Alexandre B. Corlet dos Santos
 */
public class JogaMaiorSomaPossivel implements EstrategiaDeJogo {

    /**
     * Decide a próxima jogada do jogador usando a estratégia
     * Joga Maior Soma Possiível.
     *
     * @param mao  As peças disponíveis para o jogador.
     * @param mesa O estado atual da mesa, com as peças já jogadas.
     *
     * @return A jogada.
     */
    @Override
    public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
        Peca maior = escolheMaiorPeca(mao, mesa);

        // passa a vez
        if (maior == null)
            return new Jogada();

        // joga peça a direta caso a mesa esteja vazia ou
        // caso a peça encaixe no número a direta
        if (maior.encaixa(mesa.getNumNaDireita()) || mesa.getNumPecas() == 0)
            return new Jogada(maior, TipoJogada.NA_DIREITA);

        // joga a peça na esquerda
        return new Jogada(maior, TipoJogada.NA_ESQUERDA);
    }

    /**
     * Retorna representação em String da estratégia.
     *
     * @return A representação em String da estratégia.
     */
    @Override
    public String toString() { return "Joga Maior Soma Possível"; }


    /**
     * Escolhe a peça que possui a maior soma de números na peça.
     *
     * @param mao As peças que o jogador possui.
     * @param mesa A mesa.
     * @return A peça que possui maior soma.
     */
    private Peca escolheMaiorPeca(List<Peca> mao, VisaoDaMesa mesa) {
        Peca maior = null;
        for (Peca peca : mao){

            boolean naoEncaixa = !(peca.encaixa(mesa.getNumNaEsquerda()) || peca.encaixa(mesa.getNumNaDireita()));
            // caso peça não encaixe, então continuo para outra peça
            if (naoEncaixa && mesa.getNumPecas() > 0)
                continue;

            // caso a peça encaixe, verifica se peça é maior do que a atual maior
            if (maior == null)
                maior = peca;
            else if (maior.getSoma() < peca.getSoma())
                maior = peca;

        }

        return maior;

    }

}