package lab2;

/**
 * Representa a saúde do estudante. Permite acompanhar
 * sua saúde mental e física e, com base no acompanhamento,
 * classifica a saúde geral do estudante.
 * 
 * @author Alexandre Santos
 */
public class Saude {

    /**
     * O status atual da saúde mental do discente.
     */
    private String saudeMental;
    /**
     * O status atual da saúde física do discente.
     */
    private String saudeFisica;

    /**
     * Guarda um emoji que expressa o sentimento do discente
     * no momento, portanto, não tem relação com a saúde geral
     * do discente. 
     */
    private String emoji = "";

    /**
     * Constrói a saúde do discente considerando
     * sua saúde mental e física como boa.
     */
    public Saude() {
        this.saudeMental = "boa";
        this.saudeFisica = "boa";
    }

    /**
     * Permite o aluno atribuir um emoji para expressar
     * o sentimentos dele naquele momento.
     * 
     * @param emoji o emoji que expressa o sentimento do aluno
     */
    public void definirEmoji(String emoji) {
        this.emoji = emoji;
    }


    /**
     * Atribui um novo valor a saúde mental do discente. Caso
     * o usuário passe um argumento inválido (diferente de 
     * boa ou fraca), o programa lança uma exceção.
     * 
     * @param valor o novo valor da saúde mental do discente.
     */
    public void defineSaudeMental(String valor) {
        if (!(valor.equals("boa") || valor.equals("fraca"))) { // impede valores invalidos
            throw new IllegalArgumentException("Valor invalido para saude mental. Digite ou boa ou fraca");
        } else if (!(valor.equals(this.saudeMental))) {
            // Defini Emoji que expressa sentimento atual do aluno
            // como nada caso sua saude mental mude.
            definirEmoji("");
        }
        this.saudeMental = valor;
    }
    
    /**
     * Atribui um novo valor a saúde física do discente. Caso
     * o usuário passe um argumento inválido (diferente de 
     * boa ou fraca), o programa lança uma exceção.
     * 
     * @param valor o novo valor da saúde física do discente.
     */
    public void defineSaudeFisica(String valor) {
        if (!(valor.equals("boa") || valor.equals("fraca"))) { // impede valores invalidos
            throw new IllegalArgumentException("Valor invalido para saude fisica. Digite ou boa ou fraca");
        }  else if (!(valor.equals(this.saudeFisica))) {
            // Defini Emoji que expressa sentimento atual do aluno
            // como nada caso sua saude fisica mude.
            definirEmoji("");
        }
        this.saudeFisica = valor;
    }

    /**
     * Classifica a saúde geral do discente. A saúde geral
     * é classifica de acordo com os seguintes critêrios:
     * 
     * "boa" => saúde mental e física estão boas.
     * "ok" => ou saúde mental ou saúde física está boa.
     * "fraca" => saúde mental e física estão fraca.
     * 
     * @return String que representa o status geral da saúde do discente.
     */
    public String getStatusGeral() {
        if (this.saudeMental.equals("boa") && this.saudeFisica.equals("boa")) {
            return "boa" + " " + this.emoji;
        } else if (this.saudeMental.equals("fraca") && this.saudeFisica.equals("fraca")) {
            return "fraca" + " " + this.emoji;
        }
        return "ok" + " " + this.emoji;
    }

}
