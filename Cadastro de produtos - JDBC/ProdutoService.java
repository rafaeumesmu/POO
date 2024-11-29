import java.util.List;

public class ProdutoService {
    private ProdutoDAO produtoDAO;

    public ProdutoService() {
        this.produtoDAO = new ProdutoDAO();
    }

    public void inserirProduto(Produto produto) {
        produtoDAO.inserirProduto(produto);
    }

    public void alterarProduto(Produto produto) {
        produtoDAO.alterarProduto(produto);
    }

    public void excluirProduto(int id) {
        produtoDAO.excluirProduto(id);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.listarProdutos();
    }

    public Produto detalharProduto(int id) {
        return produtoDAO.detalharProduto(id);
    }
}
 