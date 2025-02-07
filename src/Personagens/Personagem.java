package Personagens;
public interface Personagem {

    String exibirInfo();
    void utilizarPoder();
    int utilizarPoderEspecial();
    void adicionarItem(Item item);
    void usarItem(int indice);
    void exibirInventario();
    void receberDano(int dano);
    String contarHistoria();
}
