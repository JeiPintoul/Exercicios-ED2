public class No {
    int valor;
    No esq;
    No dir;
    int altura;

    public No(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
        this.altura = 1;
    }
}
