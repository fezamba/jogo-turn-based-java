package Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Personagens.*;
import Viloes.*;
import java.util.Arrays;
import java.util.List;

public class GameUI {
    private JFrame frame;
    private JPanel panel;
    private JTextArea textArea;
    private JButton startButton;
    private List<PersonagemBase> personagens;

    public GameUI() {
        frame = new JFrame("Os Guardiões de Eryndor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        startButton = new JButton("Iniciar Jogo");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJogo();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(startButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void iniciarJogo() {
        personagens = Arrays.asList(new Kaelion(), new Miryssa(), new Claymor(), new Aelira());
        textArea.setText("Escolha seu personagem:\n");

        JPanel escolhaPanel = new JPanel();
        escolhaPanel.setLayout(new GridLayout(personagens.size(), 1));

        for (PersonagemBase personagem : personagens) {
            JButton button = new JButton(personagem.getNome());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    iniciarBatalha(personagem);
                }
            });
            escolhaPanel.add(button);
        textArea.append(personagem.getNome() + "\n" + personagem.exibirInfo() + "\n" + personagem.contarHistoria() + "\n");
        }

        panel.remove(startButton);
        panel.add(escolhaPanel, BorderLayout.SOUTH);
        panel.revalidate();
        panel.repaint();
    }

    private void iniciarBatalha(PersonagemBase jogador) {
        for (int i = 0; i < 5; i++) {
            jogador.adicionarItem(new PocaoVida());
            jogador.adicionarItem(new PocaoMana());
        }

        frame.dispose();
        new BattleUI(jogador, new Golem());
        new BattleUI(jogador, new Grifo());
        new BattleUI(jogador, new Minotauro());
        new BattleUI(jogador, new Cerbero());
        new BattleUI(jogador, new Hydra());
    }

    public static void main(String[] args) {
        new GameUI();
    }
}


