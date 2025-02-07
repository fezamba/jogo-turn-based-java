package Viloes;

public class Golem extends BossBase implements Boss {
    public Golem(){
        super("Golem de Pedra", 2000, 20, 2000);
    }

    @Override
    public String contarHistoria() {
        return "Forjado nas profundezas das Montanhas Obsidianas, o Golem de Pedra é uma antiga criação mágica de Omnis. \nOriginalmente um guardião leal, ele foi corrompido pela energia das trevas que invadiu o mundo após a queda de seu criador. Imponente e implacável, o Golem guarda o Vale Rochoso, um local crucial para os heróis continuarem sua jornada. \nSuas investidas são capazes de esmagar até os mais poderosos guerreiros, e apenas aqueles que demonstrarem força bruta poderão derrotá-lo.\n";
    }

    @Override
    public void utilizarPoder() {
        System.out.println("O Golem de Pedra golpeia o chão com seus punhos gigantescos, criando um impacto sísmico que atinge todos os inimigos na área causando " + atk + " de dano!");
    }
}
