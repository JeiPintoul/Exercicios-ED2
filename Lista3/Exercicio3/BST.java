package Exercicio3;

public class BST {
    private No raiz;

    public BST() {
        this.raiz = null;
    }

    public void adicionar(int novoValor) {
        No novoNo = new No(novoValor);

        if (this.raiz == null) {
            this.raiz = novoNo;
            return;
        }

        No noAux = new No(novoValor);

        noAux = this.raiz;

        while (true) {
            if (novoValor < noAux.valor) {
                if (noAux.esq == null) {
                    noAux.esq = novoNo;
                    break;
                }
                noAux = noAux.esq;
            } else if (novoValor > noAux.valor) {
                if (noAux.dir == null) {
                    noAux.dir = novoNo;
                    break;
                }
                noAux = noAux.dir;
            }
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
        imprimirPreOrdem(this.raiz);
    }

    public void imprimirPosOrdem() {
        imprimirPosOrdem(this.raiz);
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdem(this.raiz);
    }

    private void imprimirPreOrdem(No noRaiz) {
        if (noRaiz == null) {
            return;
        }

        System.out.println(noRaiz.valor);
        imprimirPreOrdem(noRaiz.esq);
        imprimirPreOrdem(noRaiz.dir);
    }

    private void imprimirPosOrdem(No noRaiz) {
        if (noRaiz == null) {
            return;
        }

        imprimirPosOrdem(noRaiz.esq);
        imprimirPosOrdem(noRaiz.dir);
        System.out.println(noRaiz.valor);
    }

    private void imprimirEmOrdem(No noRaiz) {
        if (noRaiz == null) {
            return;
        }

        imprimirEmOrdem(noRaiz.esq);
        System.out.println(noRaiz.valor);
        imprimirEmOrdem(noRaiz.dir);
    }

    public int qtdNos() {
        return qtdNos(this.raiz);
    }

    private int qtdNos(No noRaiz) {
        if (noRaiz == null) {
            return 0;
        } else return 1 + qtdNos(noRaiz.esq) + qtdNos(noRaiz.dir);
    }
}
