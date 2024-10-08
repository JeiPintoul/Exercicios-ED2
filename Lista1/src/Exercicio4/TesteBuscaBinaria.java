package Exercicio4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TesteBuscaBinaria {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner entrada = new Scanner(System.in);
        BuscaBinaria busca = new BuscaBinaria();

        int[] vetor = new int[100000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(10001);
        }

        System.out.print("Qual número deseja buscar?: ");
        int chaveBusca = entrada.nextInt();

        long startTime = System.currentTimeMillis();
        Arrays.sort(vetor);
        long middleTime = System.currentTimeMillis();
        int posicao = busca.buscaBinaria(vetor, chaveBusca);
        long endTime = System.currentTimeMillis();

        long tempoCom = endTime - startTime;
        long tempoSem = endTime - middleTime;

        System.out.println("O tempo gasto com a Ordenação foi de " + tempoCom + " milisegundos.");
        System.out.println("\nO tempo gasto sem a Ordenação foi de " + tempoSem + " milisegundos.");
        System.out.println("\nO número foi encontrado na posição: " + posicao);
    }
}
