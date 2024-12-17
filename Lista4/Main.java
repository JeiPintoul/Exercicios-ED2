public class Main {
    public static void main(String[] args) {
        AVL arvore = new AVL();

        // Exercicio 1 - letra a
        System.out.println("Inserindo elementos na árvore AVL:");

        System.out.println("\nInserindo: 50");
        arvore.inserir(50);
        arvore.printTree();

        System.out.println("\nInserindo: 1");
        arvore.inserir(1);
        arvore.printTree();

        System.out.println("\nInserindo: 64");
        arvore.inserir(64);
        arvore.printTree();

        System.out.println("\nInserindo: 12");
        arvore.inserir(12);
        arvore.printTree();

        System.out.println("\nInserindo: 18");
        arvore.inserir(18);
        arvore.printTree();

        System.out.println("\nInserindo: 66");
        arvore.inserir(66);
        arvore.printTree();

        System.out.println("\nInserindo: 38");
        arvore.inserir(38);
        arvore.printTree();

        System.out.println("\nInserindo: 95");
        arvore.inserir(95);
        arvore.printTree();

        System.out.println("\nInserindo: 58");
        arvore.inserir(58);
        arvore.printTree();

        System.out.println("\nInserindo: 59");
        arvore.inserir(59);
        arvore.printTree();

        System.out.println("\nInserindo: 70");
        arvore.inserir(70);
        arvore.printTree();

        System.out.println("\nInserindo: 68");
        arvore.inserir(68);
        arvore.printTree();

        System.out.println("\nInserindo: 39");
        arvore.inserir(39);
        arvore.printTree();

        System.out.println("\nInserindo: 62");
        arvore.inserir(62);
        arvore.printTree();

        System.out.println("\nInserindo: 7");
        arvore.inserir(7);
        arvore.printTree();

        System.out.println("\nInserindo: 60");
        arvore.inserir(60);
        arvore.printTree();

        System.out.println("\nInserindo: 43");
        arvore.inserir(43);
        arvore.printTree();

        System.out.println("\nInserindo: 16");
        arvore.inserir(16);
        arvore.printTree();

        System.out.println("\nInserindo: 67");
        arvore.inserir(67);
        arvore.printTree();

        System.out.println("\nInserindo: 34");
        arvore.inserir(34);
        arvore.printTree();

        System.out.println("\nInserindo: 35");
        arvore.inserir(35);
        arvore.printTree();

        System.out.println("\nRemovendo elementos da árvore AVL:");

        // Exercicio 1 - letra b
        System.out.println("\nRemovendo: 50");
        arvore.remover(50);
        arvore.printTree();

        System.out.println("\nRemovendo: 95");
        arvore.remover(95);
        arvore.printTree();

        System.out.println("\nRemovendo: 70");
        arvore.remover(70);
        arvore.printTree();

        System.out.println("\nRemovendo: 60");
        arvore.remover(60);
        arvore.printTree();

        System.out.println("\nRemovendo: 35");
        arvore.remover(35);
        arvore.printTree();
    }
}
