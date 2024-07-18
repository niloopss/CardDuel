import java.util.Random;

/**
 * Classe que representa um baralho de cartas.
 * O baralho contém 52 cartas e pode ser embaralhado para fornecer cartas aleatórias.
 *
 * @autor Nivea Lins
 */
class Baralho {
    private final Carta[] cartas;
    private int proximaCarta;

    /**
     * Construtor que inicializa o baralho com 52 cartas, uma para cada combinação
     * de naipe e valor, e embaralha as cartas.
     */
    public Baralho() {
        cartas = new Carta[52];
        int i = 0;
        for (Naipe naipe : Naipe.values()) {
            for (String valor : Carta.valoresOrdenados) {
                cartas[i++] = new Carta(naipe, valor);
            }
        }
        embaralhar();
    }

    /**
     * Embaralha as cartas no baralho utilizando o algoritmo de Fisher-Yates.
     */
    private void embaralhar() {
        Random random = new Random();
        for (int i = cartas.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
        proximaCarta = 0;
    }

    /**
     * Retorna uma carta aleatória do baralho. Se todas as cartas já foram distribuídas,
     * o baralho é embaralhado novamente antes de retornar uma nova carta.
     *
     * @return Uma carta aleatória do baralho.
     */

    public Carta pegarCartaAleatoria() {
        if (proximaCarta >= cartas.length) {
            embaralhar();
        }
        return cartas[proximaCarta++];
    }
}
