public class ArvoreRubroNegra {
    private No raiz; // Raiz da árvore

    public ArvoreRubroNegra() {
        raiz = null;
    }

    // Método principal para inserir um valor na árvore
    public void inserir(int valor) {
        No novoNo = new No(valor, Cor.VERMELHO); // Novo nó é sempre vermelho
        raiz = inserirBST(raiz, novoNo); // Inserção como em uma árvore binária normal
        corrigirInsercao(novoNo); // Corrigir propriedades Rubro-Negra
    }

    // Inserção padrão de árvore binária de busca
    private No inserirBST(No raiz, No novoNo) {
        if (raiz == null) {
            return novoNo;
        }

        if (novoNo.valor < raiz.valor) {
            raiz.esquerda = inserirBST(raiz.esquerda, novoNo);
            raiz.esquerda.pai = raiz;
        } else if (novoNo.valor > raiz.valor) {
            raiz.direita = inserirBST(raiz.direita, novoNo);
            raiz.direita.pai = raiz;
        }
        return raiz;
    }

    // Corrigir a árvore após a inserção
    private void corrigirInsercao(No no) {
        while (no != raiz && no.pai.cor == Cor.VERMELHO) {
            No pai = no.pai;
            No avo = pai.pai;

            // Caso A: Pai é filho esquerdo do avô
            if (pai == avo.esquerda) {
                No tio = avo.direita;

                // Caso 1: Tio é vermelho (recolorir)
                if (tio != null && tio.cor == Cor.VERMELHO) {
                    pai.cor = Cor.PRETO;
                    tio.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    no = avo;
                } else {
                    // Caso 2: Nó é filho direito (rotacionar para a esquerda)
                    if (no == pai.direita) {
                        no = pai;
                        rotacionarEsquerda(no);
                    }
                    // Caso 3: Nó é filho esquerdo (rotacionar para a direita)
                    pai.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    rotacionarDireita(avo);
                }
            } else { // Caso B: Pai é filho direito do avô
                No tio = avo.esquerda;

                // Caso 1: Tio é vermelho (recolorir)
                if (tio != null && tio.cor == Cor.VERMELHO) {
                    pai.cor = Cor.PRETO;
                    tio.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    no = avo;
                } else {
                    // Caso 2: Nó é filho esquerdo (rotacionar para a direita)
                    if (no == pai.esquerda) {
                        no = pai;
                        rotacionarDireita(no);
                    }
                    // Caso 3: Nó é filho direito (rotacionar para a esquerda)
                    pai.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    rotacionarEsquerda(avo);
                }
            }
        }
        raiz.cor = Cor.PRETO; // A raiz é sempre preta
    }

    // Rotação para a esquerda
    private void rotacionarEsquerda(No no) {
        No filhoDireita = no.direita;
        no.direita = filhoDireita.esquerda;

        if (filhoDireita.esquerda != null) {
            filhoDireita.esquerda.pai = no;
        }

        filhoDireita.pai = no.pai;

        if (no.pai == null) {
            raiz = filhoDireita;
        } else if (no == no.pai.esquerda) {
            no.pai.esquerda = filhoDireita;
        } else {
            no.pai.direita = filhoDireita;
        }

        filhoDireita.esquerda = no;
        no.pai = filhoDireita;
    }

    // Rotação para a direita
    private void rotacionarDireita(No no) {
        No filhoEsquerda = no.esquerda;
        no.esquerda = filhoEsquerda.direita;

        if (filhoEsquerda.direita != null) {
            filhoEsquerda.direita.pai = no;
        }

        filhoEsquerda.pai = no.pai;

        if (no.pai == null) {
            raiz = filhoEsquerda;
        } else if (no == no.pai.esquerda) {
            no.pai.esquerda = filhoEsquerda;
        } else {
            no.pai.direita = filhoEsquerda;
        }

        filhoEsquerda.direita = no;
        no.pai = filhoEsquerda;
    }

    // Exibição em ordem para depuração
    public void emOrdem() {
        emOrdemHelper(raiz);
    }

    private void emOrdemHelper(No no) {
        if (no != null) {
            emOrdemHelper(no.esquerda);
            System.out.print(no.valor + "(" + no.cor + ") ");
            emOrdemHelper(no.direita);
        }
    }

        // Método para remover um valor da árvore
        public void remover(int valor) {
            No no = buscarNo(raiz, valor);
            if (no == null) {
                System.out.println("Valor " + valor + " não encontrado na árvore.");
                return;
            }
            removerNo(no);
        }
    
        // Buscar o nó pelo valor
        private No buscarNo(No raiz, int valor) {
            if (raiz == null || raiz.valor == valor) {
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
            if (no.esquerda == null) {
                fixNode = no.direita;
                substituirNo(no, no.direita);
            } else if (no.direita == null) {
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
            while (no.esquerda != null) {
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
