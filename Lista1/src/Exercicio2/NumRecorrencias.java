package Exercicio2;

import java.util.ArrayList;
import java.util.Collections;

public class NumRecorrencias {
    public static ArrayList<Integer> NumRecorrenciasSequencial(int[] vetor, int chaveBusca) {
        ArrayList<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == chaveBusca) {
                resultado.add(i);
            }
        }
        return resultado;
    }

    public static ArrayList<Integer> NumRecorrenciasBinaria(int[] vetor, int chaveBusca) {
        ArrayList<Integer> resultado = new ArrayList<>();

        int posInicial = 0;
        int posFinal = vetor.length - 1;

        while (posInicial <= posFinal) {
            int posMeio = (posInicial + posFinal) / 2;

            if(vetor[posMeio] == chaveBusca) {
                resultado.add(posMeio);
                
                int posAnterior = posMeio - 1;
                while (posAnterior >= 0 && vetor[posAnterior] == chaveBusca) {
                    resultado.add(posAnterior);
                    posAnterior--;
                }

                int posPosterior = posMeio + 1;
                while (posPosterior < vetor.length && vetor[posPosterior] == chaveBusca) {
                    resultado.add(posPosterior);
                    posPosterior++;
                }
                
                break;
            }
            else if(chaveBusca < vetor[posMeio]) posFinal = posMeio - 1;
            else if(chaveBusca > vetor[posMeio]) posInicial = posMeio + 1;
        }
        Collections.sort(resultado);
        return resultado;
    }

    public static void main(String[] args)
    {
        int[] lista = {1, 2, 2, 2, 3, 4, 5, 6, 6, 7};
        
        ArrayList<Integer> resultadosSequencial = NumRecorrenciasSequencial(lista, 2);
        System.out.println("Busca Sequencial - Índices encontrados: " + resultadosSequencial);


        ArrayList<Integer> resultadosBinaria = NumRecorrenciasBinaria(lista, 2);
        System.out.println("Busca Binária - Índices encontrados: " + resultadosBinaria);
    }
}
