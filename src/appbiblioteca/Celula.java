package appbiblioteca;

/**
 *
 * @author Gabriel Gianni Souza Oliveira (2088708-6)
 */
public class Celula {
    private long ISBN;
    private Livro livro;
    private Celula esquerda, direita;

    public Celula(long ISBN, Livro livro) {
        this.ISBN = ISBN;
        this.livro = livro;
        this.esquerda = null;
        this.direita = null;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Celula getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Celula esquerda) {
        this.esquerda = esquerda;
    }

    public Celula getDireita() {
        return direita;
    }

    public void setDireita(Celula direita) {
        this.direita = direita;
    }
}