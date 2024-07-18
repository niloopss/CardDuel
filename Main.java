import java.util.Scanner;

/**
 * Classe principal que executa o jogo de cartas.
 * O jogo consiste em várias rodadas onde o jogador e o computador tiram cartas aleatórias,
 * e quem tirar a carta de maior valor vence a rodada. O jogo continua até que o jogador
 * decida parar.
 *
 * @autor Nivea Lins
 */
public class Main {

    /**
     * Método principal que inicia o jogo.
     */
    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        int vitoriasJogador = 0;
        int vitoriasComputador = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            Carta cartaComputador = baralho.pegarCartaAleatoria();
            Carta cartaJogador = baralho.pegarCartaAleatoria();

            System.out.println("\n--- Nova Rodada ---");
            System.out.println("Computador: " + cartaComputador);
            System.out.println("Jogador: " + cartaJogador);

            int resultado = cartaJogador.compareTo(cartaComputador);
            if (resultado > 0) {
                System.out.println("Você ganhou esta rodada!");
                vitoriasJogador++;
            } else if (resultado < 0) {
                System.out.println("O computador ganhou esta rodada!");
                vitoriasComputador++;
            } else {
                System.out.println("Empate!");
            }

            System.out.println("\nPlacar:");
            System.out.println("Jogador: " + vitoriasJogador);
            System.out.println("Computador: " + vitoriasComputador);

            System.out.print("\nJogar novamente? (s/n): ");
        } while (scanner.nextLine().equalsIgnoreCase("s"));

        System.out.println("\n--- Fim do Jogo ---");
        if (vitoriasJogador > vitoriasComputador) {
            System.out.println("Parabéns! Você venceu o jogo!");
        } else if (vitoriasJogador < vitoriasComputador) {
            System.out.println("O computador venceu o jogo. Tente novamente!");
        } else {
            System.out.println("O jogo terminou em empate!");
        }
    }
}
