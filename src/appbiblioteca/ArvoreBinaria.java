package appbiblioteca;

/**
 *
 * @author Gabriel Gianni Souza Oliveira (2088708-6)
 */
public class ArvoreBinaria {
    private Celula raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }
    
    // A seguinte função recebe o número ISBN e um livro e os insere 
    // na árvore binária organizando-os em ordem crescente pelo ISBN do livro.
    public void insere(long ISBN, Livro livro) {
        this.raiz = this.insere(this.raiz, ISBN, livro);
    }
    
    private Celula insere(Celula no, long ISBN, Livro livro) {
        if (no == null) {
            return new Celula(ISBN, livro);
        }

        if (ISBN < no.getISBN()) {
            no.setEsquerda(insere(no.getEsquerda(), ISBN, livro));
        } else {
            no.setDireita(insere(no.getDireita(), ISBN, livro));
        }

        return no;
    }
    
    // A seguinte função imprime todos os livros e seus dados em ordem crescente pelo ISBN.
    public void imprimeEmOrdem() {
        imprimeEmOrdem(this.raiz);
    }
    
    public void imprimeEmOrdem(Celula no) {
        if (no != null) {
            imprimeEmOrdem(no.getEsquerda());
            System.out.println("ISBN: " + no.getISBN());
            System.out.println("Nome do livro: " + no.getLivro().getNome());
            System.out.println("Autor(a): " + no.getLivro().getAutor());
            System.out.println("Número de páginas: " + no.getLivro().getNumPagina());
            System.out.println("Ano de lançamento: " + no.getLivro().getAnoLancamento());
            System.out.println();
            imprimeEmOrdem(no.getDireita());
        }
    }
    
    // A seguinte função retorna a altura total de uma árvore binária.
    public int getAltura() {
        return this.getAltura(this.raiz);
    }
    
    private int getAltura(Celula no) {
        if (no != null) {
            int he = getAltura(no.getEsquerda());
            int hd = getAltura(no.getDireita());
            if (he > hd) {
                return he + 1;
            }
            return hd + 1;
        }
        return -1;
    }
    
    private Celula getAntecessor(Celula no) {
        if (no == null) {
            return null;
        }
        Celula aux = no.getEsquerda();
        while (aux.getDireita() != null) {
            aux = aux.getDireita();
        }
        return aux;
    }
    
    // A seguinte função recebe um número ISBN (nó da árvore) e o remove da árvore
    // se ele estiver na árvore.
    public void remove(long ISBN) {
        this.raiz = this.remove(this.raiz, ISBN);
    }
    
    private Celula remove(Celula no, long ISBN) {
        if (no == null) {
            return null;
        }
        
        if (ISBN < no.getISBN()) {
            no.setEsquerda(remove(no.getEsquerda(), ISBN));
        } else if (ISBN > no.getISBN()) {
            no.setDireita(remove(no.getDireita(), ISBN));
        } else {
            if (no.getEsquerda()== null) {
                return no.getDireita();
            } else if (no.getDireita() == null) {
                return no.getEsquerda();
            }
            
            Celula aux = getAntecessor(no);
            no.setISBN(aux.getISBN());
            no.setEsquerda(remove(no.getEsquerda(), ISBN));
        }
        return no;
    }
    
    // A seguinte função recebe um número ISBN e faz uma busca na árvore
    // retornando 'true' se existir ou 'false' caso não exista o número ISBN na árvore.
    public boolean busca(long ISBN) {
        Celula aux = this.busca(this.raiz, ISBN);
        return aux != null;
    }
 
    private Celula busca(Celula no, long ISBN) {
        if (no == null) {
            return null;
        }
        if (ISBN < no.getISBN()) {
            return busca(no.getEsquerda(), ISBN);
        } else if (ISBN > no.getISBN()) {
            return busca(no.getDireita(), ISBN);
        }
        return no;
    }
    
    // A seguinte função recebe um número ISBN e retorna todas as informações de 
    // um livro (número ISBN, nome, autor(a), número de páginas e ano de lançamento).
    public void infoLivro(long ISBN) {
         busca(this.raiz, ISBN);
         System.out.println("==== INFORMAÇÕES SOBRE O LIVRO " + raiz.getISBN() + " ====" +
                 "\nISBN: " + raiz.getLivro().getISBN()+
                 "\nNome do livro: " + raiz.getLivro().getNome() + 
                 "\nAutor(a): " + raiz.getLivro().getAutor() + 
                 "\nNúmero de páginas: " + raiz.getLivro().getNumPagina() + 
                 "\nAno de lançamento: " + raiz.getLivro().getAnoLancamento());
    }
    
    // A seguinte função retorna a quantidade de nós na árvore 
    // (quantidade de livros na biblioteca).
    public int getQuantidadeLivros() {
        return this.getQuantidadeLivros(this.raiz);
    }
    
    private int getQuantidadeLivros(Celula no) {
        int quantidade = 0;
        if (no != null) {
            quantidade = quantidade + getQuantidadeLivros(no.getEsquerda());
            quantidade = quantidade + getQuantidadeLivros(no.getDireita());
            quantidade = quantidade + 1;
        }
        return quantidade;
    }
}