public class No {
    int valor;
    Cor cor;
    No esquerda, direita, pai;

    No(int valor, Cor cor) {
        this.valor = valor;
        this.cor = cor;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}
