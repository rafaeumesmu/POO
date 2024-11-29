public class Produto {
    private int id;
    private String tipo;
    private String descricao;
    private double peso;
    private int quantidadeEstoque;
    private String unidadeMedida;

    public Produto(int id, String tipo, String descricao, double peso, int quantidadeEstoque, String unidadeMedida) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.peso = peso;
        this.quantidadeEstoque = quantidadeEstoque;
        this.unidadeMedida = unidadeMedida;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    @Override
    public String toString() {
        return "Produto{id=" + id + ", tipo='" + tipo + "', descricao='" + descricao + "', peso=" + peso
                + ", quantidadeEstoque=" + quantidadeEstoque + ", unidadeMedida='" + unidadeMedida + "'}";
    }
}
