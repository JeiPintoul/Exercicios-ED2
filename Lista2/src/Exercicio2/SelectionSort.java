package Exercicio2;

public class SelectionSort implements AlgoritimoDeOrdenaçao {
    public void ordenar(int[] vetor){
        for(int i= 0; i< vetor.length; i++){
            int posMenor = i;
            for(int j = i +1; j <vetor.length;j++){
                if(vetor[j] < vetor[posMenor]){
                    posMenor = j;
                    if (i != posMenor) {
                        int temp = vetor[i];
                        vetor[i] = vetor[posMenor];
                        vetor[posMenor] = temp;
                    }
                }

            }
        }
    }
}
