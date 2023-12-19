package alunos;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Objects;

/**
 * Representação do grupo de discentes. Um grupo
 * possui um nome e ou pode ter restrição de curso ou
 * não. Caso haja restrição, apenas discentes que cursam
 * o curso do grupo podem fazer parte do grupo.
 *
 * @author Alexandre B. Corlet dos Santos
 *
 */
public class Grupo {

    /**
     * O nome do grupo.
     */
    private final String nome;

    /**
     * Restrição de curso do grupo. (OPCIONAL)
     */
    private final String restricao;

    /**
     * Alunos que participam do grupo.
     */
    private HashSet<Aluno> alunos;

    /**
     * Constrói um grupo de estudos com restrição de curso
     * a partir de seu nome e o curso necessário para entrar
     * no grupo.
     *
     * @param nome
     * @param restricao
     */
    public Grupo(String nome, String restricao) {
        if (restricao == null)
            throw new InputMismatchException("RESTRIÇÃO INVÁLIDA");
        if (nome == null)
            throw new InputMismatchException("NOME INVÁLIDO");
        if (nome.isBlank())
            throw new IllegalArgumentException("NOME INVÁLIDO");

        this.nome = nome;
        this.restricao = restricao;
        this.alunos = new HashSet<>();
    }

    /**
     * Aloca um aluno no grupo.
     * @param aluno O aluno a ser alocado.
     */
    public boolean alocarAluno(Aluno aluno) { return this.alunos.add(aluno); }

    /**
     * Retorna a restrição de entrada de um determinado grupo.
     * @return String que representa a restrição de entrada.
     */
    public String getRestricao() {
        return this.restricao;
    }

    /**
     * Verifica se um aluno é participante do grupo.
     * @param aluno
     * @return
     */
    public boolean isParticipante(Aluno aluno) { return this.alunos.contains(aluno); }

    /**
     * Verifica se dois grupos de estudos são iguais.
     *
     * @param obj O objeto que será feita a verificação.
     * @return true se os grupos forem os mesmos, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        else if (this == obj)
            return true;

        Grupo objGrupo = (Grupo) obj;
        return this.nome.equals(objGrupo.nome);
    }

    /**
     * Identificador numérico inteiro de um grupo.
     *
     * @return Número inteiro representando o hash do grupo.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

}
