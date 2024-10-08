package Exercicio1;

public class BuscaSequencialWhile {
    public int BuscaSequencial(int[] vetor, int chaveBusca) {
        int i = 0;
        while (i < vetor.length) {
            if (vetor[i] == chaveBusca) {
                return i;
            }
            i++;
        }
        return -1;
    }
}