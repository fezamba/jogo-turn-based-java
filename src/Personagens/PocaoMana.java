package Personagens;

public class PocaoMana extends Item {
    public PocaoMana() {
        super("Poção de Mana", 100);
    }

    @Override
    public void usar(PersonagemBase jogador) {
        int cura = 50;
        jogador.setHp(Math.min(jogador.getHp() + cura, jogador.getHpMax()));
        System.out.println(jogador.getNome() + " recuperou " + cura + " de HP!");
    }
}
