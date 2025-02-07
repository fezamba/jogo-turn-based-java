package Viloes;

public class Hydra extends BossBase implements Boss {
    public Hydra(){
        super("Hydra de Lerna", 3000, 60, 3000);
    }
    @Override
    public String contarHistoria() {
        return "A Hidra de Lerna, uma fera lendária que habita as profundezas de um pântano envenenado, foi despertada pelas forças sombrias. \nCom várias cabeças que regeneram sempre que uma é cortada, ela representa um desafio quase impossível. \nApenas o mais habilidoso e determinado dos heróis pode enfrentá-la sem sucumbir. \nA Hidra guarda o Nexus da Magia, a última esperança para restaurar o equilíbrio de Eryndor.\n";
    }

    @Override
    public void utilizarPoder() {
        System.out.println("A Hidra utiliza suas várias cabeças para atacar o inimigo em uma sequência devastadora de golpes. Cada cabeça ataca com força crescente, tornando o último golpe o mais perigoso. Assim, causando " + atk + " de dano!");
    }
}
