package Exercicio7;

public class Main {
    public static void main(String[] args) {
        BST arvore1 = new BST();
        arvore1.adicionar(5);
        arvore1.adicionar(3);
        arvore1.adicionar(7);
    
        BST arvore2 = new BST();
        arvore2.adicionar(10);
        arvore2.adicionar(8);
    
        BST arvore3 = new BST();
        arvore3.adicionar(10);
    
        System.out.println("Árvore 1 é estritamente binária? " + arvore1.isBinaria()); // true
        System.out.println("Árvore 2 é estritamente binária? " + arvore2.isBinaria()); // false
        System.out.println("Árvore 3 é estritamente binária? " + arvore3.isBinaria()); // true
    }
}
