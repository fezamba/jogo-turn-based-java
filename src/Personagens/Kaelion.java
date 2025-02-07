package Personagens;
public class Kaelion extends PersonagemBase implements Personagem {
    public Kaelion() {
        super("Kaelion", 200, 300, 150, 200, 150, 100, 0, 1);
    }

    @Override
    public String contarHistoria() {
        return "Um guerreiro destemido treinado nas artes da espada do fogo. \nSua determinação em proteger os inocentes é inabalável. \nKaelion jurou proteger a Academia e vingar a queda de Omnis.\n";
    }

    @Override
    public void utilizarPoder() {
        System.out.println(nome + " lança um ataque mágico básico!");
    }

    @Override
    public int utilizarPoderEspecial() {
        int danoEspecial = 450;
        if (mp >= custoMana) {
            mp -= custoMana;
            System.out.println(nome + " usa seu ataque de erupção solar causando " + danoEspecial + " de dano!");
        } else {
            System.out.println(nome + " não tem mana suficiente para usar a erupção solar!");
        }
        return danoEspecial;
    }

    @Override
    public void adicionarItem(Item item) {
        inventario.add(item);
        System.out.println(item.getNome() + " foi adicionado ao inventário!");
    }

    @Override
    public void usarItem(int indice) {
        if (indice >= 0 && indice < inventario.size()) {
            Item item = inventario.remove(indice);

            if (item instanceof PocaoVida) {
                setHp(hp + item.getPoder());
                System.out.println(nome + " usou " + item.getNome() + " e recuperou " + item.getPoder() + " HP!");
            } else if (item instanceof PocaoMana) {
                setMp(mp + item.getPoder());
                System.out.println(nome + " usou " + item.getNome() + " e recuperou " + item.getPoder() + " MP!");
            } else {
                System.out.println(nome + " usou " + item.getNome() + ", mas não teve efeito.");
            }
        } else {
            System.out.println("Índice inválido. Não foi possível usar o item.");
        }
    }

    @Override
    public void exibirInventario() {
        if (inventario.isEmpty()) {
            System.out.println("Seu inventário está vazio!");
            return;
        }

        System.out.println("Inventário:");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println((i + 1) + " - " + inventario.get(i).toString());
        }
    }
}
