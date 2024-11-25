public class Main {
    public static void main(String[] args) {
        BST arvore = new BST();

        System.out.println(arvore.qtdNos());

        arvore.adicionar(1);
        arvore.adicionar(7);
        arvore.adicionar(6);
        arvore.adicionar(5);
        arvore.adicionar(3);
        arvore.adicionar(2);

        System.out.println(arvore.qtdNos());
    }
}
