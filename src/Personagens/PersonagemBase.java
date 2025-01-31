package Personagens;
import java.util.ArrayList;
import java.util.List;
public abstract class PersonagemBase implements Personagem{
    protected String nome;
    protected int hp;
    protected int atk;
    protected int mp;
    protected int hpMax;
    protected int mpMax;
    protected ArrayList<Item> inventario;

    public PersonagemBase(String nome, int hp, int atk, int mp, int hpMax, int mpMax) {
        this.nome = nome;
        this.hp = hp;
        this.atk = atk;
        this.mp = mp;
        this.hpMax = hpMax;
        this.mpMax = mpMax;
        this.inventario = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getMpMax() {
        return mpMax;
    }

    public void setMpMax(int mpMax) {
        this.mpMax = mpMax;
    }

    public List<Item> getInventario(){
        return new ArrayList<>(inventario);
    }

    public void receberDano(int dano){
        int danoFinal = Math.max(0, dano);
        setHp(hp - danoFinal);
        System.out.println(nome + " recebeu " + danoFinal + " de dano! Vida atual: " + hp + "/" + hpMax);
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + hp + "/" + hpMax);
        System.out.println("Mana: " + mp + "/" + mpMax);
        System.out.println("Ataque: " + atk);
    }
}

