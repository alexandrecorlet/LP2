package alunos;

import java.util.InputMismatchException;
import java.util.Objects;

/**
 * Representação de um aluno. O aluno é composto por
 * um nome, uma matrícula e um curso.
 *
 * @author Alexandre B. Corlet dos Santos.
 */
public class Aluno {

    /**
     * O nome do aluno.
     */
    private final String nome;

    /**
     * A matrícula do aluno.
     */
    private final String matricula;

    /**
     * O curso que o aluno cursa.
     */
    private final String curso;

    /**
     * Constrói um aluno a partir d seu nome,
     * sua matrícula e seu curso atual.
     *
     * @param nome O nome do aluno.
     * @param matricula A matrícula do aluno.
     * @param curso O curso que o aluno cursa.
     */
    public Aluno(String nome, String matricula, String curso) {
        if (nome == null)
            throw new InputMismatchException("NOME INVÁLIDO");
        if (matricula == null)
            throw new InputMismatchException("MATRÍCULA INVÁLIDA");
        if (curso == null)
            throw new InputMismatchException("CURSO INVÁLIDO");
        if (nome.isBlank())
            throw new IllegalArgumentException("NOME INVÁLIDO");
        if (matricula.isBlank())
            throw new IllegalArgumentException("MATRÍCULA INVÁLIDA");
        if (curso.isBlank())
            throw new IllegalArgumentException("CURSO INVÁLIDO");

        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    /**
     * Verifica se dois alunos são iguais. Dois
     * alunos são iguais caso tenham a matrícula
     * igual.
     *
     * @param obj O objeto a ser verificado se é igual.
     * @return true se os alunos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        if (this == obj)
            return true;

        Aluno objAluno = (Aluno) obj;
        return this.matricula.equals(objAluno.matricula);
    }

    /**
     * Retorna o curso que o aluno está cursando.
     *
     * @return String representando o curso do aluno.
     */
    public String getCurso() {
        return this.curso;
    }

    /**
     * Identificador numérico inteiro de um aluno.
     *
     * @return Número inteiro representando o hash do aluno.
     */
    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    /**
     * Representação textual de um aluno.
     * O formato utilizado é:
     *
     * "MATRICULA - NOME - CURSO"
     *
     * @return A representação textual de um aluno.
     */
    @Override
    public String toString() {
        return "Aluno: " + this.matricula + " - " + this.nome + " - " + this.curso;
    }
}
