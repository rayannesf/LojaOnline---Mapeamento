package br.edu.ifpi.Principal;

import java.util.Scanner;

import br.edu.ifpi.DAO.ClienteDAO;
import br.edu.ifpi.Model.Cliente;
import br.edu.ifpi.Model.Endereco;

public class Main {

    public static ClienteDAO daoCliente = new ClienteDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {

            System.out.println("          LOJA ONLINE");
            System.out.println("------------------------------");
            System.out.println("1. Salvar Cliente com Endereço");
            System.out.println("2. Pesquisar Cliente por CPF");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Digite um número.\n");
                scanner.nextLine();
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    salvarClienteComEndereco(scanner);
                    break;

                case 2:
                    pesquisarClientePorCpf(scanner);
                    break;

                case 0:
                    System.out.println("Saindo do programa. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }
        }

        scanner.close();
    }

    private static void salvarClienteComEndereco(Scanner scanner) {
        System.out.println("\n--- CADASTRO DO CLIENTE ---");

        Cliente cliente = new Cliente();

        System.out.print("Digite o nome do cliente: ");
        cliente.setNome(scanner.nextLine());

        System.out.print("Digite o CPF do cliente: ");
        cliente.setCpf(scanner.nextLine());

        System.out.print("Digite o e-mail do cliente: ");
        cliente.setEmail(scanner.nextLine());

        System.out.println("\n--- ENDEREÇO DO CLIENTE ---");

        Endereco endereco = new Endereco();

        System.out.print("Digite o logradouro: ");
        endereco.setLogradouro(scanner.nextLine());

        System.out.print("Digite o número: ");
        endereco.setNumero(scanner.nextLine());

        System.out.print("Digite o bairro: ");
        endereco.setBairro(scanner.nextLine());

        System.out.print("Digite a cidade: ");
        endereco.setCidade(scanner.nextLine());

        System.out.print("Digite o estado: ");
        endereco.setEstado(scanner.nextLine());

        System.out.print("Digite o CEP: ");
        endereco.setCep(scanner.nextLine());

        // Relacionamento 1:1: um Cliente possui um Endereco.
        cliente.setEndereco(endereco);

        // CascadeType.ALL faz o Endereco ser persistido junto com o Cliente.
        daoCliente.salvar(cliente);

        System.out.println("\nCliente e Endereço salvos com sucesso!\n");
    }

    private static void pesquisarClientePorCpf(Scanner scanner) {
        System.out.println("\n--- PESQUISA DE CLIENTE ---\n");

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente clienteEncontrado = daoCliente.buscarPorCpf(cpf);

        if (clienteEncontrado != null) {
            System.out.println("\nCliente encontrado!");
            System.out.println("Nome: " + clienteEncontrado.getNome());
            System.out.println("CPF: " + clienteEncontrado.getCpf());
            System.out.println("E-mail: " + clienteEncontrado.getEmail());

            Endereco endereco = clienteEncontrado.getEndereco();
            if (endereco != null) {
                System.out.println("\nEndereço:");
                System.out.println("Logradouro: " + endereco.getLogradouro());
                System.out.println("Número: " + endereco.getNumero());
                System.out.println("Bairro: " + endereco.getBairro());
                System.out.println("Cidade: " + endereco.getCidade());
                System.out.println("Estado: " + endereco.getEstado());
                System.out.println("CEP: " + endereco.getCep());
            }
        } else {
            System.out.println("Cliente não encontrado com o CPF: " + cpf);
        }
        System.out.println();
    }
}
