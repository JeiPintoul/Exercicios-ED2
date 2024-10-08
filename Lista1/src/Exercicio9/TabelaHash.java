package Exercicio9;

import java.util.ArrayList;

class TabelaHash {
    private ArrayList<Aluno>[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new ArrayList[tamanho];
    }

    private int funcaoHash(int chave) {
        return chave % tamanho;
    }

    public Aluno buscar(int chave) {
        int hash = funcaoHash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];
        if (alunos == null) {
            return null;
        }
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == chave) {
                return aluno;
            }
        }
        return null;
    }

    public void inserir(int chave) {
        int hash = funcaoHash(chave);
        Aluno novoAluno = new Aluno(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];
        if (alunos == null) {
            alunos = new ArrayList<>();
            alunos.add(novoAluno);
            this.tabela[hash] = alunos;
        } else {
            for (int i = 0; i < alunos.size(); i++) {
                if (alunos.get(i).getMatricula() == chave) {
                    alunos.set(i, novoAluno);
                    return;
                }
            }
            alunos.add(novoAluno);
        }
        imprimirTabela();
    }

    public void remover(int chave) {
        int hash = funcaoHash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];
        if (alunos != null) {
            for (Aluno aluno : alunos) {
                if (aluno.getMatricula() == chave) {
                    alunos.remove(aluno);
                    imprimirTabela();
                    return;
                }
            }
        }
    }

    public void imprimirTabela() {
        System.out.println("\n------------ Tabela Hash ------------");
        for (int i = 0; i < tabela.length; i++) {
            System.out.print("Posição " + i + ": ");
            if (tabela[i] == null || tabela[i].isEmpty()) {
                System.out.println("Vazia");
            } else {
                System.out.println(tabela[i]);
            }
        }
        System.out.println("-------------------------------------\n");
    }
}