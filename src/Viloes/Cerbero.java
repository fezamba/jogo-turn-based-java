package Viloes;

public class Cerbero extends BossBase implements Boss {
    public Cerbero(){
        super("Cerbero de Hades", 2500, 50, 2500);
    }

    @Override
    public String contarHistoria() {
       return "Na entrada do Reino dos Mortos, o Cérbero, guardião de Hades, protege o portão que conecta o mundo dos vivos ao dos mortos. \nCom três cabeças e um temperamento infernal, ele foi corrompido pelas trevas e agora ameaça não apenas o reino, mas o equilíbrio entre vida e morte.\n Seu uivo é capaz de quebrar a coragem dos mais valentes.\n";
    }

    @Override
    public void utilizarPoder() {
        System.out.println("O Cérbero usa suas mandíbulas gigantescas para atacar com força bruta, mordendo o inimigo com uma das cabeças causando " + atk + " de dano!");
    }
}
