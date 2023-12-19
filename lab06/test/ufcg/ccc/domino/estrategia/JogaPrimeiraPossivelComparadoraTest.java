package ufcg.ccc.domino.estrategia;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

public class JogaPrimeiraPossivelComparadoraTest {

    private Mesa mesa;
    private Comparator<Peca> cmp;

    @BeforeEach
    void setUp() throws Exception {
        mesa = new Mesa();
        mesa.jogaNaDireita(new Peca(1, 2));
        mesa.jogaNaEsquerda(new Peca(1, 1));
        this.cmp = new PecaPadraoComparator();
    }

    @Test
    void testPassa() {
        JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivelComparadora(cmp);
        List<Peca> mao = Arrays.asList(new Peca(3, 6), new Peca(4, 5));

        Jogada j1 = estrategia.decideJogada(mao, mesa);

        assertEquals(Jogada.TipoJogada.PASSA, j1.getTipo());
    }

    @Test
    void testJogaNaDireita() {
        JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivelComparadora(cmp);
        List<Peca> mao = Arrays.asList(new Peca(3, 3), new Peca(2, 1),
                                            new Peca(2, 6));

        Jogada j1 = estrategia.decideJogada(mao, mesa);

        assertEquals(Jogada.TipoJogada.NA_DIREITA, j1.getTipo());
        assertEquals(2, j1.getPeca().getNumEsquerdo());
        assertEquals(1, j1.getPeca().getNumDireito());
    }

    @Test
    void testJogaNaEsquerda() {
        JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivelComparadora(cmp);
        List<Peca> mao = Arrays.asList(new Peca(3, 3), new Peca(4, 1));

        Jogada j1 = estrategia.decideJogada(mao, mesa);

        assertEquals(Jogada.TipoJogada.NA_ESQUERDA, j1.getTipo());
        assertEquals(4, j1.getPeca().getNumEsquerdo());
        assertEquals(1, j1.getPeca().getNumDireito());
    }

}
