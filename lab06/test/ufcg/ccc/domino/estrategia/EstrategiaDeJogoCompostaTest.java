package ufcg.ccc.domino.estrategia;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.JogadaInvalidaException;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Mesa;

class EstrategiaDeJogoCompostaTest {

    /**
     * Classe para facilitar nos testes de classe composta. Esta classe contabiliza
     * quantas vezes a estratégia foi selecionada por estratégia composta validando
     * o decideJogada de EstratégiaDeJogoComposta.
     *
     * @author Alexandre B. Corlet dos Santos
     */
    private class EstrategiaDeJogoTeste implements EstrategiaDeJogo {

        /**
         * A quantidade de vezes que a estratégia foi selecionada
         */
        int quantidadeVezesSelecionada;

        public EstrategiaDeJogoTeste() {
            this.quantidadeVezesSelecionada = 0;
        }

        @Override
        public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
            this.quantidadeVezesSelecionada++;
            return null;
        }

        /**
         * @return A quantidade de vezes que a estratégia foi selecionada
         */
        public int getQuantidadeVezesSelecionada() {
            return quantidadeVezesSelecionada;
        }
    }

    private Mesa mesa;

    @BeforeEach
    void setup() throws JogadaInvalidaException {
        this.mesa = new Mesa();
        this.mesa.jogaNaEsquerda(new Peca(1, 2));
        this.mesa.jogaNaDireita(new Peca(2, 1));
    }
    @Test
    void getEstrategiaAtual() {

        EstrategiaDeJogoTeste e1 = new EstrategiaDeJogoTeste();
        EstrategiaDeJogoTeste e2 = new EstrategiaDeJogoTeste();

        LinkedList<EstrategiaDeJogo> estrategias = new LinkedList<>();

        estrategias.add(e1);
        estrategias.add(e2);


        EstrategiaDeJogoComposta e = new EstrategiaDeJogoComposta(estrategias);

        List<Peca> pecas = Arrays.asList(new Peca(3, 2), new Peca(5, 4));

        // constata que a estratégia na cabeça da "fila" naão foi selecionada nenhuma vez
        assertEquals(0, e1.getQuantidadeVezesSelecionada());

        // joga a jogada utilizando a estratégia na cabeça da fila.
        e.decideJogada(pecas, this.mesa);

        // constata que a estratégia e1 foi utilizada 1 vez.
        assertEquals(1, e1.getQuantidadeVezesSelecionada());

        // utiliza e2 para jogar a próxima jogada
        e.decideJogada(pecas, this.mesa);

        // constata que a estratégia e2 foi utilizada.
        assertEquals(1, e2.getQuantidadeVezesSelecionada());

        e.decideJogada(pecas, this.mesa);

        // constata que e1 foi reutilizada pois está novamente no topo da fila
        assertEquals(2, e1.getQuantidadeVezesSelecionada());
    }
}