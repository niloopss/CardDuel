/**
 * Enumeração que representa os naipes de um baralho de cartas.
 * Cada naipe possui um símbolo associado.
 *
 * @author Nivea Lins
 */
public enum Naipe {
    PAUS("P"), OUROS("O"), COPAS("C"), ESPADAS("E");

    private final String simbolo;

    /**
     * Construtor para inicializar o símbolo do naipe.
     *
     * @param simbolo O símbolo representando o naipe.
     */
    Naipe(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * Retorna o símbolo do naipe como uma string.
     *
     * @return O símbolo do naipe.
     */
    @Override
    public String toString() {
        return simbolo;
    }
}
