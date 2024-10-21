package Exercicio2;

public class QuickSort implements AlgoritimoDeOrdenaçao {

    public void ordenar(int[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    private void quickSort(int[] vetor, int ini, int fim) {
        if (ini < fim) {
            int p = particionaLomuto(vetor, ini, fim);
            quickSort(vetor, ini, p - 1);
            quickSort(vetor, p + 1, fim);
        }
    }

    public int particionaLomuto(int[] vetor, int ini, int fim) {
        int pivot = vetor[fim];
        int i = ini - 1;

        for (int j = ini; j < fim; j++) {
            if (vetor[j] <= pivot) {
                i++;
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        return i + 1;
    }
}
