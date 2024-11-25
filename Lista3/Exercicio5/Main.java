package Exercicio5;

public class Main {
    public static void main(String[] args) {
        BST arvore_1 = new BST();
        BST arvore_2 = new BST();

        arvore_1.adicionar(50);
        arvore_2.adicionar(45);

        arvore_1.adicionar(30);
        arvore_2.adicionar(25);

        arvore_1.adicionar(20);
        arvore_2.adicionar(10);

        arvore_1.adicionar(10);
        arvore_2.adicionar(5);

        arvore_1.adicionar(25);
        arvore_2.adicionar(20);

        arvore_1.adicionar(40);
        arvore_2.adicionar(40);

        arvore_1.adicionar(35);
        arvore_2.adicionar(35);

        arvore_1.adicionar(70);
        arvore_2.adicionar(50);

        arvore_1.adicionar(60);
        arvore_2.adicionar(47);

        arvore_1.adicionar(80);
        arvore_2.adicionar(55);

        arvore_1.adicionar(77);
        arvore_2.adicionar(53);

        System.out.println("Arvore 1 nos: " + arvore_1.qtdNos());
        System.out.println("Arvore 2 nos: " + arvore_2.qtdNos());

        System.out.println("\n\nAs duas árvores são similares?: " + arvore_1.checarSimilaridade(arvore_2));
    }
}
