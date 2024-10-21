package Exercicio5;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();

        int iteracoes = 10;
        int tamanhoVetor = 100000;
        long[] temposExecucao = new long[iteracoes];

        for (int i = 0; i < iteracoes; i++) {
            int[] vetor = geraVetor(tamanhoVetor);

            long tempoInicio = System.currentTimeMillis();
            qs.ordenar(vetor);
            long tempoFim = System.currentTimeMillis();

            temposExecucao[i] = tempoFim - tempoInicio;
        }

        System.out.println("------------TABELA DE RESULTADOS------------");
        System.out.printf("%-15s %-20s\n", "Iteração", "Tempo de Execução");

        for (int i = 0; i < iteracoes; i++) {
            System.out.printf("%-15s %-20d\n", "Iteração " + (i + 1), temposExecucao[i]);
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
