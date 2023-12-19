package lab2;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Representa o registro de finanças do discente. Permite o aluno
 * gerir seus gastos e sua receita durante o curso. Os gastos e a
 * receita do aluno estão em centavos.
 * 
 * @author Alexandre Santos
 */
public class RegistroFinanca {

    /**
     * Total da receita (em centavos) do aluno
     */
    private int receitaTotal;

    /**
     * Total de despesas (em centavos) do aluno
     */
    private int despesasTotais;

    /**
     * Armazena detalhes sobre os últimos 5 gastos
     * do aluno.
     */
    private Deque<String> detalheGastos = new ArrayDeque<String>();

    /**
     * Fontes de renda do aluno. Podem ser
     * divididas em 4 tipos: 
     * 
     * 1 - família;
     * 2 - projetos institucionais com bolsa;
     * 3 - auxílio institucional; e
     * 4 - doações externas.
     * 
     * O somatório dessas fontes compõem a receita total do discente.
     */
    private int[] fontesRenda = new int[4];

    /**
     * Constrói um registro de finanças a fim de
     * permitir maior eficiência e facilidade no
     * gerenciamento dos gastos do discente durante
     * o curso.
     * 
     * @param receitaInicial a receita inicial do discente. É considerada de fonte de renda familiar.
     */
    public RegistroFinanca(int receitaInicial) {
        this.receitaTotal = receitaInicial;
        this.fontesRenda[0] = receitaInicial;
    }

    /**
     * Aumenta a receita do aluno graças a ganhos pecuniários de
     * uma determinada fonte de renda.
     * 
     * @param tipoFonte a fonte que acarretou no ganho da renda
     * @param valorCentavos o valor ganho da fonte renda
     */
    public void aumentaReceita(int tipoFonte, int valorCentavos) {
        if (valorCentavos < 0) {
            throw new IllegalArgumentException("Valor de centavos invalido.");
        } else if (tipoFonte < 0 || tipoFonte > 4) {
            throw new IllegalArgumentException("Tipo fonte de renda invalido.");
        }
        this.fontesRenda[tipoFonte-1] += valorCentavos;
        this.receitaTotal += valorCentavos;
    }

    /**
     * Pagamento de alguma despesa do aluno
     * 
     * @param valorCentavos o valor gasto para pagar a despesa
     */
    public void pagaDespesa(int valorCentavos) {
        if (valorCentavos < 0) {
            throw new IllegalArgumentException("Valor de centavos invalido.");
        }
        this.despesasTotais += valorCentavos;
    }

    /**
     * Paga alguma despesa do aluno e permite registrar 
     * um detalhe sobre o que foi pago.
     * 
     * OBS: A operação de registrar detalhes sobre pagamentos,
     * por padrão, só registra os último 5 detalhes de pagamentos. 
     * Caso um novo detalhe de pagamento seja registrado, o mais antigo
     * dos 5 detalhes de pagamento é descartado a fim de que o novo
     * seja registrado.
     * 
     * @param valorCentavos o valor gasto para pagar a despesa
     * @param detalhes as informações sobre o que foi pago
     */
    public void pagaDespesa(int valorCentavos, String detalhes) {
        if (valorCentavos < 0) {
            throw new IllegalArgumentException("Valor de centavos invalido.");
        }
        this.despesasTotais += valorCentavos;
        this.detalheGastos.addLast(valorCentavos + "centavos gastos - " + detalhes);

        // Verifica quantos pagamentos foram registrados
        if (this.detalheGastos.size() > 5) {
            this.detalheGastos.removeFirst();
        }
    }

    /**
     * Retorna uma String que lista o detalhe
     * dos últimos 5 pagamentos feitos.
     * 
     * @return listagem com detalhes dos últimos 5 pagamentos feitos.
     */
    public String listarDetalhes() {
        String detalhePagamentos = "";
        for (String detalhe: detalheGastos) {
            detalhePagamentos += detalhe + "\n";
        }
        return detalhePagamentos.trim();
    }

    /**
     * Retorna uma String que exibe quanto cada fonte
     * de renda possui de receita.
     * 
     * @return exibição de quanto cada fonte de renda possui.
     */
    public String exibeFontes() {
        String fontes = "";
        for (int i = 0; i < 4; i++) {
            if (i < 3) {
                fontes += (i+1) + " - " + fontesRenda[i] + "\n";
            } else {
                fontes += (i+1) + " - " + fontesRenda[i];
            }
        }
        return fontes;
    }

    /**
     * retorna String que representa o registro de finanças.
     * O formato utilizado é:
     * 
     * "Receita total: RECEITATOTAL, Receita atual: RECEITAATUAL, Despesas totais: DESPESASTOTAIS"
     * 
     * @return a representação String do registro de finanças.
     */
    public String toString() {
        return "Receita total: " + receitaTotal 
                + ", Receita atual: " + (receitaTotal - despesasTotais) 
                + ", Despesas totais: " + despesasTotais; 
    }

}
