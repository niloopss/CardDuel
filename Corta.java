/**
 * Classe que representa uma carta de baralho, com um naipe e um valor.
 * Implementa a interface {@link Comparable} para permitir a comparação entre cartas.
 *
 * @autor Nivea Lins
 */
class Carta implements Comparable<Carta> {
    private final Naipe naipe;
    private final String valor;

    static final String[] valoresOrdenados = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    /**
     * Construtor que inicializa uma carta com um naipe e um valor.
     *
     * @param naipe O naipe da carta.
     * @param valor O valor da carta.
     */
    public Carta(Naipe naipe, String valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    /**
     * Retorna uma representação em string da carta, no formato "NaipeValor".
     *
     * @return A representação em string da carta.
     */
    @Override
    public String toString() {
        return naipe + valor;
    }

    /**
     * Compara esta carta com outra carta baseada no valor.
     *
     * @param outraCarta A outra carta para comparar.
     * @return Um número negativo se esta carta for menor que a outra carta,
     *         zero se forem iguais, e um número positivo se for maior.
     */
    @Override
    public int compareTo(Carta outraCarta) {
        for (int i = 0; i < valoresOrdenados.length; i++) {
            if (valoresOrdenados[i].equals(this.valor)) {
                return i - indexOf(outraCarta.valor);
            }
        }
        return 0;
    }

    /**
     * Retorna o índice de um valor no array {@code valoresOrdenados}.
     *
     * @param valor O valor a ser procurado.
     * @return O índice do valor no array {@code valoresOrdenados}, ou 0 se não encontrado.
     */
    private int indexOf(String valor) {
        for (int i = 0; i < valoresOrdenados.length; i++) {
            if (valoresOrdenados[i].equals(valor)) {
                return i;
            }
        }
        return 0;
    }
}
