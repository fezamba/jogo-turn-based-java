package Personagens;
public class Miryssa extends PersonagemBase implements Personagem {
    public Miryssa() {
        super("Miryssa", 250, 150, 200, 250, 200, 100, 150, 1);
    }

    @Override
    public String contarHistoria() {
        return "Uma jovem curandeira da aldeia de Estínfalo, conhecida por sua conexão com a magia da água. \nMiryssa viu sua vila ser destruída pelos monstros mágicos e prometeu lutar para evitar que outros sofressem o mesmo destino.\n";
    }

    @Override
    public void utilizarPoder() {
        System.out.println(nome + " lança um ataque mágico básico!");
    }

    @Override
    public int utilizarPoderEspecial() {
        int cura = 150;
        if (mp >= custoMana) {
            mp -= custoMana;
            setHp(hp + cura);
            System.out.println(nome + " usa um Efeito de Cura e recupera " + cura + " HP!");
            System.out.println("Mana restante: " + mp);
        } else {
            System.out.println(nome + "não tem mana suficiente para usar o Efeito de Cura!");
        }
        return cura;
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
