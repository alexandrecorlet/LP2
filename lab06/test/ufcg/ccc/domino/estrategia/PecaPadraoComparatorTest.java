package ufcg.ccc.domino.estrategia;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ufcg.ccc.domino.Peca;

public class PecaPadraoComparatorTest {

    private Comparator<Peca> cmp;

    @BeforeEach
    public void setup() {
        this.cmp = new PecaPadraoComparator();
    }

    @Test
    public void comparaPecaMenorComMaiorTest1() {
        Peca p1 = new Peca(1, 2);
        Peca p2 = new Peca(0, 3);

        assertEquals(-1, this.cmp.compare(p1, p2));
    }

    @Test
    public void comparaPecaMenorComMaiorTest2() {
        Peca p1 = new Peca(1, 2);
        Peca p2 = new Peca(2, 2);

        assertEquals(-1, this.cmp.compare(p1, p2));
    }

    @Test
    public void comparaPecasNumIguais() {
        Peca p1 = new Peca(6, 6);
        Peca p2 = new Peca(6, 6);

        assertEquals(0, this.cmp.compare(p1, p2));
    }

    @Test
    public void comparaPecaMaiorComMenorTest1() {
        Peca p1 = new Peca(6, 5);
        Peca p2 = new Peca(3, 2);

        assertEquals(1, this.cmp.compare(p1, p2));
    }

    @Test
    public void comparaPecaMaiorComMenorTest2() {
        Peca p1 = new Peca(4, 3);
        Peca p2 = new Peca(3, 3);

        assertEquals(1, this.cmp.compare(p1, p2));
    }

}
