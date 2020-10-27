package appbiblioteca;

/**
 *
 * @author Gabriel Gianni Souza Oliveira (2088708-6)
 */
public class AppBiblioteca {
    public static void main(String[] args) {
        // O ISBN dos livros deve conter uma letra 'L' minúscula no final pelo motivo de ter 13 dígitos e ser do tipo 'long'.
        Livro livroGabrielGianni = new Livro(20887086, "Biblioteca com Árvore Binária, feita por Gabriel Gianni", "Gabriel Gianni (2088708-6)", 318, 2020);
        Livro oDiarioAF = new Livro(9788501044457l, "O Diário de Anne Frank", "Anne Frank", 352, 1947);
        Livro anneGG = new Livro(9788538092667l, "Anne de Green Gables", "Lucy Maud Montgomery", 336, 1908);
        Livro anneAvonlea = new Livro(9788538092544l, "Anne de Avonlea", "Lucy Maud Montgomery", 288, 1909);
        Livro anneIlha = new Livro(9788538093343l, "Anne da Ilha", "Lucy Maud Montgomery", 256, 1915);
        
        ArvoreBinaria arv = new ArvoreBinaria();
        
        arv.insere(livroGabrielGianni.getISBN(), livroGabrielGianni);
        arv.insere(oDiarioAF.getISBN(), oDiarioAF);
        arv.insere(anneGG.getISBN(), anneGG);
        arv.insere(anneAvonlea.getISBN(), anneAvonlea);
        arv.insere(anneIlha.getISBN(), anneIlha);
        
        // Método que imprime todos os livros com todas as suas informações pela ordem de ISBN.
        System.out.println("Livros disponíveis na biblioteca:\n");
        arv.imprimeEmOrdem();
        
        // Método que retorna a quantidade de nós da árvore (quantidade de livros da biblioteca).
        System.out.println("Quantidade de livros na biblioteca: " + arv.getQuantidadeLivros());
        
        // Método que imprime a altura da árvore.
        System.out.println("Altura da árvore: " + arv.getAltura());
        System.out.println();
        
        // Método de busca de um livro na Árvore.
        // Se o livro estiver na árvore é retornado true, caso contrário false.
        long isbn = livroGabrielGianni.getISBN();
        if (arv.busca(isbn)) {
            System.out.println("O livro " + isbn + " está disponível na biblioteca!");
            System.out.println();
            // Método que retorna todas as informações de um livro 
            // (ISBN, nome, autor(a), número de páginas e ano de lançamento).
            arv.infoLivro(isbn);
        } else {
            System.out.println("Não temos esse livro disponível na biblioteca!");
        }
    }
}