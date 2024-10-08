package Exercicio3;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import Exercicio1.*;

public class TesteBuscaSequencial {
    public static void main(String[] args) {
        Random random = new Random();
        //Usando o método do Exercicio 1
        BuscaSequencialWhile busca = new BuscaSequencialWhile();
        try (Scanner entrada = new Scanner(System.in)) {
            int[] vetor = new int[100000];

            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = random.nextInt(10001);
            }

            System.out.print("Qual o número que deseja buscar?: ");
            int chaveBusca = entrada.nextInt();

            long startTime = System.currentTimeMillis();
            int posicao = busca.BuscaSequencial(vetor, chaveBusca);
            long endTime = System.currentTimeMillis();

            long tempo = endTime - startTime;

            System.out.println("O tempo gasto foi de " + tempo + " milisegundos.");
            System.out.println("O número foi encontrado na posição: " + posicao);
        }
    }
}
