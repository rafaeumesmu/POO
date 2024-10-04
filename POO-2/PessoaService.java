import java.util.ArrayList;

public class PessoaService {
    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    private int qtdFuncionarios = 0;
    private boolean gerenteCadastrado = false;

    public void cadastraPessoa(Pessoa pessoa) {
        listaPessoas.add(pessoa);
    }

    public void cadastrarFuncionario(Funcionario funcionario) throws QuantidadeExcedidaException {
        if (qtdFuncionarios >= 7) {
            throw new QuantidadeExcedidaException("Quantidade de Funcionários excedida.");
        }
        listaPessoas.add(funcionario);
        qtdFuncionarios++;
    }

    public void cadastrarGerente(Gerente gerente) throws QuantidadeExcedidaException {
        if (gerenteCadastrado) {
            throw new QuantidadeExcedidaException("Já existe um Gerente cadastrado.");
        }
        listaPessoas.add(gerente);
        gerenteCadastrado = true;
    }

    public void imprimeCadastro() {
        for (Pessoa pessoa : listaPessoas) {
            pessoa.imprimeDados();
        }
    }

    public Pessoa acessarPessoaPorIndice(int indice) {
        return listaPessoas.get(indice);
    }

    public int getQtdAtual() {
        return listaPessoas.size();
    }
}
