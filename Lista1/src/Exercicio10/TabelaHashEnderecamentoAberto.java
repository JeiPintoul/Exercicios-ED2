package Exercicio10;

public class TabelaHashEnderecamentoAberto {
    private Aluno[] tabela;
    private int tamanho;
    private double fatorDeCarga;
    private static final Aluno APAGADO = new Aluno(Integer.MAX_VALUE);

    public TabelaHashEnderecamentoAberto() {
        this.tabela = new Aluno[8];
        this.tamanho = 0;
        this.fatorDeCarga = 0.75;
    }

    private int funcaoHash(int chave) {
        return chave % this.tabela.length;
    }

    public Aluno buscar(int chave) {
        int sondagem = 0;
        int hash;
        while (sondagem < tabela.length) {
            hash = (funcaoHash(chave) + sondagem) % tabela.length;
            if (tabela[hash] == null) {
                return null;
            } else if (tabela[hash].getMatricula() == chave) {
                return tabela[hash];
            } else {
                sondagem++;
            }
        }
        return null;
    }

    public void inserir(int chave) {
        if ((double) this.tamanho / this.tabela.length >= this.fatorDeCarga || this.tamanho == this.tabela.length) {
            resize();
        }
        int sondagem = 0;
        int hash;
        while (sondagem < tabela.length) {
            hash = (funcaoHash(chave) + sondagem) % tabela.length;
            if (tabela[hash] == null || tabela[hash].equals(APAGADO)) {
                tabela[hash] = new Aluno(chave);
                imprimirTabela();
                this.tamanho++;
                return;
            } else {
                sondagem++;
            }
        }
    }

    public void remover(int chave) {
        int sondagem = 0;
        int hash;
        while (sondagem < tabela.length) {
            hash = (funcaoHash(chave) + sondagem) % tabela.length;
            if (tabela[hash] == null) {
                return;
            } else if (tabela[hash].getMatricula() == chave) {
                tabela[hash] = APAGADO;
                tamanho--;
                imprimirTabela();
                return;
            } else {
                sondagem++;
            }
        }
    }

    private void resize() {
        Aluno[] tabelaAntiga = this.tabela;
        this.tabela = new Aluno[this.tabela.length * 2];
        this.tamanho = 0;
        for (Aluno aluno : tabelaAntiga) {
            if (aluno != null && !aluno.equals(APAGADO)) {
                this.inserir(aluno.getMatricula());
            }
        }
    }

    public void imprimirTabela() {
        System.out.println("\n------------ Tabela Hash ------------");
        for (int i = 0; i < tabela.length; i++) {
            System.out.print("Posição " + i + ": ");
            if (tabela[i] == null) {
                System.out.println("Vazia");
            } else if (tabela[i].equals(APAGADO)) {
                System.out.println("Apagado");
            } else {
                System.out.println("Matrícula " + tabela[i].getMatricula());
            }
        }
        System.out.println("-------------------------------------\n");
    }

}
