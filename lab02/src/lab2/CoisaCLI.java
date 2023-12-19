package lab2;

import java.util.Scanner;
import java.util.HashMap;

/**
 * Interface de linha de comando do COISA. Através dessa interface,
 * os usuários podem digitar alguns comandos para realizar certas
 * operações mais rapidamente.
 * 
 * @author Alexandre Santos
 */
public class CoisaCLI {
    
    /**
     * Exibe o menu de operações disponíveis
     */
    public static void menu() {
        System.out.println("MENU");
        System.out.println("Cadastro aluno: ALUNO NOMEALUNO NASCIMENTO MATRICULA");
        System.out.println("Cadastrar aluno disciplina: DISCIPLINA NOMEDISCIPLINA NOMEALUNO");
        System.out.println("Cadastrar nota na disciplina: CADASTRANOTA NOMEDISCIPLINA NOTA VALORNOTA NOMEALUNO");
        System.out.println("Cadastrar tempo de estudo: CADASTRATEMPO NOMEDISCIPLINA TEMPO NOMEALUNO");
        System.out.println("Status do aluno na disciplina: STATUSDISCIPLINA NOMEDISCIPLINA NOMEALUNO");
        System.out.println("Relatório do aluno disciplina: RELATORIODISCIPLINA NOMEDISCIPLINA NOMEALUNO");
        System.out.println("Registro de tempo online: REGISTROTEMPOONLINE NOMEDISCIPLINA NOMEALUNO");
        System.out.println("Adicionar tempo online: ADICIONATEMPOONLINE NOMEDISCIPLINA TEMPO NOMEALUNO");
        System.out.println("Meta de tempo online disciplina: ATINGIUMETA NOMEDISCIPLINA NOMEALUNO");
        System.out.println("Verifica tempo online disciplina: TEMPOONLINE NOMEDISCIPLINA NOMEALUNO");
        System.out.println("Saude fisica aluno: SAUDEFISICA NOMEALUNO STATUS");
        System.out.println("Saude mental aluno: SAUDEMENTAL NOMEALUNO STATUS");
        System.out.println("Status geral aluno: SAUDEGERAL NOMEALUNO");
        System.out.println("Registro financas aluno: REGISTROFINANCA RECEITAINICIAL NOMEALUNO");
        System.out.println("Aumenta receita aluno: AUMENTARECEITA TIPOFONTE VALORCENTAVOS NOMEALUNO");
        System.out.println("Pagar despesa aluno: PAGAMENTO VALORCENTAVOS NOMEALUNO");
        System.out.println("Exibe fontes de renda aluno: EXIBEFONTES NOMEALUNO");
        System.out.println("Relatorio registro de financa: RELATORIOFINANCA NOMEALUNO");
        System.out.println("Idade do aluno: IDADE NOMEALUNO");
        System.out.println("Dados do aluno: DADOSALUNO NOMEALUNO");
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, Aluno> alunos = new HashMap<String, Aluno>();

        System.out.print("> ");
        String comando = scan.nextLine().toUpperCase();
        while (!(comando.isEmpty())) {
        
            // Quebra o comando em um array de operacoes a serem feitas
            String[] operacao = comando.split(" ");

            if (operacao[0].equals("ALUNO")) {
                // permite criar um aluno
                String nomeAluno = operacao[1];
                int anoNasicmento = Integer.parseInt(operacao[2]);
                String matricula = operacao[3];
                Aluno aluno = new Aluno(nomeAluno, anoNasicmento, matricula);
                alunos.put(nomeAluno, aluno);
            } else if (operacao[0].equals("DISCIPLINA")) {
                // cadastra o aluno em uma determinada disciplina
                String nomeDisciplina = operacao[1];
                String nomeAluno = operacao[2];
                alunos.get(nomeAluno).cadastraDisciplina(nomeDisciplina);
            } else if (operacao[0].equals("CADASTRANOTA")) {
                // cadastra a nota de um aluno em uma determinada disciplina
                String nomeDisciplina = operacao[1];
                String nomeAluno = operacao[2];
                int nota = Integer.parseInt(operacao[3]);
                double valorNota = Double.parseDouble(operacao[4]);
                alunos.get(nomeAluno).cadastraNota(nomeDisciplina, nota, valorNota);
            } else if (operacao[0].equals("CADASTRATEMPO")) {
                // cadastra tempo estudado em uma determinada disciplina
                String nomeDisciplina = operacao[1];
                int tempo = Integer.parseInt(operacao[2]);
                String nomeAluno = operacao[3];
                alunos.get(nomeAluno).cadastraHoras(nomeDisciplina, tempo);
            } else if (operacao[0].equals("STATUSDISCIPLINA")) {
                // verifica se aluno foi aprovado
                String nomeDisciplina = operacao[1];
                String nomeAluno = operacao[2];
                boolean ehAprovado = alunos.get(nomeAluno).aprovado(nomeDisciplina);
                if (ehAprovado) {
                    System.out.println("ALUNO APROVADO!");
                } else {
                    System.out.println("ALUNO NAO FOI APROVADO AINDA!");
                }
            } else if (operacao[0].equals("RELATORIODISCIPLINA")) {
                // relatorio de como um aluno esta na disciplina
                String nomeDisciplina = operacao[1];
                String nomeAluno = operacao[2];
                System.out.println(alunos.get(nomeAluno).disciplinaToString(nomeDisciplina));
            } else if (operacao[0].equals("REGISTRATEMPOONLINE")) {
                // cria gerenciador de tempo pro aluno em uma determinada disciplina
                String nomeDisciplina = operacao[1];
                String nomeAluno = operacao[2];
                alunos.get(nomeAluno).registroTempoOnline(nomeDisciplina);
            } else if (operacao[0].equals("ADICIONATEMPOONLINE")) {
                // adiciona tempo de estudo
                String nomeDisciplina = operacao[1];
                int tempo = Integer.parseInt(operacao[2]);
                String nomeAluno = operacao[3];
                alunos.get(nomeAluno).adicionaTempoOnline(nomeDisciplina, tempo);
            } else if (operacao[0].equals("ATINGIUMETA")) {
                // verifica se o aluno atingiu a meta de tempo online
                String nomeDisciplina = operacao[1];
                String nomeAluno = operacao[2];
                boolean metaAtingida = alunos.get(nomeAluno).atingiuMetaOnline(nomeDisciplina);
                if (metaAtingida) {
                    System.out.println(nomeAluno + " atingiu a meta da disciplina!");
                } else {
                    System.out.println(nomeAluno + " nao atingiu a meta da disciplina. :(");
                }
            } else if (operacao[0].equals("TEMPOONLINE")) {
                // retorna relatorio do registro de tempo online da disciplina
                String nomeDisciplina = operacao[1];
                String nomeAluno = operacao[2];
                System.out.println(alunos.get(nomeAluno).registroOnlineToString(nomeDisciplina));
            } else if (operacao[0].equals("SAUDEFISICA")) {
                // define saude fisica do aluno
                String nomeAluno = operacao[1];
                String saudeFisica = operacao[2].toLowerCase();
                alunos.get(nomeAluno).defineSaudeFisica(saudeFisica);
            } else if (operacao[0].equals("SAUDEMENTAL")) {
                // define saude mental do aluno
                String nomeAluno = operacao[1];
                String saudeMental = operacao[2].toLowerCase();
                alunos.get(nomeAluno).defineSaudeMental(saudeMental);
            } else if (operacao[0].equals("SAUDEGERAL")) {
                // relatorio saude geral do aluno
                String nomeAluno = operacao[1];
                System.out.println(alunos.get(nomeAluno).getStatusGeral());
            } else if (operacao[0].equals("REGISTROFINANCA")) {
                // cria registro de financas para o aluno
                int receitaInicial = Integer.parseInt(operacao[1]);
                String nomeAluno = operacao[2];
                alunos.get(nomeAluno).cadastraFinancas(receitaInicial);
            } else if (operacao[0].equals("AUMENTARECEITA")) {
                // aumenta receita do aluno
                int tipoFonte = Integer.parseInt(operacao[1]);
                int valorCentavos = Integer.parseInt(operacao[2]);
                String nomeAluno = operacao[3];
                alunos.get(nomeAluno).aumentaReceita(tipoFonte, valorCentavos);
            } else if (operacao[0].equals("PAGAMENTO")) {
                // paga despesa do aluno
                int valorCentavos = Integer.parseInt(operacao[1]);
                String nomeAluno = operacao[2];
                alunos.get(nomeAluno).pagaDespesa(valorCentavos);
            } else if (operacao[0].equals("EXIBEFONTES")) {
                // exibe atual situacao das fontes de renda do aluno
                String nomeAluno = operacao[1];
                System.out.println(alunos.get(nomeAluno).exibeFontes());
            } else if (operacao[0].equals("RELATORIOFINANCA")) {
                // relatorio do registro financeiro do aluno
                String nomeAluno = operacao[1];
                System.out.println(alunos.get(nomeAluno).financasToString());
            } else if (operacao[0].equals("IDADE")) {
                // calcula idade do aluno
                String nomeAluno = operacao[1];
                System.out.println(alunos.get(nomeAluno).getIdade());
            } else if (operacao[0].equals("DADOSALUNO")) {
                // representacao String do aluno
                String nomeAluno = operacao[1];
                System.out.println(alunos.get(nomeAluno).toString());
            } else if (operacao[0].equals("MENU")) {
                // exibe menu de operacoes
                menu();
            }else {
                System.out.println("COMANDO INVALIDO!");
            }

            System.out.print("> ");
            comando = scan.nextLine().toUpperCase();
         }
    }
}
