package lab2;

import java.util.HashMap;

/**
 * Representação de um aluno de 
 *
 * @author Alexandre B. Corlet dos Santos
 */
public class Aluno {

    /**
     * Student's name
     */
    private String nome;

    /**
     * Ano de nascimento do discente.
     */
    private int anoNasicmento;

    /**
     * Matrícula do discente. O formato utilizado
     * na matrícula do aluno é "2XXXYYZZZ", onde
     * XX é o ano e semestre de entrada, YY é o
     * código do curso e ZZ é um identificador do
     * aluno no curso.
     */
    private String matricula;

    /**
     * Mapeia o nome da disciplina para o
     * seu registro de tempo online.
     */
    private HashMap<String, RegistroTempoOnline> registrosTempos
            = new HashMap<String, RegistroTempoOnline>();

    /**
     * Mapeia o nome da disciplina para o
     * objeto do tipo Disciplina.
     */
    private HashMap<String, Disciplina> disciplinas = new HashMap<String, Disciplina>();

    /**
     * Registro de finanças do aluno durante o curso.
     */
    private RegistroFinanca financa;

    /**
     * Saúde do aluno
     */
    private Saude saude = new Saude();

    /**
     * Constrói um aluno a partir de seu nome, do seu ano de nascimento
     * e da sua matrícula.
     *
     * @param nome          o nome do aluno.
     * @param anoNasicmento o ano de nascimento do aluno.
     * @param matricula     o número da matrícula do aluno.
     */
    public Aluno(String nome, int anoNasicmento, String matricula) {
        this.nome = nome;
        this.anoNasicmento = anoNasicmento;
        this.matricula = matricula;
    }

    /**
     * Computa a idade do aluno.
     *
     * @return a idade do aluno.
     */
    public int getIdade() {
        return 2021 - this.anoNasicmento;
    }

    /**
     * Cria um registro de tempo online para uma disciplina
     * que o aluno está cursando a partir do nome da disciplina.
     *
     * @param nomeDisciplina o nome da disciplina
     */
    public void registroTempoOnline(String nomeDisciplina) {
        RegistroTempoOnline registroTempoDisciplina = new RegistroTempoOnline(nomeDisciplina);
        this.registrosTempos.put(nomeDisciplina, registroTempoDisciplina);
    }

    /**
     * Cria um registro de tmepo online para uma disciplina
     * que o aluno está cursando a partir do nome da disciplina
     * e do tempo online esperado para conclusão da disciplina.
     *
     * @param nomeDisciplina      o nome da disciplina.
     * @param tempoOnlineEsperado o tempo online esperado p/ concluí-la.
     */
    public void registroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        RegistroTempoOnline registroTempoDisciplina = new RegistroTempoOnline(nomeDisciplina, tempoOnlineEsperado);
        this.registrosTempos.put(nomeDisciplina, registroTempoDisciplina);
    }

    /**
     * Adiciona o tempo online que o aluno dedicou a disciplina.
     *
     * @param NomeDisciplina o nome da disciplina.
     * @param tempo          o tempo dedicado a ser adicionado.
     */
    public void adicionaTempoOnline(String nomeDisciplina, int tempo) {
        this.registrosTempos.get(nomeDisciplina).adicionaTempoOnline(tempo);
    }

    /**
     * Verifica se o aluno atingiu a meta de tempo online
     * de uma disciplina.
     *
     * @param nomeDisciplina o nome da disciplina a ser verificada
     * @return true caso tenha atingido, false caso contrário.
     */
    public boolean atingiuMetaOnline(String nomeDisciplina) {
        return this.registrosTempos.get(nomeDisciplina).atingiuMetaTempoOnline();
    }

    /**
     * Retorna representação em String de um registro
     * online de uma disciplina.
     *
     * @param nomeDisciplina o nome da disciplina.
     * @return a representação em String da disciplina.
     */
    public String registroOnlineToString(String nomeDisciplina) {
        return this.registrosTempos.get(nomeDisciplina).toString();
    }

    /**
     * Cadastra uma nova disciplina a ser cursada
     * pelo aluno.
     *
     * @param nomeDisciplina o nome da disciplina a ser cadastrada.
     */
    public void cadastraDisciplina(String nomeDisciplina) {
        Disciplina disciplina = new Disciplina(nomeDisciplina);
        this.disciplinas.put(nomeDisciplina, disciplina);
    }

    /**
     * Cadastra as horas de estudos do aluno
     * dedicadas a disciplina.
     *
     * @param NomeDisciplina o nome da disciplina.
     * @param horas          quantidade de horas a ser cadastradas.
     */
    public void cadastraHoras(String nomeDisciplina, int horas) {
        this.disciplinas.get(nomeDisciplina).cadastraHoras(horas);
    }

    /**
     * Cadastra uma nota do aluno na disciplina.
     *
     * @param nomeDisciplina o nome da disciplina.
     * @param nota           o identificador da nota a ser cadastrada.
     * @param valorNota      o valor da nota a ser cadastrada.
     */
    public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
        this.disciplinas.get(nomeDisciplina).cadastraNota(nota, valorNota);
    }

    /**
     * Verifica se o aluno foi aprovado na
     * disciplina que cursou.
     *
     * @param nomeDisciplina o nome da disciplina.
     * @return true se aluno foi aprovado, false caso contrário.
     */
    public boolean aprovado(String nomeDisciplina) {
        return this.disciplinas.get(nomeDisciplina).aprovado();
    }

    /**
     * Representação em String da disciplina cursada
     * pelo o aluno.
     *
     * @param nomeDisciplina o nome da disciplina
     * @return a representação em String da disciplina.
     */
    public String disciplinaToString(String nomeDisciplina) {
        return this.disciplinas.get(nomeDisciplina).toString();
    }

    /**
     * Inicia o registro financeiro do aluno
     * cadastrando sua receita inicial.
     *
     * @param receitaInicial a receita inicial do aluno.
     */
    public void cadastraFinancas(int receitaInicial) {
        this.financa = new RegistroFinanca(receitaInicial);
    }

    /**
     * Aumenta a receita do aluno adicionando
     * o ganho pecuniário proveniente de uma
     * fonte de renda.
     *
     * @param tipoFonte     o identificador da fonte de renda
     * @param valorCentavos o valor em centavos do ganho pecuniário
     */
    public void aumentaReceita(int tipoFonte, int valorCentavos) {
        this.financa.aumentaReceita(tipoFonte, valorCentavos);
    }

    /**
     * Paga uma despesa do aluno.
     *
     * @param valorCentavos o valor em centavos do pagamento
     */
    public void pagaDespesa(int valorCentavos) {
        this.financa.pagaDespesa(valorCentavos);
    }

    /**
     * Relatório das fontes de renda do aluno.
     * Permite o aluno visualizar qual o saldo
     * de cada fonte de renda.
     *
     * @return a String representando o relatório.
     */
    public String exibeFontes() {
        return this.financa.exibeFontes();
    }

    /**
     * Representação em String do registro
     * de finanças do aluno.
     *
     * @return a String que representa o registro de finanças.
     */
    public String financasToString() {
        return this.financa.toString();
    }

    /**
     * Atribui um valor para a saúde mental
     * do aluno.
     *
     * @param valor o valor da saúde mental
     */
    public void defineSaudeMental(String valor) {
        this.saude.defineSaudeMental(valor);
    }

    /**
     * Atribui um valor para a saúde física do
     * aluno.
     *
     * @param valor o valor da saúde física.
     */
    public void defineSaudeFisica(String valor) {
        this.saude.defineSaudeFisica(valor);
    }

    /**
     * Status da saúde geral do aluno.
     * Esse relatório é baseado na análise
     * da saúde mental e física do discente.
     *
     * @return o status da saúde geral do aluno.
     */
    public String getStatusGeral() {
        return this.saude.getStatusGeral();
    }

    /**
     * Retorna representação em String do aluno.
     * O formato utilizado é "Aluno - NOME MATRICULA"
     *
     * @return representação em String do aluno
     */
    public String toString() {
        return "Aluno - " + this.nome + " " + this.matricula;
    }

}
