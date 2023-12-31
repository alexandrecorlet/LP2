package ufcg.ccc.domino;

import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaCarrocasPorUltimo;
import ufcg.ccc.domino.estrategia.JogaMaiorSomaPossivel;


/**
 * Exemplo de como fazer uma disputa entre duas estratégias em uma UI.
 */
public class DominoBrutal {

	public static void main(String[] args) {
		Jogo j = new Jogo("J1", new JogaMaiorSomaPossivel(),
						  "J2", new JogaCarrocasPorUltimo(),
						  12);

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
