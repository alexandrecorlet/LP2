package lab2;

import java.util.Arrays;

/**
 * Representa uma disciplina cursada pelo aluno. Toda disciplina
 * possui quatro notas por padrão.  Permite saber se um aluno foi 
 * aprovado em uma disciplina, quais foram as suas notas na disciplina, 
 * e o total de horas estudadas.
 * 
 * @author Alexandre Santos
 */
public class Disciplina {

    /**
     * Nome da disciplina cursada pelo aluno.
     */
    private String nomeDisciplina;

    /**
     * Notas do aluno na disciplina.
     */
    private double[] notas;

    /**
     * Quantidade de notas que a disciplina possui. Por padrão,
     * as disciplinas possuem 4 notas.
     */
    private int quantidadeNotas;

    /**
     * Pesos de cada uma das notas da disciplina.
     */
    private int[] pesosNotas;

    /**
    * Total de horas estudadas pelo aluno na disciplina.
    */
    private int horasEstudadas;

    /**
     * Constrói uma disciplina a partir de seu nome. 
     * 
     * @param nomeDisciplina o nome da disciplina
     */
     public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.quantidadeNotas = 4;
        this.notas = new double[quantidadeNotas];
        this.pesosNotas = new int[quantidadeNotas];
        Arrays.fill(this.pesosNotas, 1);
    }

    /**
     * Constrói uma disciplina a partir de seu nome e
     * da sua quantidade de notas
     * 
     * @param nomeDisciplina o nome da disciplina
     * @param quantidadeNotas a quantidade de notas da disciplina
     */
    public Disciplina(String nomeDisciplina, int quantidadeNotas) {
        if (quantidadeNotas < 0) {
            throw new IllegalArgumentException("Quantidade de notas invalida");
        }
        this.nomeDisciplina = nomeDisciplina;
        this.quantidadeNotas = quantidadeNotas;
        this.notas = new double[quantidadeNotas];
        this.pesosNotas = new int[quantidadeNotas];
        Arrays.fill(this.pesosNotas, 1);
    }

    /**
     * Constrói uma disciplina a partir de seu nome,
     * da sua quantidade de notas e do peso de cada
     * uma das notas.
     * 
     * @param nomeDisciplina o nome da disciplina
     * @param quantidadeNotas a quantidade de notas da disciplina
     * @param pesosNotas o peso de cada uma das notas
     */
    public Disciplina(String nomeDisciplina, int quantidadeNotas, int[] pesosNotas) {
        if (quantidadeNotas < 0) {
            throw new IllegalArgumentException("Quantidade de notas invalida");
        }
        this.nomeDisciplina = nomeDisciplina;
        this.quantidadeNotas = quantidadeNotas;
        this.notas = new double[quantidadeNotas];
        this.pesosNotas = pesosNotas;
    }
    /**
     * Incrementa o total de horas estudadas pelo aluno
     * 
     * @param horas horas estudadas pelo aluno que serão incrementadas no total
     */
    public void cadastraHoras(int horas) {
        if (horas < 0) {
            throw new IllegalArgumentException("Valor invalido para horas.");
        }
        this.horasEstudadas += horas;
    }

    /**
     * Cadastra o valor de uma nota do aluno. Caso uma nota
     * seja cadastrada mais de uma vez, apenas a última será
     * considerada.
     * 
     * @param nota nota a ser cadastrada
     * @param valorNota valor da nota a ser cadastrada
     */
    public void cadastraNota(int nota, double valorNota) {
        if (valorNota < 0) {
            throw new IllegalArgumentException("Valor da nota invalida.");
        }
        this.notas[nota-1] = valorNota;
    }

    /**
     * Calcula a média das notas 
     * do aluno na disciplina.
     * 
     * @return o resultado da média das notas do aluno.
     */
    public double calculaMedia() {
        double somaNotas = 0;
        int somaPesos = 0;
        for (int i = 0; i < this.quantidadeNotas; i++) {
            somaNotas += notas[i] * pesosNotas[i];
            somaPesos += pesosNotas[i];
        }

        double media = somaNotas / somaPesos;

        return media;
    }

    /**
     * Verifica se o aluno foi aprovado na disciplina em questão.
     * Para um aluno estar aprovado em na disciplina, é necessário
     * que sua média seja maior ou igual a 7.0.
     * 
     * @return true se aluno está aprovado, caso contrário false
     */
    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    /**
     * Imprime as notas do usuário num formato mais legível.
     * 
     * @param notas é as notas do aluno na disciplina.
     * @return representação das notas do aluno em um formato mais legível.
     */
    private String imprimeNotas() {
        return Arrays.toString(notas);
    }

    /**
     * Retorna String representando o desempenho do aluno na disciplina cursada.
     * O formato da representação é "DISCIPLINA HorasdeEstudo MEDIA NOTAS".
     * 
     * @return representação em string do desempenho do aluno na disciplina cursada.
     */
    public String toString() {
        return nomeDisciplina + " " + horasEstudadas + " " + calculaMedia() + " " + imprimeNotas();
    }
    
}
