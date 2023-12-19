package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Peca;

/**
 * Escolhe apenas as peças simples para serem jogadas primeiro. As peças com números
 * iguais (carroças) são jogadas somente no final ou caso não haja outra opção de jogada.
 * A estratégia sempre tenta jogar primeiro a direita, para depois jogar a esquerda. Se o
 * jogador soó possuir peças carroças, então joga a primeira possível.
 *
 * @author Alexandre B. Corlet dos Santos
 */
public class JogaCarrocasPorUltimo implements EstrategiaDeJogo {

    /**
     * Decide a próxima jogada do jogador utilizando
     * a estratégia Joga Carroças Por Último.
     *
     * @param mao  As peças disponíveis para o jogador.
     * @param mesa O estado atual da mesa, com as peças já jogadas.
     *
     * @return A jogada.
     */
    @Override
    public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
        while (true) {
            // escolhe peça simples a ser jogada
            Peca peca = escolhePeca(mao, mesa, false);

            // caso não haja peça simples que encaixem, então é escolhido uma peça carroça
            if (peca == null) {
                // escolhe peça carroça a ser jogada
                peca = escolhePeca(mao, mesa, true);
                if (peca == null) break;    // passa a jogada
            }

            // joga a peça simples, começa tentando jogar na direta.
            if (mesa.getNumPecas() == 0)
                return new Jogada(peca, TipoJogada.NA_DIREITA);
            if (peca.encaixa(mesa.getNumNaDireita()))
                return new Jogada(peca, TipoJogada.NA_DIREITA);
            return new Jogada(peca, TipoJogada.NA_ESQUERDA);

        }

        return new Jogada();
    }

    /**
     * Escolhe uma peça da mão do jogador. O jogador pode escolher
     * se quer uma peça simples ou peça carroça. Caso não haja
     * peças com a característica desejada, então retorna null.
     *
     * @param mao         As peças que o jogador possui.
     * @param mesa        A mesa.
     * @param querCarroca Parâmetro que permite que o jogador escolha
     *                    que a peça retornada seja carroça ou simples.
     * @return            Uma peça com a característica desejada pelo jogador.
     */
    private Peca escolhePeca(List<Peca> mao, VisaoDaMesa mesa, boolean querCarroca) {
        for (Peca peca : mao) {
            boolean naoEncaixa = !(peca.encaixa(mesa.getNumNaEsquerda()) || peca.encaixa(mesa.getNumNaDireita()));

            // caso não encaixe em nenhuma peça em aberto da mesa, escolhe outra
            if (naoEncaixa && mesa.getNumPecas() > 0)
                continue;

            boolean ehCarroca = peca.getNumDireito() == peca.getNumEsquerdo(); // verifica se a peça é carroça

            // escolhe a peça com a característica desejada pelo jogador.
            if ((querCarroca && ehCarroca))
                return peca;
            if (!querCarroca && !ehCarroca)
                return peca;
        }

        return null;
    }

    /**
     * Representação em String da estratégia Joga Carroças por Último
     * @return A string que representa a estratégia
     */
    @Override
    public String toString() { return "Joga Carroças Por Último"; }

}
