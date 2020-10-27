package appbiblioteca;

/**
 *
 * @author Gabriel Gianni Souza Oliveira (2088708-6)
 */
public class Livro {
    private String nome, autor;
    private long ISBN;
    private int numPagina, anoLancamento;

    public Livro(long ISBN, String nome, String autor, int numPagina, int anoLancamento) {
        this.ISBN = ISBN;
        this.nome = nome;
        this.autor = autor;
        this.numPagina = numPagina;
        this.anoLancamento = anoLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public int getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}