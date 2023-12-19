package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author Alexandre Santos
 *
 */
public class Agenda {
	
	/**
	 * O tamanho da agenda.
	 */
	private static final int TAMANHO_AGENDA = 100;

	/**
	 * O tamanho da lista de contatos favoritos
	 */
	private static final int TAMANHO_FAVORITOS = 10;
	
	/**
	 * Lista com todos os contatos da Agenda
	 */
	private Contato[] contatos;

	/**
	 * Lista com contatos favoritos
	 */
	private Contato[] favoritos;

	/**
	 * Verifica se um contato já foi cadastrado em uma
	 * lista de contatos.
	 * 
	 * @posicao A posição do contato na lista de contatos.
	 * @contatos A lista de contatos no qual o contato será buscado.
	 * @return true se contato tiver sido cadastrado, false caso contrário.
	 */
	private boolean isCadastrado(Contato contato, Contato[] contatos) {
		for (Contato c: contatos) {
			if (c != null) {
				if (c.equals(contato)){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @return Os dados do contato.
	 */
	public String getContato(int posicaoAgenda) {	
		Contato contato = this.contatos[posicaoAgenda-1];

		if (!isCadastrado(contato, this.contatos)) {
			return "";
		} else if (isCadastrado(contato, this.favoritos)) {
			return "❤️ " + this.contatos[posicaoAgenda-1].toString();
		}

		return this.contatos[posicaoAgenda-1].toString();
	}

	/**
	 * Cadastra um contato em uma posição. 
	 * Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * Um contato só pode ser cadastrado entre as posições 1 e 100.
	 * Contatos que já estão cadastrados não podem ser cadastrados novamente.
	 * 
	 * @param posicaoAgenda Posição do contato.
	 * @param nome Nome do contato.
	 * @return true se o contato tiver sido cadastrado, false caso contrário.
	 */
	public boolean cadastraContato(int posicaoAgenda, String nome, String sobrenome, 
									String numPrincipal, String numWhatsapp, String numAdicional) {
		
		Contato contato = new Contato(nome, sobrenome, numPrincipal, numWhatsapp, numAdicional);

		if (isCadastrado(contato, this.contatos)) {
			return false;
		}

		this.contatos[posicaoAgenda-1] = contato;

		return true;
	}

	/**
	 * Adiciona um contato a lista
	 * de contatos favoritos.
	 * 
	 * @posicaoAgenda A posicao do contato na agenda.
	 * @posicaoFavoritos A posicao que o contato será adicionado na lista de favoritos.
	 * @return true se o contato for adicionado com sucesso, false caso contrário.
	 */
	public boolean adicionaFavorito(int posicaoAgenda, int posicaoFavoritos) {
		Contato contato = this.contatos[posicaoAgenda-1];

		if (isCadastrado(contato, this.favoritos)) {
			return false;
		}
		
		this.favoritos[posicaoFavoritos-1] = contato;
		return true;
	}

	/**
	 * Acessa a lista de contatos favoritos mantida.
	 * 
	 * @return Uma cópia da lista de contatos favoritos.
	 */
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}

	/**
	 * Modifica o telefone prioritário de um contato
	 * para um novo.
	 * 
	 * @param posicaoAgenda A posição do contato na agenda.
	 * @param novoNumPrioritario O novo telefone prioritário do contato.
	 * @return true se a alteração tiver ocorrido, false caso contrário.
	 */
	public boolean setTelefonePrioritario(int posicaoAgenda, String novoNumPrioritario) {
		if (!isCadastrado(this.contatos[posicaoAgenda-1], this.contatos)) {
			return false;
		}

		this.contatos[posicaoAgenda-1].setTelefonePrioritario(novoNumPrioritario);
		return true;
	}

	/**
	 * Remove o contato da lista de contatos favoritos.
	 * 
	 * @param posicaoFavoritos A posição do contato na lista de favoritos.
	 * @return true se o contato tiver sido removido dos favoritos, false caso contrário.
	 */
	public boolean removeContatoFavorito(int posicaoFavoritos) {
		if (!isCadastrado(this.contatos[posicaoFavoritos-1], this.favoritos)) {
			return false;
		}
		this.favoritos[posicaoFavoritos-1] = null;
		return true;
	}

	/**
	 * Calcula posição de um contato na lista de favoritos.
	 * Caso o contato não seja cadastrado na lista de favoritos,
	 * então retorna -1.
	 * 
	 * @param contato O contato que terá a posição calculada.
	 * @return A posição do contato na lista de favoritos.
	 */
	private int getPosicaoFavorito(Contato contato) {
		for (int i = 0; i < TAMANHO_FAVORITOS; i++) {
			if (contato.equals(this.favoritos[i])) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Remove um contato da lista de contatos e
	 * da lista de contatos favoritos (caso seja
	 * um contato favorito).
	 * 
	 * @param posicaoAgenda A posição do contato na agenda.
	 * @return true se o contato for removido, false caso contrário.
	 */
	public boolean removeContatoAgenda(int posicaoAgenda) {
		Contato contato = this.contatos[posicaoAgenda-1];

		if (!isCadastrado(this.contatos[posicaoAgenda-1], this.contatos)) {
			return false;
		}

		// Remove o contato da lista de favoritos
		// caso também seja um contato favorito.
		if (isCadastrado(contato, this.favoritos)) {
			int posicaoFavoritos = getPosicaoFavorito(this.contatos[posicaoAgenda-1]);
			removeContatoFavorito(posicaoFavoritos+1);
		}

		this.contatos[posicaoAgenda-1] = null;
		return true;
	}

	/**
	 * Realiza uma busca na agenda
	 * para encontrar contatos que
	 * possuam o nome/sobrenome pesquisado.
	 * 
	 * @param nome O nome a ser pesquisado na agenda.
	 * @return Exibição dos contatos que possuem esse nome.
	 */
	public void pesquisarContato(String nome) {
		for (Contato c: this.contatos) {
			if (c != null) {
				String nomeCompletoContato = c.getNomeCompleto().toUpperCase();
				String nomePesquisado = nome.toUpperCase();
				if (nomeCompletoContato.contains(nomePesquisado)) {
					System.out.println(c.toString());
				}
			}
		}
	}

}