package agenda;

/**
 * Representação de um contato. Todo contato
 * possui um nome, sobrenome e até três tele-
 * fones. A identificação de um contato é
 * feita através de seu nome e sobrenome.
 * 
 * @author Alexandre Santos
 */
public class Contato {

    /**
     * O nome do contato.
     */
    private String nome;

    /**
     * O sobrenome do contato.
     */
    private String sobrenome;

    /**
     * O telefone prioritário do contato.
     */
    private String numPrioritario;

    /**
     * O telefone whatsapp do contato.
     */
    private String numWhatsapp;

    /**
     * O telefone adicional do contato.
     */
    private String numAdicional;

    /**
     * Impede entradas inválidas do usuário.
     */
    private void entradasInvalidas() {
        if (this.nome == null) {
            throw new NullPointerException("Nome nulo");
        } else if (this.sobrenome == null) {
            throw new NullPointerException("Sobrenome nulo");
        } else if (this.numPrioritario == null) {
            throw new NullPointerException("Telefone prioritário nulo");
        } else if (this.numWhatsapp == null) {
            throw new NullPointerException("Telefone whatsapp nulo");
        } else if (this.numAdicional == null) {
            throw new NullPointerException("Telefone adicional nulo");
        }

        if (this.nome.isBlank() || this.nome.equals("\"\"")) {
            throw new IllegalArgumentException("Nome inválido");
        } else if (this.sobrenome.isBlank() || this.sobrenome.equals("\"\"")) {
            throw new IllegalArgumentException("Sobrenome inválido");
        }
    }

    /**
     * Constrói um contato a partir de seu nome, sobrenome,
     * telefone principal, telefone whatsapp e de um telefone
     * adicional.
     * 
     * @nome O nome do contato.
     * @sobrenome O sobrenome do contato.
     * @principal O telefone principal do contato.
     * @whatsapp O telefone whatsapp do contato.
     * @adicional O telefone adicional do contato.
     */
    public Contato(String nome, String sobrenome, String numPrioritario, 
                    String numWhatsapp, String numAdicional) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numPrioritario = numPrioritario;
        this.numWhatsapp = numWhatsapp;
        this.numAdicional = numAdicional;
        entradasInvalidas();
    }


    /**
     * Retorna o nome completo do contato
     * 
     * @return O nome completo do contato.
     */
    public String getNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }

    /**
     * Verifica se dois contatos são iguais. Dois contatos
     * são iguais se o nomes e sobrenomes são iguais.
     * 
     * @obj O objeto no qual será feita a checagem.
     * @return true se os Contatos são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else if (obj == this) {
            return true;
        } 
        Contato contato = (Contato) obj;
        return this.getNomeCompleto().equals(contato.getNomeCompleto());
    }

    /**
     * Retorna os telefones do contato
     * para exibição.
     * 
     * @return Os telefones do contato.
     */
    private String getTelefones() {
        String telefones = "";
        if (!(this.numPrioritario.isBlank() || this.numPrioritario.equals("\"\""))) {
            telefones += this.numPrioritario + " (Prioritário)\n"; 
        }

        if (!(this.numWhatsapp.isBlank() || this.numWhatsapp.equals("\"\""))) {
            telefones += this.numWhatsapp + " (Whatsapp)\n";
        }

        if (!(this.numAdicional.isBlank() || this.numAdicional.equals("\"\""))) {
            telefones += this.numAdicional + " (Adicional)\n";
        }

        return telefones;
    }

    /**
     * Retorna a String que representa o contato
     * 
     * @return representação em String do contato.
     */
    @Override
    public String toString() {
        return this.getNomeCompleto() + "\n" + this.getTelefones();
    }

    /**
     * Edita o telefone prioritário de um contato.
     * @param novoNumPrioritario o novo número do telefone prioritário.
     */
    public void setTelefonePrioritario(String novoNumPrioritario) {
        entradasInvalidas();
        this.numPrioritario = novoNumPrioritario;
    }

}
