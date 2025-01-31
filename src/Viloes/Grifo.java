package Viloes;

public class Grifo extends BossBase implements Boss {
    public Grifo(){
        super("Hipogrifo do Lago Estínfalo", 1500, 35, 1500);
    }
    @Override
    public void contarHistoria() {
        System.out.println("No misterioso Lago Estínfalo, cercado por névoas eternas, reside o Hipogrifo, uma criatura majestosa que foi outrora símbolo de equilíbrio e sabedoria. Após a corrupção trazida pelas trevas, ele se tornou uma fera agressiva, atacando qualquer um que se aproxime de suas águas cristalinas. O lago é uma fonte poderosa de energia mágica, e o Hipogrifo impede que ela seja usada para restaurar o equilíbrio.\n");
    }

    @Override
    public void utilizarPoder() {
        System.out.println("O Hipogrifo alça voo e mergulha em alta velocidade contra o inimigo, usando suas garras afiadas causando " + atk + " de dano!");
    }
}
