package Exercicio2;

public class ShellSort implements AlgoritimoDeOrdenaçao {
    
    public void ordenar(int[] vetor){
        int tamanho = vetor.length;
        int h = 1;
        //sequencia de knuth
        while (h<tamanho) {
            h = 3 * h + 1;
        }
        while (h > 1) {
            h /= 3;
            for(int i = h; i < tamanho; i++){
                int temp = vetor[i];
                int j = i - h;
                while (j >= 0 && temp < vetor[j]) {
                    vetor[j+h] = vetor[j];
                    j -= h;
                }
                vetor[j+h] = temp;
            }
        }
    }
}
