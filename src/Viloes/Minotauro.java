package Viloes;

public class Minotauro extends BossBase implements Boss {
    public Minotauro(){
        super("Minotauro de Creta", 1500, 40, 1500);
    }
    @Override
    public void contarHistoria() {
        System.out.println("No coração do Labirinto de Creta, vive o Minotauro, uma criação híbrida que combina força bruta e astúcia mortal. Durante a queda de Omnis, o Minotauro foi solto do labirinto mágico que o mantinha contido e agora caça qualquer ser que se atreva a desafiá-lo. Ele acumula armas e relíquias mágicas de suas vítimas, tornando-se ainda mais perigoso.\n");
    }

    @Override
    public void utilizarPoder() {
    System.out.println("O Minotauro carrega em linha reta com sua força descomunal, atingindo todos os inimigos em seu caminho com um impacto arrasador causando " + atk + " de dano!");
    }
}
