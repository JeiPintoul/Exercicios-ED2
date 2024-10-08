package Exercicio9;

public class Main {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash(8);

        int[] elementosParaInserir = {52, 45, 64, 34, 69, 11, 10, 3, 6, 2};
        for (int elemento : elementosParaInserir) {
            tabela.inserir(elemento);
        }

        System.out.println("Buscando 45: " + (tabela.buscar(45) != null ? "Encontrado" : "Não encontrado"));
        System.out.println("Buscando 75: " + (tabela.buscar(75) != null ? "Encontrado" : "Não encontrado"));

        System.out.println("Removendo 11:");
        tabela.remover(11);
    }
}
