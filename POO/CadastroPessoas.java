import java.util.ArrayList;

// Classe Data
class Data {
    int dia, mes, ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}

// Classe abstrata Pessoa
abstract class Pessoa {
    String nome;
    Data nascimento;

    public Pessoa(String nome, Data nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public abstract void imprimeDados();
}

// Classe Cliente
class Cliente extends Pessoa {
    int codigo;

    public Cliente(String nome, Data nascimento, int codigo) {
        super(nome, nascimento);
        this.codigo = codigo;
    }

    @Override
    public void imprimeDados() {
        System.out.println("Cliente: " + nome + ", Código: " + codigo + ", Nascimento: " + nascimento);
    }
}

// Classe Funcionário
class Funcionario extends Pessoa {
    float salario;

    public Funcionario(String nome, Data nascimento, float salario) {
        super(nome, nascimento);
        this.salario = salario;
    }

    public float calculaImposto() {
        return salario * 0.05f;
    }

    @Override
    public void imprimeDados() {
        System.out.println("Funcionário: " + nome + ", Salário: " + salario + ", Imposto: " + calculaImposto() + ", Nascimento: " + nascimento);
    }
}

// Classe Gerente (herda de Funcionário)
class Gerente extends Funcionario {
    String area;

    public Gerente(String nome, Data nascimento, float salario, String area) {
        super(nome, nascimento, salario);
        this.area = area;
    }

    @Override
    public float calculaImposto() {
        return salario * 0.03f;
    }

    @Override
    public void imprimeDados() {
        System.out.println("Gerente: " + nome + ", Salário: " + salario + ", Área: " + area + ", Imposto: " + calculaImposto() + ", Nascimento: " + nascimento);
    }
}

// Classe CadastroPessoas
class CadastroPessoas {
    ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    int qtdAtual = 0;

    public void cadastraPessoa(Pessoa pessoa) {
        listaPessoas.add(pessoa);
        qtdAtual++;
    }

    public void imprimeCadastro() {
        for (Pessoa pessoa : listaPessoas) {
            pessoa.imprimeDados();
        }
    }

    public Pessoa acessarPessoaPorIndice(int indice) throws ArrayIndexOutOfBoundsException {
        return listaPessoas.get(indice);
    }

    public int getQtdAtual() {
        return qtdAtual;
    }
}
