package ufcg.ccc.domino;

import java.util.Map;
import java.util.HashMap;

import ufcg.ccc.domino.estrategia.*;
import ufcg.ccc.domino.Jogo.TipoVitoria;

/**
 * Exemplo de como fazer um um main com uma disputa de muuuitos jogos entre duas
 * estratégias.
 */
public class DominoBrutalRepetido {
	
	private static final int NUM_PECAS_INICIAL = 12;
	private static final int REPETICOES = 50000;

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		float vitoriasJ1 = 0, vitoriasJ2 = 0, empates = 0;
		int pontuacaoJ1 = 0, pontuacaoJ2 = 0;

		// estatísticas de cada jogador (pontuação, batidas, carroças, etc.)
		Map<TipoVitoria, Integer> estatisticaBrutalJ1 = criaEstatisticasBrutais();
		Map<TipoVitoria, Integer> estatisticaBrutalJ2 = criaEstatisticasBrutais();

		EstrategiaDeJogo estrategia1 = new JogaCarrocasPorUltimo(), estrategia2 = new JogaMaiorSomaPossivel();
		
		for (int i = 0; i < REPETICOES; i++) {
			
			Jogo j;
			
			// Cada estratégia começa jogando metade das partidas.
			if( i < REPETICOES / 2) {
				j = new Jogo("J1", estrategia1, "J2", estrategia2, NUM_PECAS_INICIAL);
			} else {
				j = new Jogo("J2", estrategia2, "J1", estrategia1, NUM_PECAS_INICIAL);
			}
			
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				vitoriasJ1++;
				pontuacaoJ1 += historico.getPontuacao();
				TipoVitoria tipoVitoria = historico.getTipoVitoria();
				estatisticaBrutalJ1.put(tipoVitoria, estatisticaBrutalJ1.get(tipoVitoria)+1);
			} else if (historico.getVencedor() == "J2") {
				vitoriasJ2++;
				pontuacaoJ2 += historico.getPontuacao();
				TipoVitoria tipoVitoria = historico.getTipoVitoria();
				estatisticaBrutalJ2.put(tipoVitoria, estatisticaBrutalJ2.get(tipoVitoria)+1);
			}
		}

		System.out.println(
				"E1: " + estrategia1.toString() 
				+ "\nE2: " + estrategia2.toString()
				+ "\nJogos:\t" + (REPETICOES) 
				+ "\n- Vitórias E1:\t" + vitoriasJ1 + " vitórias (" + Math.round(vitoriasJ1 / REPETICOES * 100) + "%)"
				+ "\n- Vitórias E2:\t" + vitoriasJ2 + " vitórias (" + Math.round(vitoriasJ2 / REPETICOES * 100) + "%)"
				+ "\n- Empates:\t" + empates + "\t\t(" + Math.round(empates / REPETICOES * 100) + "%)"
				+ "\n\nESTATÍSTICA JOGADORES: "
				+ "\n\nJOGADOR1:"
				+ "\n- Vitórias J1:\t" + vitoriasJ1
				+ "\n- Derrotas J1\t" + vitoriasJ2
				+ "\n- Pontuação J1:\t" + pontuacaoJ1
				+ "\n- Batidas J1:\t" + estatisticaBrutalJ1.get(TipoVitoria.BATIDA)
				+ "\n- Carroças J1:\t" + estatisticaBrutalJ1.get(TipoVitoria.CARROCA)
				+ "\n- Lá e Ló J1:\t" + estatisticaBrutalJ1.get(TipoVitoria.LA_E_LO)
				+ "\n- Cruzadas J1:\t" + estatisticaBrutalJ1.get(TipoVitoria.CRUZADA)
				+ "\n\nJOGADOR2: "
				+ "\n- Vitórias J2:\t" + vitoriasJ2
				+ "\n- Derrotas J2:\t" + vitoriasJ1
				+ "\n- Pontuação J2:\t" + pontuacaoJ2
				+ "\n- Batidas J2:\t" + estatisticaBrutalJ2.get(TipoVitoria.BATIDA)
				+ "\n- Carroças J2:\t" + estatisticaBrutalJ2.get(TipoVitoria.CARROCA)
				+ "\n- Lá e Ló J2:\t" + estatisticaBrutalJ2.get(TipoVitoria.LA_E_LO)
				+ "\n- Cruzadas J2:\t" + estatisticaBrutalJ2.get(TipoVitoria.CRUZADA));

	}

	/**
	 * Cria estatísticas para cada um dos jogadores de Dominó Brutal
	 *
	 * @return Mapa de tipoVitória es
	 */
	private static Map<TipoVitoria, Integer> criaEstatisticasBrutais() {
		Map<TipoVitoria, Integer> estatisticaBrutal = new HashMap<>() {{
			put(TipoVitoria.BATIDA, 0);
			put(TipoVitoria.CARROCA, 0);
			put(TipoVitoria.LA_E_LO, 0);
			put(TipoVitoria.CRUZADA, 0);
		}};

		return estatisticaBrutal;
	}
}
