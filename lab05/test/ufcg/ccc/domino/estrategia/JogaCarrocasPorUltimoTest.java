package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

public class JogaCarrocasPorUltimoTest {

    private Mesa mesa;

    @BeforeEach
    void setUp() throws Exception {
        mesa = new Mesa();
        mesa.jogaNaDireita(new Peca(2, 2));
        mesa.jogaNaEsquerda(new Peca(1, 2));
    }

    @Test
    void testPassa() {
        JogaCarrocasPorUltimo estrategia = new JogaCarrocasPorUltimo();

        Jogada j = estrategia.decideJogada(List.of(new Peca(5, 6), new Peca(6, 5)), mesa);

        assertEquals(TipoJogada.PASSA, j.getTipo());
    }

    @Test
    void testJogaPecaSimples() {
        JogaCarrocasPorUltimo estrategia = new JogaCarrocasPorUltimo();

        Jogada j = estrategia.decideJogada(List.of(new Peca(2, 2), new Peca(2, 1)), mesa);

        assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
        assertEquals(2, j.getPeca().getNumEsquerdo());
        assertEquals(1, j.getPeca().getNumDireito());
    }

    @Test
    void testJogaPrimeiraCarroca() {
        JogaCarrocasPorUltimo estrategia = new JogaCarrocasPorUltimo();

        Jogada j = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(5, 6), new Peca(2, 1)), mesa);

        assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
        assertEquals(2, j.getPeca().getNumEsquerdo());
        assertEquals(1, j.getPeca().getNumDireito());
    }

    @Test
    void testJogaNaEsquerda() {
        JogaCarrocasPorUltimo estrategia = new JogaCarrocasPorUltimo();

        Jogada j = estrategia.decideJogada(List.of(new Peca(6, 6), new Peca(6, 1), new Peca(4, 4)), mesa);

        assertEquals(TipoJogada.NA_ESQUERDA, j.getTipo());
        assertEquals(6, j.getPeca().getNumEsquerdo());
        assertEquals(1, j.getPeca().getNumDireito());
    }

    @Test
    void testJogaPrimeiraCarrocaPossivel() {
        JogaCarrocasPorUltimo estrategia = new JogaCarrocasPorUltimo();

        Jogada j = estrategia.decideJogada(List.of(new Peca(2, 2), new Peca(1, 1), new Peca(1, 1)), mesa);

        assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
        assertEquals(2, j.getPeca().getNumEsquerdo());
        assertEquals(2, j.getPeca().getNumDireito());
    }
}
