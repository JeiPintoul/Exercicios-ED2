package Exercicio2;

public class InsertionSort implements AlgoritimoDeOrdenaçao {
    public void ordenar(int[] vetor){
        for(int i = 1; i< vetor.length;i++){
            int elemento = vetor[i];
            int j = i-1;
            while (j >= 0 && vetor[j] > elemento) {
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j+1] = elemento;
        }
    }
}
