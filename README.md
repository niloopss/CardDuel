# Laboratório 3 - Atividade #1 - Enums
## Descrição
 Card Duel é um jogo de cartas simples em Java que simula um duelo rápido entre o jogador e o computador. O jogo utiliza um baralho padrão de 52 cartas e cada jogador recebe uma carta aleatória. O vencedor é determinado pelo valor da carta, com ases sendo as cartas mais altas. O jogo também considera empates.

## Como usar:

1. **Executar o jogo**:
    - Execute a classe `Main`.

2. **Jogar**:
    - O jogo irá iniciar automaticamente.

### Interagir:

- O jogo irá mostrar as cartas do computador e do jogador.
- O jogo irá informar o resultado da rodada (vitória, derrota ou empate).
- O jogo irá mostrar o placar atual.
- O jogo irá perguntar se você deseja jogar novamente. Digite "s" para sim ou "n" para não.

### Funcionalidades:

- **Criação e embaralhamento do baralho**: O jogo cria um baralho padrão de 52 cartas e o embaralha aleatoriamente no início.
- **Distribuição de cartas**: O jogador e o computador recebem uma carta aleatória do baralho em cada rodada.
- **Comparação de cartas**: O jogo compara as cartas do jogador e do computador para determinar o vencedor da rodada.
- **Pontuação**: O jogo mantém um placar das vitórias e derrotas do jogador e do computador.
- **Repetição do jogo**: O jogador pode escolher jogar várias rodadas até decidir parar.
- **Exibição do resultado final**: Ao final do jogo, o jogo exibe o vencedor ou declara um empate.


## Fluxograma

![Fluxograma - CardDuel - Mermaid.png](Fluxograma%20-%20CardDuel%20-%20Mermaid.png)


**Código Mermaid**
```
graph TD
    A[Iniciar Jogo] --> B[Criar Baralho]
    B --> C[Iniciar Loop do Jogo]
    C --> D[Computador pega carta]
    C --> E[Jogador pega carta]
    D & E --> F[Comparar Cartas]
    F --> G{Jogador ganhou?}
    G -->|Sim| H[Incrementar vitórias do jogador]
    G -->|Não| I{Empate?}
    I -->|Sim| J[Exibir empate]
    I -->|Não| K[Incrementar vitórias do computador]
    H & J & K --> L[Exibir placar]
    L --> M{Jogar novamente?}
    M -->|Sim| C
    M -->|Não| N[Fim do Jogo]
    N --> O{Jogador venceu?}
    O -->|Sim| P[Exibir vitória do jogador]
    O -->|Não| Q{Empate?}
    Q -->|Sim| R[Exibir empate no jogo]
    Q -->|Não| S[Exibir vitória do computador]
```

## Explicação do Fluxograma:

1. **Iniciar Jogo**: O jogo começa.
2. **Criar Baralho**: Um novo baralho é criado e embaralhado.
3. **Iniciar Loop do Jogo**: O jogo entra em um loop que se repete até o jogador decidir parar.
    - **Computador pega carta**: O computador pega uma carta aleatória do baralho.
    - **Jogador pega carta**: O jogador pega uma carta aleatória do baralho.
4. **Comparar Cartas**: As cartas do jogador e do computador são comparadas.
    - **Jogador ganhou?**: Verifica se o jogador ganhou a rodada.
        - **Sim**: Incrementa as vitórias do jogador.
        - **Não**: Verifica se houve empate.
            - **Sim**: Exibe mensagem de empate.
            - **Não**: Incrementa as vitórias do computador.
5. **Exibir placar**: Mostra o placar atual (vitórias do jogador e do computador).
6. **Jogar novamente?**: Pergunta ao jogador se ele quer jogar outra rodada.
    - **Sim**: Volta ao início do loop do jogo (passo 3).
    - **Não**: Fim do jogo.
7. **Fim do Jogo**: O jogo termina.
    - **Jogador venceu?**: Verifica se o jogador venceu o jogo (mais vitórias que o computador).
        - **Sim**: Exibe mensagem de vitória do jogador.
        - **Não**: Verifica se houve empate no jogo.
            - **Sim**: Exibe mensagem de empate no jogo.
            - **Não**: Exibe mensagem de vitória do computador.





## Diagrama de Classes

![Diaagrama de Classes -  CardDuel - IntelliJ.png](Diaagrama%20de%20Classes%20-%20%20CardDuel%20-%20IntelliJ.png)


![Diagrama de Classes -  CardDuel - Mermaid.png](Diagrama%20de%20Classes%20-%20%20CardDuel%20-%20Mermaid.png)


**Código Mermaid**
```
classDiagram
    direction RL


    class Naipe {
        -String simbolo
        +Naipe(String simbolo)
        +String toString()
        <<enumeration>> PAUS
        <<enumeration>> OUROS
        <<enumeration>> COPAS
        <<enumeration>> ESPADAS
    }

    class Carta {
        -Naipe naipe
        -String valor
        -String[] valoresOrdenados
        +Carta(Naipe naipe, String valor)
        +String toString()
        +int compareTo(Carta outraCarta)
        -int indexOf(String valor)
    }

    class Baralho {
        -Carta[] cartas
        -int proximaCarta
        +Baralho()
        -void embaralhar()
        +Carta pegarCartaAleatoria()
    }

    class Main {
        +void main(String[] args)
    }

    Baralho "1" o-- "*" Carta
    Carta "1" o-- "1" Naipe
    Main "1" ..> "1" Baralho : <<create>>
```

## Explicação do Diagrama:

### Classes:

- **Naipe**: É um enum que representa os quatro naipes de um baralho de cartas (PAUS, OUROS, COPAS, ESPADAS).
- **Carta**: Representa uma carta individual, com um naipe e um valor. Possui métodos para comparação (`compareTo`) e para obter sua representação em string (`toString`).
- **Baralho**: Representa um baralho de cartas. Contém um array de cartas (`cartas`) e um índice para a próxima carta a ser retirada (`proximaCarta`). Possui métodos para embaralhar as cartas (`embaralhar`) e para pegar uma carta aleatória (`pegarCartaAleatoria`).
- **Main**: É a classe principal do jogo, onde a lógica do duelo de cartas é implementada. Cria um objeto `Baralho` e usa seus métodos para simular o jogo.

### Relacionamentos:

- **Baralho (1) o-- "*" Carta**: Um baralho contém várias cartas (relacionamento de composição).
- **Carta (1) o-- "1" Naipe**: Uma carta tem um naipe (relacionamento de associação).
- **Main (1) ..> "1" Baralho**: A classe Main cria um objeto Baralho (relacionamento de dependência).


## Resultados

## Resultados das Rodadas:

| Rodada | Carta do Computador | Carta do Jogador | Resultado          | Placar (Jogador-Computador) |
|--------|---------------------|------------------|--------------------|-----------------------------|
| 1      | OA                  | EA               | Empate             | 0-0                         |
| 2      | E2                  | C3               | Jogador Ganhou     | 1-0                         |
| 3      | OK                  | C2               | Computador Ganhou  | 1-1                         |
| 4      | EQ                  | O4               | Computador Ganhou  | 1-2                         |
| 5      | OJ                  | PK               | Jogador Ganhou     | 2-2                         |
| 6      | E4                  | P10              | Jogador Ganhou     | 3-2                         |
| 7      | PQ                  | C9               | Computador Ganhou  | 3-3                         |
| 8      | EJ                  | P5               | Computador Ganhou  | 3-4                         |
| 9      | C5                  | E3               | Computador Ganhou  | 3-5                         |
| 10     | C4                  | OQ               | Jogador Ganhou     | 4-5                         |
| 11     | E10                 | P7               | Computador Ganhou  | 4-6                         |

![Resultado - CardDuel - IntelliJ.png](Resultado%20-%20CardDuel%20-%20IntelliJ.png)
![Resultado 2 - CardDuel - IntelliJ.png](Resultado%202%20-%20CardDuel%20-%20IntelliJ.png)
![Resultado 3 - CardDuel - IntelliJ.png](Resultado%203%20-%20CardDuel%20-%20IntelliJ.png)
![Resultado 4 - CardDuel - IntelliJ.png](Resultado%204%20-%20CardDuel%20-%20IntelliJ.png)