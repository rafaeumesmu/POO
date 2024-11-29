import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO() {
        try {
            // Configuração da conexão JDBC (substitua pelo seu próprio banco de dados)
            String url = "jdbc:mysql://localhost:3306/poo"; // URL do banco
            String usuario = "root"; // Usuário do banco
            String senha = "pivete220@"; // Senha do banco
            this.connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inserir um produto
    public void inserirProduto(Produto produto) {
        String sql = "INSERT INTO produtos (tipo, descricao, peso, quantidade_estoque, unidade_medida) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getTipo());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPeso());
            stmt.setInt(4, produto.getQuantidadeEstoque());
            stmt.setString(5, produto.getUnidadeMedida());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para alterar um produto
    public void alterarProduto(Produto produto) {
        String sql = "UPDATE produtos SET tipo = ?, descricao = ?, peso = ?, quantidade_estoque = ?, unidade_medida = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getTipo());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPeso());
            stmt.setInt(4, produto.getQuantidadeEstoque());
            stmt.setString(5, produto.getUnidadeMedida());
            stmt.setInt(6, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um produto
    public void excluirProduto(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os produtos
    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String descricao = rs.getString("descricao");
                double peso = rs.getDouble("peso");
                int quantidadeEstoque = rs.getInt("quantidade_estoque");
                String unidadeMedida = rs.getString("unidade_medida");

                Produto produto = new Produto(id, tipo, descricao, peso, quantidadeEstoque, unidadeMedida);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    // Método para detalhar um produto
    public Produto detalharProduto(int id) {
        Produto produto = null;
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tipo = rs.getString("tipo");
                    String descricao = rs.getString("descricao");
                    double peso = rs.getDouble("peso");
                    int quantidadeEstoque = rs.getInt("quantidade_estoque");
                    String unidadeMedida = rs.getString("unidade_medida");

                    produto = new Produto(id, tipo, descricao, peso, quantidadeEstoque, unidadeMedida);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }
}
