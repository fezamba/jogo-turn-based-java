package Principal;

import Personagens.*;
import Viloes.*;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        try {
            System.out.println("Bem-vindo a Os Guardiões de Eryndor!");

            List<PersonagemBase> personagens = Arrays.asList(
                    new Kaelion(),
                    new Miryssa(),
                    new Claymor(),
                    new Aelira()
            );

            System.out.println("Escolha seu personagem:");
            for (int i = 0; i < personagens.size(); i++) {
                System.out.println((i + 1) + " - " + personagens.get(i).getNome());
                personagens.get(i).contarHistoria();
                personagens.get(i).exibirInfo();
                System.out.println("\n");
            }

            int escolha = -1;
            while (escolha < 0 || escolha >= personagens.size()) {
                try {
                    System.out.println("Digite o número do personagem: ");
                    escolha = scanner.nextInt() - 1;
                    if (escolha < 0 || escolha >= personagens.size()) {
                        System.out.println("Opção inválida! Escolha um número entre 1 e " + personagens.size());
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Digite um número.");
                    scanner.next();
                }
            }

            PersonagemBase jogador = personagens.get(escolha);
            System.out.println("Você escolheu: " + jogador.getNome() + "\n");

            for (int i = 0; i < 5; i++) {
                jogador.adicionarItem(new PocaoVida());
                jogador.adicionarItem(new PocaoMana());
            }
            System.out.println("Você recebeu 5 Poções de Vida e 5 Poções de Mana para começar sua jornada!");

            List<BossBase> inimigos = Arrays.asList(
                    new Golem(),
                    new Grifo(),
                    new Minotauro(),
                    new Cerbero(),
                    new Hydra()
            );

            for (BossBase inimigo : inimigos) {
                System.out.println("\n==== BATALHA: " + inimigo.getNome() + " ====");
                inimigo.contarHistoria();
                batalha(jogador, inimigo);
                if (jogador.getHp() <= 0) {
                    System.out.println("Você foi derrotado! O reino de Eryndor caiu...");
                    return;
                }
            }
            System.out.println("Parabéns! Você derrotou todos os inimigos e restaurou o equilíbrio de Eryndor!");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void batalha(PersonagemBase jogador, BossBase inimigo) {
        while (jogador.getHp() > 0 && inimigo.getHp() > 0) {
            try {
                System.out.println("\n==== Status Atual ====");
                jogador.exibirInfo();
                inimigo.exibirInfo();

                System.out.println("\nSua vez! Escolha uma ação:");
                System.out.println("1 - Utilizar poder");
                System.out.println("2 - Utilizar poder especial");
                System.out.println("3 - Usar item");
                System.out.println("4 - Exibir inventário (não consome turno)");

                int acao = scanner.nextInt();

                if (acao == 4) {
                    jogador.exibirInventario();
                    continue;
                }

                switch (acao) {
                    case 1:
                        int dado = rolarDado();
                        System.out.println("Dado rolado: " + dado);
                        int dano = calcularDano(jogador.getAtk(), dado);
                        jogador.utilizarPoder();
                        inimigo.receberDano(dano);
                        break;
                    case 2:
                        jogador.utilizarPoderEspecial();
                        inimigo.utilizarPoder();
                        break;
                    case 3:
                        if (jogador.getInventario().isEmpty()) {
                            System.out.println("Seu inventário está vazio!");
                        } else {
                            int itemEscolhido = -1;

                            while (itemEscolhido < 0 || itemEscolhido >= jogador.getInventario().size()) {
                                try {
                                    System.out.println("Escolha um item para usar ou digite 0 para cancelar: ");
                                    jogador.exibirInventario();
                                    itemEscolhido = scanner.nextInt() - 1;

                                    if (itemEscolhido == -1) {
                                        System.out.println("Uso de item cancelado.");
                                        break;
                                    }

                                    if (itemEscolhido >= 0 && itemEscolhido < jogador.getInventario().size()) {
                                        jogador.usarItem(itemEscolhido);
                                    } else {
                                        System.out.println("Escolha inválida! Tente novamente.");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada inválida! Digite um número válido.");
                                    scanner.next();
                                }
                            }
                        }
                        break;
                    default:
                        System.out.println("Ação inválida!");
                }

                if (inimigo.getHp() > 0) {
                    int danoInimigo = inimigo.getAtk();
                    jogador.receberDano(danoInimigo);
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número válido.");
                scanner.next();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado na batalha: " + e.getMessage());
                e.printStackTrace();
            }
        }

        if (jogador.getHp() > 0) {
            recompensaVitoria(jogador);
        }
    }

    private static void recompensaVitoria(PersonagemBase jogador) {
        try {
            System.out.println("\nVocê venceu! Escolha uma recompensa:");
            System.out.println("1 - Poção de vida");
            System.out.println("2 - Poção de mana");
            System.out.println("3 - Buff aleatório (HP, MP ou ATK)");

            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    jogador.adicionarItem(new PocaoVida());
                    break;
                case 2:
                    jogador.adicionarItem(new PocaoMana());
                    break;
                case 3:
                    aplicarBuff(jogador);
                    break;
                default:
                    System.out.println("Escolha inválida! Nenhuma recompensa recebida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Nenhuma recompensa recebida.");
            scanner.next();
        }
    }

    private static void aplicarBuff(PersonagemBase jogador) {
        int buff = random.nextInt(3);
        if (buff == 0) {
            jogador.setHpMax(jogador.getHpMax() + 50);
            jogador.setHp(jogador.getHpMax());
            System.out.println("Você recuperou todo seu HP e aumentou o seu máximo em 50!");
        } else if (buff == 1) {
            jogador.setMpMax(jogador.getMpMax() + 50);
            jogador.setMp(jogador.getMpMax());
            System.out.println("Você recuperou toda sua MP e aumentou sua máxima em 50!");
        } else {
            jogador.setAtk(jogador.getAtk() + 50);
            System.out.println("Seu ataque aumentou em 50!");
        }
    }

    private static int rolarDado() {
        return random.nextInt(20) + 1;
    }

    private static int calcularDano(int atkBase, int dado) {
        if (dado < 5) return (int) (atkBase * 0.75);
        if (dado > 15) return (int) (atkBase * 1.5);
        return atkBase;
    }
}