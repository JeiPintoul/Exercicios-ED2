public class ArvoreRubroNegra {
    private No raiz; // Raiz da árvore
    private final No NULO; // Nó "sentinela" para folhas nulas

    public ArvoreRubroNegra() {
        NULO = new No(0, Cor.PRETO); // Nó sentinela representando null
        raiz = NULO;
    }

    // Método principal para inserir um valor na árvore
    public void inserir(int valor) {
        No novoNo = new No(valor, Cor.VERMELHO);
        novoNo.esquerda = NULO;
        novoNo.direita = NULO;

        No atual = raiz;
        No pai = null;

        // Encontrar a posição para inserir o novo nó
        while (atual != NULO) {
            pai = atual;
            if (valor < atual.valor) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
        }

        // Configurar o pai do novo nó
        novoNo.pai = pai;

        if (pai == null) {
            raiz = novoNo; // Novo nó será a raiz
        } else if (valor < pai.valor) {
            pai.esquerda = novoNo;
        } else {
            pai.direita = novoNo;
        }

        // Ajustar as propriedades rubro-negras
        corrigirInsercao(novoNo);
    }

    // Corrigir a árvore após a inserção
    private void corrigirInsercao(No no) {
        while (no.pai != null && no.pai.cor == Cor.VERMELHO) {
            No avo = no.pai.pai;

            if (no.pai == avo.esquerda) { // Pai é filho esquerda do avô
                No tio = avo.direita;

                // Caso 1: O tio é vermelho
                if (tio.cor == Cor.VERMELHO) {
                    no.pai.cor = Cor.PRETO;
                    tio.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    no = avo;
                } else {
                    // Caso 2: Nó é filho direita
                    if (no == no.pai.direita) {
                        no = no.pai;
                        rotacionarEsquerda(no);
                    }

                    // Caso 3: Nó é filho esquerda
                    no.pai.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    rotacionarDireita(avo);
                }
            } else { // Pai é filho direita do avô
                No tio = avo.esquerda;

                // Caso 1: O tio é vermelho
                if (tio.cor == Cor.VERMELHO) {
                    no.pai.cor = Cor.PRETO;
                    tio.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    no = avo;
                } else {
                    // Caso 2: Nó é filho esquerda
                    if (no == no.pai.esquerda) {
                        no = no.pai;
                        rotacionarDireita(no);
                    }

                    // Caso 3: Nó é filho direita
                    no.pai.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    rotacionarEsquerda(avo);
                }
            }
        }

        raiz.cor = Cor.PRETO; // A raiz deve sempre ser preta
    }
    

    // Rotação para a esquerda
    private void rotacionarEsquerda(No no) {
        No direita = no.direita;
        no.direita = direita.esquerda;

        if (direita.esquerda != NULO) {
            direita.esquerda.pai = no;
        }

        direita.pai = no.pai;

        if (no.pai == null) {
            raiz = direita;
        } else if (no == no.pai.esquerda) {
            no.pai.esquerda = direita;
        } else {
            no.pai.direita = direita;
        }

        direita.esquerda = no;
        no.pai = direita;
    }
    

    // Rotação para a direita
    private void rotacionarDireita(No no) {
        No esquerda = no.esquerda;
        no.esquerda = esquerda.direita;

        if (esquerda.direita != NULO) {
            esquerda.direita.pai = no;
        }

        esquerda.pai = no.pai;

        if (no.pai == null) {
            raiz = esquerda;
        } else if (no == no.pai.direita) {
            no.pai.direita = esquerda;
        } else {
            no.pai.esquerda = esquerda;
        }

        esquerda.direita = no;
        no.pai = esquerda;
    }

    // Exibição em ordem para depuração
    public void emOrdem() {
        emOrdemHelper(raiz);
        System.out.println("\n");
    }

    private void emOrdemHelper(No no) {
        if (no != NULO) {
            emOrdemHelper(no.esquerda);
            System.out.print(no.valor + "(" + no.cor + ") ");
            emOrdemHelper(no.direita);
        }
    }

        // Método para remover um valor da árvore
        public void remover(int valor) {
            No no = buscarNo(raiz, valor);
            if (no == NULO) {
                System.out.println("Valor " + valor + " não encontrado na árvore.");
                return;
            }
            removerNo(no);
        }
    
        // Buscar o nó pelo valor
        private No buscarNo(No raiz, int valor) {
            if (raiz == NULO || raiz.valor == valor) {
                return raiz;
            }
            if (valor < raiz.valor) {
                return buscarNo(raiz.esquerda, valor);
            } else {
                return buscarNo(raiz.direita, valor);
            }
        }
    
        // Lógica para remoção de um nó na árvore Rubro-Negra
        private void removerNo(No no) {
            No substituto;
            No fixNode;
            Cor corOriginal = no.cor;
    
            // Caso 1: O nó tem no máximo um filho
            if (no.esquerda == NULO) {
                fixNode = no.direita;
                substituirNo(no, no.direita);
            } else if (no.direita == NULO) {
                fixNode = no.esquerda;
                substituirNo(no, no.esquerda);
            } else {
                // Caso 2: O nó tem dois filhos
                substituto = minimo(no.direita);
                corOriginal = substituto.cor;
                fixNode = substituto.direita;
    
                if (substituto.pai == no) {
                    if (fixNode != null) {
                        fixNode.pai = substituto;
                    }
                } else {
                    substituirNo(substituto, substituto.direita);
                    substituto.direita = no.direita;
                    substituto.direita.pai = substituto;
                }
    
                substituirNo(no, substituto);
                substituto.esquerda = no.esquerda;
                substituto.esquerda.pai = substituto;
                substituto.cor = no.cor;
            }
    
            if (corOriginal == Cor.PRETO) {
                corrigirRemocao(fixNode);
            }
        }
    
        // Substituir um nó por outro
        private void substituirNo(No antigo, No novoNo) {
            if (antigo.pai == null) {
                raiz = novoNo;
            } else if (antigo == antigo.pai.esquerda) {
                antigo.pai.esquerda = novoNo;
            } else {
                antigo.pai.direita = novoNo;
            }
    
            if (novoNo != null) {
                novoNo.pai = antigo.pai;
            }
        }
    
        // Encontra o nó com o menor valor na subárvore
        private No minimo(No no) {
            while (no.esquerda != NULO) {
                no = no.esquerda;
            }
            return no;
        }
    
        // Corrigir a árvore após a remoção
        private void corrigirRemocao(No no) {
            while (no != raiz && (no == null || no.cor == Cor.PRETO)) {
                if (no != null && no.pai != null && no == no.pai.esquerda) {
                    No irmao = no.pai.direita;
        
                    if (irmao != null && irmao.cor == Cor.VERMELHO) {
                        irmao.cor = Cor.PRETO;
                        no.pai.cor = Cor.VERMELHO;
                        rotacionarEsquerda(no.pai);
                        irmao = no.pai.direita;
                    }
        
                    if ((irmao == null || (irmao.esquerda == null || irmao.esquerda.cor == Cor.PRETO)) &&
                        (irmao == null || (irmao.direita == null || irmao.direita.cor == Cor.PRETO))) {
                        if (irmao != null) {
                            irmao.cor = Cor.VERMELHO;
                        }
                        no = no.pai;
                    } else {
                        if (irmao != null && (irmao.direita == null || irmao.direita.cor == Cor.PRETO)) {
                            if (irmao.esquerda != null) {
                                irmao.esquerda.cor = Cor.PRETO;
                            }
                            irmao.cor = Cor.VERMELHO;
                            rotacionarDireita(irmao);
                            irmao = no.pai.direita;
                        }
        
                        if (irmao != null) {
                            irmao.cor = no.pai.cor;
                        }
                        no.pai.cor = Cor.PRETO;
                        if (irmao != null && irmao.direita != null) {
                            irmao.direita.cor = Cor.PRETO;
                        }
                        rotacionarEsquerda(no.pai);
                        no = raiz;
                    }
                } else if (no != null && no.pai != null) {
                    No irmao = no.pai.esquerda;
        
                    if (irmao != null && irmao.cor == Cor.VERMELHO) {
                        irmao.cor = Cor.PRETO;
                        no.pai.cor = Cor.VERMELHO;
                        rotacionarDireita(no.pai);
                        irmao = no.pai.esquerda;
                    }
        
                    if ((irmao == null || (irmao.direita == null || irmao.direita.cor == Cor.PRETO)) &&
                        (irmao == null || (irmao.esquerda == null || irmao.esquerda.cor == Cor.PRETO))) {
                        if (irmao != null) {
                            irmao.cor = Cor.VERMELHO;
                        }
                        no = no.pai;
                    } else {
                        if (irmao != null && (irmao.esquerda == null || irmao.esquerda.cor == Cor.PRETO)) {
                            if (irmao.direita != null) {
                                irmao.direita.cor = Cor.PRETO;
                            }
                            irmao.cor = Cor.VERMELHO;
                            rotacionarEsquerda(irmao);
                            irmao = no.pai.esquerda;
                        }
        
                        if (irmao != null) {
                            irmao.cor = no.pai.cor;
                        }
                        no.pai.cor = Cor.PRETO;
                        if (irmao != null && irmao.esquerda != null) {
                            irmao.esquerda.cor = Cor.PRETO;
                        }
                        rotacionarDireita(no.pai);
                        no = raiz;
                    }
                } else {
                    break; // Evitar acesso a null
                }
            }
        
            if (no != null) {
                no.cor = Cor.PRETO;
            }
        }
        
}
