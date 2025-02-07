# Jogo RPG - Turn-Based RPG em Java

Este é um jogo de RPG baseado em turnos desenvolvido em Java, inspirado em mecânicas de batalhas de jogos como Pokémon. O jogador escolhe um dos quatro heróis disponíveis e enfrenta uma série de batalhas contra inimigos poderosos para restaurar o equilíbrio do reino de Eryndor.

## Funcionalidades
- Seleção de personagem com informações detalhadas.
- Sistema de batalha baseado em turnos.
- Ataques e habilidades especiais exclusivos para cada personagem.
- Inventário de itens, incluindo poções com efeitos variados.
- Sistema de buffs após derrotar chefes.
- Interface gráfica utilizando Java Swing (futuro aprimoramento).

## Como Executar
1. Certifique-se de ter o Java instalado em sua máquina.
2. Clone este repositório:
   ```sh
   git clone https://github.com/seuusuario/JogoRPG.git
   ```
3. Compile o projeto:
   ```sh
   javac -d bin src/*.java
   ```
4. Execute o jogo:
   ```sh
   java -cp bin Principal
   ```

## Estrutura do Projeto
```
JogoRPG/
├── src/              # Código-fonte do jogo
│   ├── Personagens/  # Classes dos personagens
│   ├── Principal/    # Função Main + Interface gráfica (futuro aprimoramento)
│   ├── Viloes/       # Classes dos viloes
├── README.md         # Documentação do projeto
```

## Contribuição
Sinta-se à vontade para contribuir com melhorias, reportar bugs ou sugerir novas funcionalidades.

## Licença
Este projeto está licenciado sob a MIT License - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
