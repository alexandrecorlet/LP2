package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

public class JogaMaiorSomaPossivelTest {

    private Mesa mesa;

    @BeforeEach
    void setUp() throws Exception {
        mesa = new Mesa();
        mesa.jogaNaDireita(new Peca(1, 2));
        mesa.jogaNaEsquerda(new Peca(1, 1));
    }

    @Test
    void testPassa() {
        JogaMaiorSomaPossivel estrategia = new JogaMaiorSomaPossivel();

        Jogada j = estrategia.decideJogada(List.of(new Peca(4, 4), new Peca(6, 6)), mesa);

        assertEquals(TipoJogada.PASSA, j.getTipo());
    }

    @Test
    void testJogaMaiorSomaPrimeiroDireita() {
        JogaMaiorSomaPossivel estrategia = new JogaMaiorSomaPossivel();

        Jogada j = estrategia.decideJogada(List.of(new Peca(1, 2), new Peca(3, 2), new Peca(3, 1)), mesa);

        assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
        assertEquals(3, j.getPeca().getNumEsquerdo());
        assertEquals(2, j.getPeca().getNumDireito());
    }

    @Test
    void testJogaMaiorSomaEsquerda() {
        JogaMaiorSomaPossivel estrategia = new JogaMaiorSomaPossivel();

        Jogada j = estrategia.decideJogada(List.of(new Peca(1, 2), new Peca(3, 2), new Peca(1, 6)), mesa);

        assertEquals(TipoJogada.NA_ESQUERDA, j.getTipo());
        assertEquals(1, j.getPeca().getNumEsquerdo());
        assertEquals(6, j.getPeca().getNumDireito());
    }

    @Test
    void testJogaMenorSoma() {
        JogaMaiorSomaPossivel estrategia = new JogaMaiorSomaPossivel();

        Jogada j = estrategia.decideJogada(List.of(new Peca(1, 2), new Peca(6, 5), new Peca(4, 6)), mesa);

        assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
        assertEquals(1, j.getPeca().getNumEsquerdo());
        assertEquals(2, j.getPeca().getNumDireito());
    }

    @Test
    void testJogaSomasIguais() {
        JogaMaiorSomaPossivel estrategia = new JogaMaiorSomaPossivel();

        Jogada j = estrategia.decideJogada(List.of(new Peca(1, 2), new Peca(2, 1), new Peca(1, 2)), mesa);

        assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
        assertEquals(1, j.getPeca().getNumEsquerdo());
        assertEquals(2, j.getPeca().getNumDireito());

    }

}
