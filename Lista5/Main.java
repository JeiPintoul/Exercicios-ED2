public class Main {
    public static void main(String[] args) {
        ArvoreRubroNegra arvore = new ArvoreRubroNegra();

        // Inserir valores na árvore
        int[] valoresInseridos = {50, 30, 20, 70, 40, 35, 37, 38, 10, 32, 45, 42, 25, 47, 36, 49};
        for (int valor : valoresInseridos) {
            arvore.inserir(valor);
        }

        System.out.println("\nÁrvore Rubro-Negra em ordem após inserções:");
        arvore.emOrdem();

        // Remover valores da árvore
        int[] valoresRemovidos = {37, 70, 45, 36, 32, 42, 40};
        for (int valor : valoresRemovidos) {
            arvore.remover(valor);
        }

        System.out.println("\n\nÁrvore Rubro-Negra em ordem após remoções:");
        arvore.emOrdem();
    }
}
