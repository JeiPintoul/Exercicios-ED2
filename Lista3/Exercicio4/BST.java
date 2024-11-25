package Exercicio4;

import java.util.ArrayList;
import java.util.List;

public class BST {
    private No raiz;

    public BST() {
        this.raiz = null;
    }

    public void adicionar(int novoValor) {
        No novoNo = new No(novoValor);
        adicionar(novoNo, this.raiz);
    }

    private void adicionar(No novoNo, No noRaiz) {
        //Por algum motivo, simplesmente receber a raiz como parâmetro na primeira interação estava dando erro
        //e nunca inicializava a árvore, então tive que criar este if a mais.
        if (this.raiz == null) {
            this.raiz = novoNo;
            return;
        }

        //Condição de parada
        if(noRaiz == null) {
            noRaiz = novoNo;
            return;
        }

        if(novoNo.valor < noRaiz.valor) {
            if (noRaiz.esq == null) {
                noRaiz.esq = novoNo;
            } else adicionar(novoNo, noRaiz.esq);
        } else {
            if (noRaiz.dir == null) {
                noRaiz.dir = novoNo;
            } else adicionar(novoNo, noRaiz.dir);
        }
    }

    public boolean buscar(int valor) {
        return buscar(this.raiz, valor);
    }

    public boolean buscar(No noRaiz, int valor) {
        if (noRaiz == null) {
            return false;
        }

        if (noRaiz.valor == valor) {
            return true;
        }

        if (noRaiz.valor < valor) {
            return buscar(noRaiz.dir, valor);
        } else {
            return buscar(noRaiz.esq, valor);
        }
    }

    public boolean isFolha(No no) {
        return no.esq == null && no.dir == null;
    }

    public void remover(int valor) {
        this.raiz = remover(valor, this.raiz);
    }

    public No remover(int valor, No noRaiz) {
        if (noRaiz == null) {
            return noRaiz;
        }

        if (valor < noRaiz.valor) {
            noRaiz.esq = remover(valor, noRaiz.esq);
        } else if (valor > noRaiz.valor) {
            noRaiz.dir = remover(valor, noRaiz.dir);
        } else {
            if (isFolha(noRaiz)) {
                //Remover o elemento
                return null;
            }
            else if (noRaiz.esq == null) {
                return noRaiz.dir;
            } else if (noRaiz.dir == null) {
                return noRaiz.esq;
            }

            No predecessor = max(noRaiz.esq);
            noRaiz.valor = predecessor.valor;
            noRaiz.esq = remover(predecessor.valor, noRaiz.esq);
        }
        return noRaiz;
    }

    private No max(No raiz) {
        if (raiz == null) {
            return raiz;
        }

        if (raiz.dir != null) {
            return max(raiz.dir);
        }

        return raiz;
    }

    public void imprimirPreOrdem() {
        List<Integer> valores = new ArrayList<>();
        coletarPreOrdem(this.raiz, valores);
        System.out.println("PreOrdem: " + valores.toString());
    }

    public void imprimirPosOrdem() {
        List<Integer> valores = new ArrayList<>();
        coletarPosOrdem(this.raiz, valores);
        System.out.println("PosOrdem: " + valores.toString());
    }

    public void imprimirEmOrdem() {
        List<Integer> valores = new ArrayList<>();
        coletarEmOrdem(this.raiz, valores);
        System.out.println("EmOrdem: " + valores.toString());
    }

    private void coletarPreOrdem(No noRaiz, List<Integer> valores) {
        if (noRaiz == null) {
            return;
        }
        valores.add(noRaiz.valor); // Adiciona o valor atual
        coletarPreOrdem(noRaiz.esq, valores); // Percorre a esquerda
        coletarPreOrdem(noRaiz.dir, valores); // Percorre a direita
    }

    private void coletarPosOrdem(No noRaiz, List<Integer> valores) {
        if (noRaiz == null) {
            return;
        }
        coletarPosOrdem(noRaiz.esq, valores); // Percorre a esquerda
        coletarPosOrdem(noRaiz.dir, valores); // Percorre a direita
        valores.add(noRaiz.valor); // Adiciona o valor atual
    }

    private void coletarEmOrdem(No noRaiz, List<Integer> valores) {
        if (noRaiz == null) {
            return;
        }
        coletarEmOrdem(noRaiz.esq, valores); // Percorre a esquerda
        valores.add(noRaiz.valor); // Adiciona o valor atual
        coletarEmOrdem(noRaiz.dir, valores); // Percorre a direita
    }

    public int qtdNos() {
        return qtdNos(this.raiz);
    }

    private int qtdNos(No noRaiz) {
        if (noRaiz == null) {
            return 0;
        } else return 1 + qtdNos(noRaiz.esq) + qtdNos(noRaiz.dir);
    }

    public BST espelharArvore() {
        BST arvoreEspelhada = new BST();
        arvoreEspelhada.raiz = espelharArvore(this.raiz);
        return arvoreEspelhada;
    }

    private No espelharArvore(No noRaiz) {
        if (noRaiz == null) {
            return null;
        }

        No novoNo = new No(noRaiz.valor);

        novoNo.esq = espelharArvore(noRaiz.dir);
        novoNo.dir = espelharArvore(noRaiz.esq);

        return novoNo;
    }
}

