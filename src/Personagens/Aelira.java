package Personagens;
public class Aelira extends PersonagemBase implements Personagem {
    public Aelira() {
        super("Aelira", 300, 200, 300, 300, 300);
    }

    @Override
    public void contarHistoria() {
        System.out.println("Uma maga do elemento ar, descendente de uma linhagem antiga de guardiões elementais. Ela busca honrar seu clã destruindo as forças do mal que ameaçam Eryndor.\n");
    }

    @Override
    public void utilizarPoder() {
        System.out.println(nome + " lança um ataque mágico básico!");
    }

    @Override
    public void utilizarPoderEspecial() {
        int custoMana = 100;
        if (mp >= custoMana) {
            mp -= custoMana;
            int danoEspecial = 300;
            System.out.println(nome + " usa um Tornado Arcano causando " + danoEspecial + " de dano!");
        } else {
            System.out.println(nome + " não tem mana suficiente para usar o Tornado Arcano!");
        }
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
