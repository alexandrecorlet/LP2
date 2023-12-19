package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;
import ufcg.ccc.domino.Jogo.TipoVitoria;

class JogoTest {

	@Test
	void testRodadaInicial() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 14);

		assertEquals(0, j.getNumRodadas());
		assertEquals(14, j.getNumPecasJ1());
		assertEquals(14, j.getNumPecasJ2());

		j.rodada();

		assertEquals(1, j.getNumRodadas());
		assertEquals(13, j.getNumPecasJ1());
		assertEquals(13, j.getNumPecasJ2());
	}
	
	@Test
	void testJogoAleatorio() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 10, new Random(1));

		HistoricoDeJogo historico = j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		
		System.out.println(historico.toString());
	}

	@Test
	void testVencedorJ1Simples() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
	}
	
	@Test
	void testEmpate() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertNull(j.getVencedor());
	}
	
	@Test
	void testVitoriaJ2() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(6, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(1, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
	}

	@Test
	void testDesempatePorSomaDasPecas() throws Exception {
		List<Peca> mao1 = List.of(new Peca(6, 4), new Peca(1, 3));
		List<Peca> mao2 = List.of(new Peca(2, 5), new Peca(0, 0));

		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
	}

	@Test
	void testDesempatePorQuantidadeDePecas() throws Exception {
		List<Peca> mao1 = List.of(new Peca(6, 4), new Peca(1, 3), new Peca(5, 5));
		List<Peca> mao2 = List.of(new Peca(2, 5), new Peca(6, 0));

		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
	}

	@Test
	void testVitoriaBatida() throws Exception {
		List<Peca> mao1 = List.of(new Peca(6, 1), new Peca(1, 3));
		List<Peca> mao2 = List.of(new Peca(2, 5), new Peca(6, 0));

		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals(1, j.getPontuacao());
		assertEquals(TipoVitoria.BATIDA, j.getTipoVitoria());
	}

	@Test
	void testVitoriaCarroca() throws Exception {
		List<Peca> mao1 = List.of(new Peca(6, 1), new Peca(1, 1));
		List<Peca> mao2 = List.of(new Peca(2, 5), new Peca(6, 0));

		Jogo j = new  Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals(2, j.getPontuacao());
		assertEquals(TipoVitoria.CARROCA, j.getTipoVitoria());
	}

	@Test
	void testVitoriaLaLo() throws Exception {
		List<Peca> mao1 = List.of(new Peca(6, 1), new Peca(0, 1));
		List<Peca> mao2 = List.of(new Peca(2, 5), new Peca(6, 0));

		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals(3, j.getPontuacao());
		assertEquals(TipoVitoria.LA_E_LO, j.getTipoVitoria());
	}

	@Test
	void testVitoriaCruzada() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 0));
		List<Peca> mao2 = List.of(new Peca(2, 5), new Peca(0, 0));

		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals(6, j.getPontuacao());
		assertEquals(TipoVitoria.CRUZADA, j.getTipoVitoria());
	}
}
