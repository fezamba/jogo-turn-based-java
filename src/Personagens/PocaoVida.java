package Personagens;

public class PocaoVida extends Item {
    public PocaoVida() {
        super("Poção de Vida", 150);
    }

    @Override
    public void usar(PersonagemBase jogador) {
        int cura = 50;
        jogador.setHp(Math.min(jogador.getHp() + cura, jogador.getHpMax()));
        System.out.println(jogador.getNome() + " recuperou " + cura + " de HP!");
    }
}
