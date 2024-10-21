package Exercicio3;

import java.util.ArrayList;

public class InsertionSort {
    public void insertionSort(ArrayList<Integer> lista, int elemento) {
        lista.add(elemento);

        int i = lista.size() - 1;
        while (i > 0 && lista.get(i - 1) > elemento) {

            lista.set(i, lista.get(i - 1));
            i--;
        }
        lista.set(i, elemento);
    }
}
