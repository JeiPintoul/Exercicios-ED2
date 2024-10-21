package Exercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de números que deseja inserir: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Digite um número: ");
            int valor = scanner.nextInt();
            sort.insertionSort(lista, valor);
        }

        System.out.println("Lista ordenada: " + lista);

        scanner.close();
    }
}
