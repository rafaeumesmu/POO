public class Main {
    public static void main(String[] args) {
        ProdutoService produtoService = new ProdutoService();

        // Inserir produtos
        produtoService.inserirProduto(new Produto(0, "Informática", "Computador Dell", 2.5, 10, "kg"));
        produtoService.inserirProduto(new Produto(0, "Limpeza", "Detergente Líquido", 1.0, 50, "litro"));
        produtoService.inserirProduto(new Produto(0, "Casa & Decoração", "Vaso Decorativo", 0.5, 30, "unidade"));
        produtoService.inserirProduto(new Produto(0, "Eletrônicos", "Smartphone Samsung", 0.2, 20, "kg"));
        produtoService.inserirProduto(new Produto(0, "Brinquedos", "Boneca de Pelúcia", 0.3, 100, "unidade"));

        // Alterar produtos
        Produto produtoAlterado = new Produto(1, "Informática", "Computador Dell i7", 2.5, 8, "kg");
        produtoService.alterarProduto(produtoAlterado);

        // Excluir produto
        produtoService.excluirProduto(5);

        // Listar produtos
        System.out.println("Produtos cadastrados:");
        for (Produto produto : produtoService.listarProdutos()) {
            System.out.println(produto);
        }

        // Detalhar produto
        System.out.println("\nDetalhes do produto com ID 1:");
        Produto produtoDetalhado = produtoService.detalharProduto(1);
        System.out.println(produtoDetalhado);
    }
}