package Viloes;

public abstract class BossBase implements Boss {
    protected String nome;
    protected int hp;
    protected int atk;
    protected int hpMax;


    public BossBase(String nome, int hp, int atk, int hpMax) {
        this.nome = nome;
        this.hp = hp;
        this.atk = atk;
        this.hpMax = hpMax;

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

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public void receberDano(int dano){
        int danoFinal = Math.max(0, dano);
        setHp(hp - danoFinal);
        System.out.println(nome + " recebeu " + danoFinal + " de dano! Vida atual: " + hp + "/" + hpMax);
    }

    public String exibirInfo() {
        return "Uma temível criatura surge, seu nome é " + nome + ". Vida atual: " + hp + "/" + hpMax;
    }
}
