package ufcg.ccc.domino;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.*;


/**
 * Exemplo de como fazer uma disputa entre duas estratégias em uma UI.
 */
public class DominoBrutal {

	public static void main(String[] args) {
		List<EstrategiaDeJogo> estrategias = new ArrayList<>();
		estrategias.add(new JogaPrimeiraPossivel());
		estrategias.add(new JogaMaiorSomaPossivel());
		EstrategiaDeJogo estrategiaComposta = new EstrategiaDeJogoComposta(estrategias);
		Comparator<Peca> cmp = new PecaPadraoComparator();
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivelComparadora(cmp),  "J2", estrategiaComposta, 12);

		HistoricoDeJogo historico;
		
		try {
			historico = j.jogaJogoCompleto();
			System.out.println(historico.toString());
		} catch (EstrategiaInvalidaException e) {
			e.printStackTrace();
		} catch (JogadaInvalidaException e) {
			e.printStackTrace();
		}
		
	}

}
