package Exercicio5;

public class QuickSort {
    public void ordenar(int[] vetor) {
        dualPivotQuickSort(vetor, 0, vetor.length - 1);
    }

    private void dualPivotQuickSort(int[] vetor, int ini, int fim) {
        if (ini < fim) {
            int[] pivots = particiona(vetor, ini, fim);
            int p1 = pivots[0];  // Pivô 1
            int p2 = pivots[1];  // Pivô 2

            dualPivotQuickSort(vetor, ini, p1 - 1);    // Parte 1: menores que P1
            dualPivotQuickSort(vetor, p1 + 1, p2 - 1); // Parte 2: entre P1 e P2
            dualPivotQuickSort(vetor, p2 + 1, fim);    // Parte 3: maiores que P2
        }
    }

    private int[] particiona(int[] vetor, int ini, int fim) {
        if (vetor[ini] > vetor[fim]) {
            troca(vetor, ini, fim);
        }
        int p1 = vetor[ini];
        int p2 = vetor[fim];

        int i = ini + 1;
        int k = fim - 1;
        int j = ini + 1;

        while (j <= k) {
            if (vetor[j] < p1) {
                troca(vetor, i++, j++);
            } else if (vetor[j] > p2) {
                troca(vetor, j, k--);
            } else {
                j++;
            }
        }

        troca(vetor, ini, --i);
        troca(vetor, fim, ++k);

        return new int[]{i, k};
    }

    private void troca(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
