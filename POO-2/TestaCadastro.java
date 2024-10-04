import java.util.InputMismatchException;
import java.util.Scanner;

public class TestaCadastro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PessoaService pessoaService = new PessoaService();

        boolean continuar = true;

        while (continuar) {
            System.out.println("MENU:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Cadastrar Gerente");
            System.out.println("4. Imprimir Cadastro");
            System.out.println("5. Acessar pessoa por índice");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // Cadastrar Cliente
                    System.out.print("Nome do cliente: ");
                    sc.nextLine(); // Consumir nova linha
                    String nomeCliente = sc.nextLine();
                    System.out.print("Data de nascimento (dia mês ano): ");
                    int diaCliente = sc.nextInt();
                    int mesCliente = sc.nextInt();
                    int anoCliente = sc.nextInt();
                    System.out.print("Código do cliente: ");
                    int codigoCliente = sc.nextInt();
                    pessoaService.cadastraPessoa(new Cliente(nomeCliente, new Data(diaCliente, mesCliente, anoCliente), codigoCliente));
                    break;

                case 2:
                    // Cadastrar Funcionário
                    try {
                        System.out.print("Nome do funcionário: ");
                        sc.nextLine(); // Consumir nova linha
                        String nomeFuncionario = sc.nextLine();
                        System.out.print("Data de nascimento (dia mês ano): ");
                        int diaFuncionario = sc.nextInt();
                        int mesFuncionario = sc.nextInt();
                        int anoFuncionario = sc.nextInt();
                        System.out.print("Salário do funcionário: ");
                        float salarioFuncionario = sc.nextFloat();
                        pessoaService.cadastrarFuncionario(new Funcionario(nomeFuncionario, new Data(diaFuncionario, mesFuncionario, anoFuncionario), salarioFuncionario));
                    } catch (QuantidadeExcedidaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                
                case 3:
                    // Cadastrar Gerente
                    try {
                        System.out.print("Nome do gerente: ");
                        sc.nextLine(); // Consumir nova linha
                        String nomeGerente = sc.nextLine();
                        System.out.print("Data de nascimento (dia mês ano): ");
                        int diaGerente = sc.nextInt();
                        int mesGerente = sc.nextInt();
                        int anoGerente = sc.nextInt();
                        System.out.print("Salário do gerente: ");
                        float salarioGerente = sc.nextFloat();
                        sc.nextLine(); // Consumir nova linha
                        System.out.print("Área do gerente: ");
                        String areaGerente = sc.nextLine();
                        pessoaService.cadastrarGerente(new Gerente(nomeGerente, new Data(diaGerente, mesGerente, anoGerente), salarioGerente, areaGerente));
                    } catch (QuantidadeExcedidaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Imprimir todo o cadastro
                    pessoaService.imprimeCadastro();
                    break;

                case 5:
                    // Acessar uma pessoa pelo índice
                    try {
                        System.out.print("Digite o índice da pessoa que deseja acessar: ");
                        int indice = sc.nextInt();
                        if (indice >= 0 && indice < pessoaService.getQtdAtual()) {
                            Pessoa pessoa = pessoaService.acessarPessoaPorIndice(indice);
                            pessoa.imprimeDados();
                        } else {
                            System.out.println("Erro: Índice fora do limite.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Índice inválido. Deve ser um número inteiro.");
                        sc.next(); // Limpar a entrada inválida
                    }
                    break;

                case 6:
                    // Sair
                    continuar = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        sc.close();
    }
}
