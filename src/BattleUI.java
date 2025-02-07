import javax.swing.*;
import java.awt.*;
import Personagens.*;
import Viloes.*;
import java.util.Arrays;
import java.util.List;
class BattleUI {
    private JFrame frame;
    private JTextArea textArea;
    private PersonagemBase jogador;
    private List<BossBase> inimigos = Arrays.asList(new Golem(), new Grifo(), new Minotauro(), new Hydra());
    private int bossAtual = 0;

    public BattleUI(PersonagemBase jogador, BossBase inimigo) {
        this.jogador = jogador;
        this.inimigos = inimigos;

        frame = new JFrame("Batalha contra " + inimigos.get(bossAtual).getNome());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("Você encontrou " + inimigos.get(bossAtual).getNome() + "\n");
        textArea.setText(inimigos.get(bossAtual).contarHistoria());
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton atacarButton = new JButton("Atacar");
        JButton especialButton = new JButton("Especial");
        JButton usarItemButton = new JButton("Usar Item");
        JButton inventarioButton = new JButton("Exibir Inventário");

        atacarButton.addActionListener(e -> atacar());
        especialButton.addActionListener(e -> especial());
        usarItemButton.addActionListener(e -> usarItem());
        inventarioButton.addActionListener(e -> exibirInventario());

        buttonPanel.add(atacarButton);
        buttonPanel.add(especialButton);
        buttonPanel.add(usarItemButton);
        buttonPanel.add(inventarioButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
    }

    private void atacar() {
        int dano = jogador.getAtk();
        inimigos.get(bossAtual).receberDano(dano);
        textArea.append("\nVocê atacou " + inimigos.get(bossAtual).getNome() + " causando " + dano + " de dano!");
        turnoInimigo();
        atualizarStatus();
    }

    private void especial(){
        int cura = jogador.getCura();
        int custoMana = jogador.getCustoMana();
        int mp = jogador.getMp();
        int danoEspecial = jogador.utilizarPoderEspecial();
            if(mp >= custoMana) {
                jogador.utilizarPoderEspecial();
                if(jogador.getNome() == "Miryssa"){
                    textArea.append(("\nVocê usou seu poder especial curando " + cura + " de vida!"));
                    turnoInimigo();
                    atualizarStatus();
                } if (jogador.getNome() == "Claymor") {
                    textArea.append("\nVocê usou seu poder especial e a partir de agora todo dano sofrido será reduzido em 50%!");
                    turnoInimigo();
                    atualizarStatus();
                }
                else {
                    textArea.append("\nVocê usou seu poder especial causando " + danoEspecial + " de dano!");
                    inimigos.get(bossAtual).receberDano(danoEspecial);
                    turnoInimigo();
                    atualizarStatus();
                }
            }
            else
                textArea.append("\nVocê não tem mana suficiente para realizar o ataque especial!\nUSE UMA POÇÃO!");
    }

    private void usarItem() {
        if (jogador.getInventario().isEmpty()) {
            textArea.append("\nSeu inventário está vazio!");
            return;
        }

        String[] itens = jogador.getInventario().stream().map(Object::toString).toArray(String[]::new);
        String itemEscolhido = (String) JOptionPane.showInputDialog(frame, "Escolha um item:", "Usar Item", JOptionPane.PLAIN_MESSAGE, null, itens, itens[0]);

        if (itemEscolhido != null) {
            jogador.usarItem(Arrays.asList(itens).indexOf(itemEscolhido));
            textArea.append("\nVocê usou " + itemEscolhido + "!");
            atualizarStatus();
        }
    }

    private void exibirInventario() {
        if (jogador.getInventario().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Seu inventário está vazio!", "Inventário", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String inventario = String.join("\n", jogador.getInventario().stream().map(Object::toString).toArray(String[]::new));
            JOptionPane.showMessageDialog(frame, "Itens no inventário:\n" + inventario, "Inventário", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void atualizarStatus() {
        textArea.append("\nVida do Jogador: " + jogador.getHp() + " / " + jogador.getHpMax() + "\nMana do jogador: " + jogador.getMp() + " / " + jogador.getMpMax());
        textArea.append("\nVida do " + inimigos.get(bossAtual).getNome() + ": " + inimigos.get(bossAtual).getHp() + " / " + inimigos.get(bossAtual).getHpMax());
        textArea.append("\n----------------------------------------------------------------------------------\n");
        if (jogador.getHp() <= 0) {
            gameOver();
        }
    }

    private void turnoInimigo() {
        int reduzirDano = jogador.getReduzirDano();
        int dano = inimigos.get(bossAtual).getAtk();
        int danoFinal = (int) (dano * (1 / (double)reduzirDano));
        if (inimigos.get(bossAtual).getHp() > 0) {
            jogador.receberDano(dano);
            textArea.append("\n" + inimigos.get(bossAtual).getNome() + " atacou você causando " + danoFinal + " de dano!");
        } else {
            textArea.append("\nVocê derrotou " + inimigos.get(bossAtual).getNome() + "!");
            bossAtual++;
            if (bossAtual < inimigos.size()) {
                textArea.append("\nPróximo inimigo: " + inimigos.get(bossAtual).getNome() + "\n");
                textArea.append(inimigos.get(bossAtual).contarHistoria() + "\n");
            } else {
                textArea.append("\nParabéns! Você restaurou a paz em Eryndor!");
            }
        }

    }
    private void gameOver() {
        JOptionPane.showMessageDialog(frame, "Game Over! Você foi derrotado.", "Game Over", JOptionPane.ERROR_MESSAGE);
        frame.dispose();
        new GameUI();
    }
}
