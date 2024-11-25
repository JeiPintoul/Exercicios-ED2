package Exercicio3;

public class Main {
    public static void main(String[] args) {
        BST arvore = new BST();

        arvore.adicionar(4);
        arvore.adicionar(7);
        arvore.adicionar(6);
        arvore.adicionar(5);
        arvore.adicionar(3);
        arvore.adicionar(2);
        arvore.adicionar(1);

        System.out.println(arvore.qtdNos());
        arvore.imprimirEmOrdem();
    }
}
