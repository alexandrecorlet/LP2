

package alunos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Interface para o sistema de controles
 * de alunos.
 *
 * @author Alexandre B. Corlet dos Santos
 *
 */
public class MainAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaAlunos sistemaAlunos = new SistemaAlunos();
        while (true) {
            String opcao = menu(scanner);
            comando(scanner, opcao, sistemaAlunos);
        }
    }

    /**
     * Exibe o menu e captura o comando digitado
     * por quem estiver usando o programa.
     *
     * @param scanner Para ler os comandos digitados pelo(a) usuário(a).
     * @return String representando a opcão digitada pelo(a) usuário(a)
     */
    private static String menu(Scanner scanner) {
        System.out.print(
                "\n---\nMENU\n" +
                        "(C)adastrar Aluno\n" +
                        "(E)xibir Aluno\n" +
                        "(N)ovo Grupo\n" +
                        "(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" +
                        "(R)egistrar Aluno que Respondeu\n" +
                        "(I)mprimir Alunos que Responderam\n" +
                        "(O)xe, e a contagem dos grupos com restrição de curso?\n" +
                        "(S)im, quero fechar o programa!\n" +
                        "\nOpção> "
        );

        String opcao = scanner.next().toUpperCase().trim();
        scanner.nextLine();
        return opcao;
    }

    /**
     * Interpreta o comando do(a) usuário(a).
     *
     * @param opcao
     */
    private static void comando(Scanner scanner, String opcao, SistemaAlunos sistemaAlunos) {
        switch (opcao) {
            case "C":
                cadastrarAluno(scanner, sistemaAlunos);
                break;
            case "E":
                exibirAluno(scanner, sistemaAlunos);
                break;
            case "N":
                cadastrarGrupo(scanner, sistemaAlunos);
                break;
            case "A":
                System.out.print("(A)locar Aluno ou (P)ertinência a Grupo? ");
                String opcao2 = scanner.next().toUpperCase().trim();
                scanner.nextLine();
                switch (opcao2) {
                    case "A":
                        alocarAluno(scanner, sistemaAlunos);
                        break;
                    case "P":
                        pertenceGrupo(scanner, sistemaAlunos);
                        break;
                    default:
                        System.err.println("OPÇÃO INVÁLIDA");
                        System.err.flush();
                }
                break;
            case "R":
                registrarAluno(scanner, sistemaAlunos);
                break;
            case "I":
                imprimirAlunosRegistrados(sistemaAlunos);
                break;
            case "O":
                contabilizarRestricao(scanner, sistemaAlunos);
                break;
            case "S":
                sair();
            default:
                System.err.println("OPÇÃO INVÁLIDA!");
                System.err.flush();
        }
    }

    /**
     * Cadastra um novo aluno no sistema de alunos.
     * @param scanner Para capturar os dados do aluno.
     * @param sistemaAlunos O sistema de alunos.
     */
    private static void cadastrarAluno(Scanner scanner, SistemaAlunos sistemaAlunos) {
        System.out.print("Matrícula: ");
        String matricula = scanner.next().trim();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Curso: ");
        String curso = scanner.nextLine().trim();

        if (!sistemaAlunos.cadastrarAluno(nome, matricula, curso)) {
            System.err.println("MATRÍCULA JÁ CADASTRADA.");
            System.err.flush();
        } else {
            System.out.println("CADASTRO REALIZADO.");
        }
    }

    /**
     * Exibe os dados de um discente.
     *
     * @param scanner Para capturar a matrícula do aluno
     * @param sistemaAlunos O sistema de alunos.
     */
    private static void exibirAluno(Scanner scanner, SistemaAlunos sistemaAlunos) {
        System.out.print("Matrícula: ");
        String matricula = scanner.next().trim();
        scanner.nextLine();

        if (!sistemaAlunos.isAlunoCadastrado(matricula)) {
            System.err.println("\nMatrícula: " + matricula + "0");
            System.err.println("Aluno(a) não cadastrado(a).");
            System.err.flush();
        } else {
            System.out.println(sistemaAlunos.consultarAluno(matricula));
        }
    }

    /**
     * Cadastra um novo grupo de estudos no sistema de alunos.
     *
     * @param scanner Para capturar os dados relativos ao grupo que será criado.
     * @param sistemaAlunos O sistema de alunos.
     */
    private static void cadastrarGrupo(Scanner scanner, SistemaAlunos sistemaAlunos) {
        System.out.print("Nome: ");
        String nomeGrupo = scanner.nextLine().toUpperCase().trim();
        System.out.print("Restrição: ");
        String restricao = scanner.nextLine().trim();

        if (!sistemaAlunos.cadastrarGrupo(nomeGrupo, restricao)) {
            System.err.println("GRUPO JÁ CADASTRADO.");
            System.err.flush();
        } else {
            System.out.println("CADASTRO REALIZADO!");
        }
    }

    /**
     * Aloca um aluno no grupo de estudos.
     *
     * @param scanner Para capturar os dados do aluno e do grupo.
     * @param sistemaAlunos O sistema de alunos.
     */
    private static void alocarAluno(Scanner scanner, SistemaAlunos sistemaAlunos) {
        System.out.print("Matrícula: ");
        String matricula = scanner.next().trim();
        scanner.nextLine();
        System.out.print("Grupo: ");
        String nomeGrupo = scanner.nextLine().toUpperCase().trim();

        if (!sistemaAlunos.isAlunoCadastrado(matricula)) {
            System.err.println("ALUNO NÃO CADASTRADO.");
            System.err.flush();
        } else if (!sistemaAlunos.isGrupoCadastrado(nomeGrupo)) {
            System.err.println("GRUPO NÃO CADASTRADO.");
            System.err.flush();
        } else {
            if (sistemaAlunos.alocarAluno(matricula, nomeGrupo))
                System.out.println("ALUNO ALOCADO!");
            else
                System.out.println("GRUPO COM RESTRIÇÃO DE CURSO.");
        }
    }

    /**
     * Verifica se um aluno é participante do grupo de estudos.
     *
     * @param scanner Para capturar os dados do aluno e do grupo.
     * @param sistemaAlunos O sistema de alunos.
     */
    private static void pertenceGrupo(Scanner scanner, SistemaAlunos sistemaAlunos) {
        System.out.print("Grupo: ");
        String nomeGrupo = scanner.nextLine().toUpperCase().trim();
        System.out.print("Matrícula: ");
        String matricula = scanner.next().trim();
        scanner.nextLine();

        if (!sistemaAlunos.isAlunoCadastrado(matricula)) {
            System.err.println("ALUNO NÃO CADASTRADO.");
            System.err.flush();
        } else if (!sistemaAlunos.isGrupoCadastrado(nomeGrupo)) {
            System.err.println("GRUPO NÃO CADASTRADO.");
            System.err.flush();
        } else {
            if (sistemaAlunos.isParticipanteGrupo(nomeGrupo, matricula))
                System.out.println("ALUNO PERTENCE AO GRUPO.");
            else
                System.out.println("ALUNO NÃO PERTENCE AO GRUPO.");
        }
    }

    /**
     * Registra aluno que respondeu no quadro.
     *
     * @param scanner Para capturar dados do aluno.
     * @param sistemaAlunos O sistema de alunos.
     */
    private static void registrarAluno(Scanner scanner, SistemaAlunos sistemaAlunos) {
        System.out.print("Matrícula: ");
        String matricula = scanner.next().trim();
        scanner.nextLine();

        if (sistemaAlunos.registrarAluno(matricula)) {
            System.out.println("ALUNO REGISTRADO!");
        } else {
            System.err.println("ALUNO NÃO CADASTRADO.");
            System.err.flush();
        }
    }

    /**
     * Imprime os alunos registrados que responderam
     * questões no quadro.
     *
     * @param sistemaAlunos O sistema de alunos.
     */
    private static void imprimirAlunosRegistrados(SistemaAlunos sistemaAlunos) {
        ArrayList<Aluno> alunosRegistrados = sistemaAlunos.getAlunosRegistrados();
        System.out.println("Alunos: ");
        for (int i = 0; i < alunosRegistrados.size(); ++i)
            System.out.println(i+1 + ". " + alunosRegistrados.get(i).toString());
    }

    /**
     * Imprime a quantidade de grupos que possuem
     * um dado curso como restrição.
     *
     * @param scanner Para capturar o curso.
     * @param sistemaAlunos O sistema de alunos.
     */
    private static void contabilizarRestricao(Scanner scanner, SistemaAlunos sistemaAlunos) {
        System.out.print("Curso: ");
        String curso = scanner.nextLine().trim();
        System.out.println(curso + " " + sistemaAlunos.contabilizarRestricao(curso));
    }

    /**
     * Encerra a execução do programa.
     */
    private static void sair() {
        System.out.println("VLW! TMJ! :)");
        System.exit(0);
    }
}
