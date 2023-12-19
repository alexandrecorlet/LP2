package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author Alexandre Santos
 *
 */
public class MainAgenda {


	public static void main(String[] args) {
		Agenda agenda = new Agenda();


		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(S)air\n" +
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(M)udar Telefone\n" +
						"(R)emover Contato\n" +
						"(P)esquisar Contato\n" +

						"\nOpção> ");

		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			Favoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "M":
			mudarTelefone(agenda, scanner);
			break;
		case "R":
			removerContato(agenda, scanner);
			break;
		case "P":
			pesquisarContato(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato: ");
		int posicao = scanner.nextInt();

		if (isPosicaoInvalida(posicao, 100)) {
			System.out.println("POSIÇÃO INVÁLIDA");
		}
		
		String dadosContato = agenda.getContato(posicao);
		
		if (dadosContato.isBlank()) {
			System.out.println("CONTATO NÃO CADASTRADO");
		} else {
		System.out.println("\n" + dadosContato);
		}

	}

	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contato) {
		return posicao+1 + " - " + contato.getNomeCompleto();
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda: ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Sobrenome: ");
		String sobrenome = scanner.nextLine();
		System.out.print("Prioritário: ");
		String prioritario = scanner.nextLine();
		System.out.print("Whatsapp: ");
		String whatsapp = scanner.nextLine();
		System.out.print("Adicional: ");
		String adicional = scanner.nextLine();

		if (isPosicaoInvalida(posicao, 100)) {
			System.out.println("POSIÇÃO INVÁLIDA");
		} else {

			boolean cadastro = agenda.cadastraContato(posicao, nome, sobrenome, prioritario, whatsapp, adicional);

			if (!cadastro) {
				System.out.println("CONTATO JA CADASTRADO!");
			} else {
				System.out.println("CADASTRO REALIZADO");
			}
		}
			
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}

	/**
	 * Lista os contatos favoritos da agenda.
	 * 
	 * @agenda A agenda.
	 */
	private static void Favoritos(Agenda agenda) {
		Contato[] favoritos = agenda.getFavoritos();
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				System.out.println(formataContato(i, favoritos[i]));
			}
		}
	}

	/**
	 * Cadastra um contato como contato favorito.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato: ");
		int posicaoAgenda = scanner.nextInt();
		System.out.print("\nPosição: ");
		int posicaoFavoritos = scanner.nextInt();

		if (isPosicaoInvalida(posicaoAgenda, 100)) {
			System.out.println("POSIÇÃO INVÁLIDA");
		} else if (isPosicaoInvalida(posicaoFavoritos, 10)) {
			System.out.println("POSIÇÃO INVÁLIDA");
		} else {

			boolean cadastro = agenda.adicionaFavorito(posicaoAgenda, posicaoFavoritos);

			if (cadastro) {
				System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicaoFavoritos + "!");
			} else {
				System.out.println("CONTATO JÁ CADASTRADO!");
			}
		}
	}

	/**
	 * Modifica o telefone prioritário de um contato.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void mudarTelefone(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda: ");
		int posicaoAgenda = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Novo telefone prioritário: ");
		String novoNumPrioritario = scanner.nextLine();

		if (isPosicaoInvalida(posicaoAgenda, 100)) {
			System.out.println("POSIÇÃO INVÁLIDA");
		} else {
			boolean modificado = agenda.setTelefonePrioritario(posicaoAgenda, novoNumPrioritario);
			if (modificado) {
				System.out.println("TELEFONE PRIORITÁRIO MODIFCADO!");
			} else {
				System.out.println("CONTATO NÃO CADASTRADO");
			}
		}
	}

	/**
	 * Remove um contato da agenda telefônica. A remoção
	 * do contato implica na retirada do mesmo da agenda
	 * e da lista de favoritos, caso seja um contato favorito.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações sobre o contato.
	 */
	private static void removerContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nRemover contato da lista de (F)avoritos ou da (A)genda: ");
		String decisao = scanner.next().toUpperCase();

		if (decisao.equals("F")) {
			System.out.print("\nPosição em favoritos: ");
			int posicaoFavoritos = scanner.nextInt();

			if (isPosicaoInvalida(posicaoFavoritos, 10)) {
				System.out.println("POSIÇÃO INVÁLIDA");
			}
			
			boolean remocao = agenda.removeContatoFavorito(posicaoFavoritos);

			if (remocao) {
				System.out.println("CONTATO REMOVIDO DOS FAVORITOS!");
			} else {
				System.out.println("CONTATO NÃO CADASTRADO EM FAVORITOS");
			}

		} else if (decisao.equals("A")) {
			System.out.print("\nPosição na agenda: ");
			int posicaoAgenda = scanner.nextInt();

			if (isPosicaoInvalida(posicaoAgenda, 100)) {
				System.out.println("POSIÇÃO INVÁLIDA");
			} 

			boolean remocao = agenda.removeContatoAgenda(posicaoAgenda);

			if (remocao) {
				System.out.println("CONTATO REMOVIDO DA AGENDA!");
			} else {
				System.out.println("CONTATO NÃO CADASTRADO NA AGENDA");
			}
		} else {
			System.out.println("OPÇÃO INVÁLIDA");
		}
	}

	/**
	 * Realiza uma busca a partir do nome ou sobrenome de um contato
	 * e exibe os contatos que possuem esse nome ou sobrenome.
	 * @param agenda
	 * @param scanner
	 */
	private static void pesquisarContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nNome ou sobrenome do contato a ser pesquisado: ");
		String nome = scanner.next();
		System.out.println();
		agenda.pesquisarContato(nome);
	}

	/**
	 * Checa se a posição do contato é existente
	 * ou não na agenda.
	 * 
	 * @posicao A posição do contato na lista de contatos.
	 * @maiorPosicao A maior posição que um contato pode ter na lista de contatos.
	 * @return true se a posição for válida, false caso contrário.
	 */
	private static boolean isPosicaoInvalida(int posicao, int maiorPosicao) {
        return posicao < 1 || posicao > maiorPosicao;
    }

}
