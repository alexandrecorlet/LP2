package alunos;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Responsável por gerir os alunos,
 * cursos os alunos que estão
 * cadastrado no sistema de alunos.
 *
 * @author Alexandre B. Corlet dos Santos
 *
 */
public class SistemaAlunos {

    /**
     * Alunos cadastrados no sistema.
     */
    private HashMap<String, Aluno> alunos;

    /**
     * Grupos de estudos cadastrados no sistema.
     */
    private HashMap<String, Grupo> grupos;

    /**
     * Alunos que responderam questões no quadro.
     */
    private ArrayList<Aluno> alunosRegistrados;


    /**
     * Constrói um sistema de alunos
     */
    public SistemaAlunos() {
        this.alunos = new HashMap<>();
        this.grupos = new HashMap<>();
        this.alunosRegistrados = new ArrayList<>();
    }

    /**
     * Cadastra um aluno no sistema de alunos
     * a partir de sua matrícula, nome e curso.
     * Caso o aluno já esteja cadastrado, o
     * cadastro não é efetuado.
     *
     * @param nomeAluno O nome do aluno.
     * @param matricula A matrícula do aluno.
     * @param curso O curso do aluno.
     * @return true se o aluno tiver sido cadastrado com sucesso, false caso contrário.
     */
    public boolean cadastrarAluno(String nomeAluno, String matricula, String curso) {
        if (isAlunoCadastrado(matricula))
            return false;
        alunos.put(matricula, new Aluno(nomeAluno, matricula, curso));
        return true;
    }

    /**
     * Exibe os dados de um aluno
     * cadastrado no sistema.
     *
     * @param matricula A matrícula do aluno a ser exibido.
     * @return String com os dados do aluno.
     */
    public String consultarAluno(String matricula) {
        if (matricula == null)
            throw new InputMismatchException("MATRÍCULA INVÁLIDA");
        if (matricula.isBlank())
            throw new IllegalArgumentException("MATRÍCULA INVÁLIDA");
        if (!isAlunoCadastrado(matricula))
            throw new IllegalArgumentException("ALUNO NÃO CADASTRADO");

        return this.alunos.get(matricula).toString();
    }

    /**
     * Verifica se um aluno já foi cadastrado
     * no sistema de alunos.
     *
     * @param matricula A matrícula do aluno.
     * @return true se tiver sido cadastrado, false caso contrário.
     */
    public boolean isAlunoCadastrado(String matricula) {
        if (matricula == null)
            throw new InputMismatchException("MATRÍCULA INVÁLIDA");
        if (matricula.isBlank())
            throw new IllegalArgumentException("MATRÍCULA INVÁLIDA");

        return this.alunos.containsKey(matricula);
    }

    /**
     * Cadastra um novo grupo de alunos.
     *
     * @param nomeGrupo O nome do grupo.
     * @param restricao A restrição para entrar no grupo.
     * @return true se grupo foi cadastrado com sucesso, false caso contrário.
     */
    public boolean cadastrarGrupo(String nomeGrupo, String restricao) {
        if (isGrupoCadastrado(nomeGrupo))
            return false;

        this.grupos.put(nomeGrupo, new Grupo(nomeGrupo, restricao));
        return true;
    }

    /**
     * Checa se um grupo que está prestes a ser cadastrado
     * já foi cadastrado.
     *
     * @param nomeGrupo O nome do grupo.
     * @return true se tiver sido cadastrado, false caso contrário.
     */
    public boolean isGrupoCadastrado(String nomeGrupo) {
        if (nomeGrupo == null)
            throw new InputMismatchException("NOME INVÁLIDO");
        if (nomeGrupo.isBlank())
            throw new IllegalArgumentException("NOME INVÁLIDO");

        return this.grupos.containsKey(nomeGrupo);
    }

    /**
     * Aloca aluno em um grupo de estudos
     *
     * @param matricula A matrícula do aluno.
     * @param nomeGrupo O nome do grupo que o aluno será alocado.
     * @return true se a alocação ocorrer, false caso contrário.
     */
    public boolean alocarAluno(String matricula, String nomeGrupo) {
        if (matricula == null)
            throw new InputMismatchException("MATRÍCULA INVÁLIDA");
        if (nomeGrupo == null)
            throw new InputMismatchException("NOME INVÁLIDO");
        if (nomeGrupo.isBlank())
            throw new IllegalArgumentException("NOME INVÁLIDO");
        if (matricula.isBlank())
            throw new IllegalArgumentException("MATRÍCULA INVÁLIDA");
        if (!isAlunoCadastrado(matricula))
            throw new IllegalArgumentException("ALUNO NÃO CADASTRADO");
        if (!isGrupoCadastrado(nomeGrupo))
            throw new IllegalArgumentException("GRUPO NÃO CADASTRADO");

        Aluno aluno = this.alunos.get(matricula);
        Grupo grupo = this.grupos.get(nomeGrupo);

        String restricao = grupo.getRestricao();
        String curso = aluno.getCurso();

        if (!(restricao.equals(curso) || restricao.isBlank()))
            return false;

       grupo.alocarAluno(aluno);
       return true;
    }

    /**
     * Verifica se um aluno é participante de um grupo de estudos.
     *
     * @param nomeGrupo O grupo de estudos.
     * @param matricula A matrícula do aluno.
     * @return true se aluno for participante, false caso contrário.
     */
    public boolean isParticipanteGrupo(String nomeGrupo, String matricula) {
        if (matricula == null)
            throw new InputMismatchException("MATRÍCULA INVÁLIDA");
        if (nomeGrupo == null)
            throw new InputMismatchException("NOME INVÁLIDO");
        if (matricula.isBlank())
            throw new IllegalArgumentException("MATRÍCULA INVÁLIDA");
        if (nomeGrupo.isBlank())
            throw new IllegalArgumentException("NOME INVÁLIDO");
        if (!isAlunoCadastrado(matricula))
            throw new IllegalArgumentException("ALUNO NÃO CADASTRADO");
        if (!isGrupoCadastrado(nomeGrupo))
            throw new IllegalArgumentException("GRUPO NÃO CADASTRADO");

        Aluno aluno = this.alunos.get(matricula);
        Grupo grupo = this.grupos.get(nomeGrupo);
        return grupo.isParticipante(aluno);
    }

    /**
     * Registra um aluno que respondeu uma questão no quadro.
     * @param matricula A matrícula do aluno.
     * @return true se aluno tiver sido registrado com sucesso, false caso contrário.
     */
    public boolean registrarAluno(String matricula) {
        if (matricula == null)
            throw new InputMismatchException("MATRÍCULA INVÁLIDA");
        if (matricula.isBlank())
            throw new IllegalArgumentException("MATRÍCULA INVÁLIDA");

        if (!isAlunoCadastrado(matricula))
            return false;

        Aluno aluno = this.alunos.get(matricula);
        return this.alunosRegistrados.add(aluno);
    }

    /**
     * Retorna uma cópia do ArrayList alunos registrados.
     * @return Cópia do ArrayList alunos registrados.
     */
    public ArrayList<Aluno> getAlunosRegistrados() { return (ArrayList<Aluno>) this.alunosRegistrados.clone(); }

    /**
     * Contabiliza quantos grupos possuem um dado
     * curso como restrição.
     * @return Número de cursos que possuem o curso como restrição
     */
    public int contabilizarRestricao(String curso) {
        if (curso == null)
            throw new InputMismatchException("CURSO INVÁLIDO");
        if (curso.isBlank())
            throw new IllegalArgumentException("CURSO INVÁLIDO");

        int cont = 0;
        for (Grupo g: this.grupos.values())
            // incrementa o contador caso restrição do
            // grupo seja igual ao curso.
            if (curso.equals(g.getRestricao()))
                cont++;

        return cont;
    }
}
