package Personagens;
public abstract class Item {
    private String nome;
    private int poder;

    public Item(String nome, int poder) {
        this.nome = nome;
        this.poder = poder;
    }

    public String getNome() {
        return nome;
    }

    public int getPoder() {
        return poder;
    }

    @Override
    public String toString() {
        return nome + " (Poder: " + poder + ")";
    }


    public abstract void usar(PersonagemBase jogador);
}
