# Jogo RPG Turn-Based em Java

Este é um jogo de RPG baseado em turnos desenvolvido em Java, inspirado em mecânicas de batalhas de jogos como Pokémon. O jogador escolhe um dos quatro heróis disponíveis e enfrenta inimigos poderosos em combates táticos para restaurar o equilíbrio do reino fictício de Eryndor.

## Estrutura do Projeto

O projeto está organizado em pacotes distintos para manter a separação de responsabilidades:

- `Principal/` – Contém a classe principal (`Main.java`) que executa o jogo.
- `Personagens/` – Define os heróis jogáveis, suas habilidades e itens:
  - Personagens como `Kaelion`, `Aelira`, `Claymor`, `Miryssa`
  - Itens: `PocaoMana`, `PocaoVida`, `Item.java`
- `Viloes/` – Contém os inimigos e chefes enfrentados ao longo da jornada:
  - Vilões como `Cerbero`, `Golem`, `Grifo`, `Hydra`, `Minotauro`
  - Base comum de chefes (`Boss`, `BossBase`)

## Funcionalidades

- **Sistema de batalha por turnos:** alternância de ações entre o jogador e os inimigos.
- **Personagens com habilidades exclusivas:** cada herói possui ataques e atributos próprios.
- **Gestão de inventário:** uso estratégico de poções de cura e mana.
- **Sistema de buffs:** o jogador recebe melhorias permanentes após derrotar chefes.

## Requisitos

- Java 8 ou superior
- IDE compatível (Ex: IntelliJ, Eclipse)

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/fezamba/jogo-turn-based-java.git
   ```
2. Importe o projeto em sua IDE Java preferida.
3. Compile e execute a classe `Main.java` localizada em `src/Principal`.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues, sugerir melhorias ou enviar pull requests.
