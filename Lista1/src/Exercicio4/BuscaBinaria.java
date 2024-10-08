package Exercicio4;

public class BuscaBinaria {
    public int buscaBinaria(int[] vetor, int chaveBusca) {
        int posInicial = 0;
        int posFinal = vetor.length - 1;

        while (posInicial <= posFinal) {
            int meio = (posInicial + posFinal) / 2;
            if (vetor[meio] == chaveBusca) {
                return meio;
            }
            else if (vetor[meio] < chaveBusca) {
                posInicial = meio + 1;
            }
            else if (vetor[meio] > chaveBusca) {
                posFinal = meio - 1;
            }
        }
        return -1;
    }
}
