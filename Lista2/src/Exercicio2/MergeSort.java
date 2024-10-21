package Exercicio2;

public class MergeSort implements AlgoritimoDeOrdenaçao {
    public void ordenar(int[] vetor){
        int esq = 0;
        int dir = vetor.length -1;
        mergeSort(vetor, esq, dir);
    }
    public void mergeSort(int[] vetor , int esq, int dir){
        if (esq>= dir) {
            return;
        }
        else{
        int meio = (esq+dir)/2;

        mergeSort(vetor, esq, meio);
        mergeSort(vetor, meio+1, dir);
        
        merge(vetor, esq, meio , dir);
        }
    }
    public void merge (int[]vetor,  int esq, int meio , int dir){
        int[] helper = new int[vetor.length];
        for(int i = esq; i <= dir;i++){
            helper[i] = vetor[i];
        }
        int i = esq;
        int j = meio+1;
        int k = esq;
        while (i<=meio&&j<=dir) {
            if (helper[i] <= helper[j]) {
                vetor[k] =helper[i];
                i++;
            }else{
                vetor[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i<=meio) {
            vetor[k] = helper[i];
            i++;
            k++;
        }
    }
}
