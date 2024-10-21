package Exercicio4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BubbleSort bubble = new BubbleSort();

        int iteracoes = 10;
        int tamanhoVetor = 100000;
        long[] temposExecucao = new long[iteracoes];
        long[] numerosDeTrocas = new long[iteracoes];

        // Executa o Bubble Sort 10 vezes
        for (int i = 0; i < iteracoes; i++) {
            int[] vetor = geraVetor(tamanhoVetor);  // Gera um novo vetor para cada iteração

            long tempoInicio = System.currentTimeMillis();
            numerosDeTrocas[i] = bubble.bubbleSort(vetor);
            long tempoFim = System.currentTimeMillis();

            temposExecucao[i] = tempoFim - tempoInicio;

            System.out.println("Iteração " + (i+1) + " concluida.");
        }

        // Exibe a tabela de resultados comparativa
        System.out.println("------------TABELA DE RESULTADOS------------");
        System.out.printf("%-15s %-20s %-20s\n", "Iteração", "Tempo de Execução", "Número de Trocas");

        for (int i = 0; i < iteracoes; i++) {
            System.out.printf("%-15s %-20d %-20d\n", "Iteração " + (i + 1), temposExecucao[i], numerosDeTrocas[i]);
        }
        System.out.println("--------------------------------------------");
    }


    public static int[] geraVetor(int tamanho) {
        Random rand = new Random();
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = rand.nextInt(100000 + 1);
        }
        return vetor;
    }
}
