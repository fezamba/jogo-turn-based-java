package Personagens;
public interface Personagem {

    void contarHistoria();
    void utilizarPoder();
    void utilizarPoderEspecial();
    void adicionarItem(Item item);
    void usarItem(int indice);
    void exibirInventario();
    void receberDano(int dano);
}
