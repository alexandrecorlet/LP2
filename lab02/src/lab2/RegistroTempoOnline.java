package lab2;

/**
 * Representa o registro de tempo online de cada disciplina
 * que o aluno está matriculado. É responsável por gerir as 
 * informações relacionadas a quantidade de horas que um alu-
 * no tem dedicado a uma disciplina.
 * 
 * @author Alexandre Santos
 */
public class RegistroTempoOnline  {

    /**
     * Nome da disciplina que será gerenciada. 
     * No formato "NOMEDISCIPLINA".
     */
    private String disciplina;
    
    /**
     * Tempo online esperado para conclusão da disciplina. 
     * Está no formato horas.
     */
    private int tempoOnlineEsperado;

    /**
     * Tempo online dedicado pelo aluno a disciplina. 
     * Está no formato horas.
     */
    private int tempoOnlineDedicado;

    /**
     * Constrói um registro de tempo online para uma disciplina a partir de seu nome.
     * Por padrão, toda disciplina tem 120h de tempo online esperado.
     * 
     * @param disciplina o nome da disciplina que será gerenciada pelo registro online
     */
    public RegistroTempoOnline(String disciplina) {
        this.disciplina = disciplina;
        this.tempoOnlineEsperado = 120;
    }

    /**
     * Constrói um registro de tempo online para uma disciplina a partir de seu nome e 
     * tempo online esperado para concluí-la. 
     * 
     * @param disciplina o nome da disciplina que será gerenciada pelo registro online
     * @param tempoOnlineEsperado o tempo online esperado para concluir a disciplina
     */
    public RegistroTempoOnline(String disciplina, int tempoOnlineEsperado) {
        if (tempoOnlineEsperado < 0) {
            throw new IllegalArgumentException("Valor inválido para tempo online esperado. Digite um valor maior ou igual a zero.");
        }
        this.disciplina = disciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Soma as horas de estudos do aluno ao tempo dedicado na disciplina. 
     * 
     * @param tempo a quantidade de horas estudadas pelo aluno que será somada a disciplina
     */
    public void adicionaTempoOnline(int tempo) {
        if (tempo < 0) {
            throw new IllegalArgumentException("Valor inválido para tempo. Digite um valor maior ou igual a zero.");
        }
        this.tempoOnlineDedicado += tempo;
    }

    /**
     * Verifica se o aluno atingiu a meta de tempo online esperado da disciplina.
     * 
     * @return true se aluno atingiu a meta, caso contrário retorna false.
     */
    public boolean atingiuMetaTempoOnline() {
        return tempoOnlineDedicado >= tempoOnlineEsperado;
    }

    /**
     * String que representa o registro de tempo online da disciplina
     * no formato "DISCIPLINA TEMPOONLINEDEDICADO/TEMPOONLINEESPERADO".
     * 
     * @return representação do registro de tempo online da disciplina.
     */
    public String toString() {
        return disciplina + " " + tempoOnlineDedicado + "/" + tempoOnlineEsperado;
    }

}
