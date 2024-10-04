import java.util.ArrayList;

public class CadastroPessoas {
    ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public void cadastraPessoa(Pessoa pessoa) {
        listaPessoas.add(pessoa);
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
