package Exercicio2;

import java.util.Random;

public class Mainzinho {
    public static void main(String[] args) {
        int[] vetor = new int[100000];
        int iteracoes = 10;
        String[] algoritmos = {"Bubble Sort", "Insertion Sort", "Selection Sort", "Shell Sort", "Merge Sort", "Quick Sort"};
        long[][] temposExecucao = new long[iteracoes][algoritmos.length];

        for(int i = 0; i < iteracoes; i++){
            temposExecucao[i] = tabela(vetor);
            System.out.println("Iteração " + i + " concluida.");
        }
        
        System.out.println("------------TABELA DE TEMPO DE EXECUÇÃO------------");
        System.out.printf("%-15s", "Iteração");
        for (String alg : algoritmos) {
            System.out.printf("%-20s", alg);
        }
        System.out.println();

        for (int i = 0; i < iteracoes; i++) {
            System.out.printf("%-15s", "Iteração " + (i + 1));
            for (int j = 0; j < algoritmos.length; j++) {
                System.out.printf("%-20s", temposExecucao[i][j] + "ms");
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
    }

    public static long[] tabela(int[] vetor){
        long[] tempos = new long[6];

        AlgoritimoDeOrdenaçao bubble = new BubbleSort();
        int[] vetorTeste = geraVetor(vetor);
        long tempo1 = System.currentTimeMillis();
        bubble.ordenar(vetorTeste);
        long tempo2 = System.currentTimeMillis();
        tempos[0] = tempo2 - tempo1;

        vetorTeste = geraVetor(vetor);
        AlgoritimoDeOrdenaçao insertion = new InsertionSort();
        tempo1 = System.currentTimeMillis();
        insertion.ordenar(vetorTeste);
        tempo2 = System.currentTimeMillis();
        tempos[1] = tempo2 - tempo1;

        vetorTeste = geraVetor(vetor);
        AlgoritimoDeOrdenaçao selection = new SelectionSort();
        tempo1 = System.currentTimeMillis();
        selection.ordenar(vetorTeste);
        tempo2 = System.currentTimeMillis();
        tempos[2] = tempo2 - tempo1;

        vetorTeste = geraVetor(vetor);
        AlgoritimoDeOrdenaçao shell = new ShellSort();
        tempo1 = System.currentTimeMillis();
        shell.ordenar(vetorTeste);
        tempo2 = System.currentTimeMillis();
        tempos[3] = tempo2 - tempo1;

        vetorTeste = geraVetor(vetor);
        AlgoritimoDeOrdenaçao merge = new MergeSort();
        tempo1 = System.currentTimeMillis();
        merge.ordenar(vetorTeste);
        tempo2 = System.currentTimeMillis();
        tempos[4] = tempo2 - tempo1;

        vetorTeste = geraVetor(vetor);
        AlgoritimoDeOrdenaçao quick = new QuickSort();
        tempo1 = System.currentTimeMillis();
        quick.ordenar(vetorTeste);
        tempo2 = System.currentTimeMillis();
        tempos[5] = tempo2 - tempo1;

        return tempos;
    }

    public static int[] geraVetor(int[] vetor){
        Random rand = new Random();
        for(int i = 0; i < vetor.length; i++){
            vetor[i] = rand.nextInt(100000 + 1);
        }
        return vetor;
    }
}
