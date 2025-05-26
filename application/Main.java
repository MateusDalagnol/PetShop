
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import enums.StatusServico;

public class Main {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        Agenda agenda = new Agenda();

        int opcao;
        do {
            System.out.println("\n-------MENU-------");
            System.out.println();

            System.out.println(
                    "1 - Cliente\n" +
                            "2 - Servico\n" +
                            "3 - Funcionario\n" +
                            "4 - Animal\n" +
                            "5 - Exibir\n" +
                            "\n------------------\n");

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    cliente(agenda);
                    opcao = 99;
                    break;
                case 2:
                    servico(agenda);
                    break;
                case 3:
                    funcionario();
                    break;
                case 4:
                    animal();
                    break;
                case 5:
                    exibir(agenda);
                    break;

                default:
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void exibir(Agenda agenda) {
        int opcao;
        Scanner sc = new Scanner(System.in);
        do {
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    agenda.exibirServico("mate");
                    break;
                case 2:
                    break;
                default:
                    opcao = 0;
                    break;
            }
        } while (opcao != 0);
    }

    private static void animal() {
        int opcao;
        Scanner sc = new Scanner(System.in);
        do {
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    opcao = 0;
                    break;
            }
        } while (opcao != 0);
    }

    private static void funcionario() {
        int opcao;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("\n-------------------\n\n" +
                    "1 - Cadastrar funcionario\n" +
                    "2 - Trocar turno\n" +
                    "\n-------------------\n");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de funcionario: ");
                    System.out.print("Nome do funcionario: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Turno do funcionario: ");
                    String turno = sc.nextLine();

                    Dados.funcionarios.add(new Funcionario(name, turno));
                    break;
                case 2:
                    break;
                default:
                    opcao = 0;
                    break;
            }
        } while (opcao != 0);
    }

    private static void servico(Agenda agenda) throws ParseException {
        int opcao;
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
        do {
            System.out.println("\n-------------------\n\n" +
                    "1 - Adicionar servico\n" +
                    "2 - Remover servico\n" +
                    "0 - Voltar para o menu\n" +
                    "\n-------------------\n");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    if (!Dados.funcionarios.isEmpty()) {
                        System.out.println("Cadastro de servico: ");

                        System.out.print("Nome do Animal: ");
                        sc.nextLine();
                        String nomeAnimal = sc.nextLine();
                        System.out.print("Idade do Animal:");
                        int idadeAnimal = sc.nextInt();
                        System.out.print("Peso do Animal:");
                        double pesoAnimal = sc.nextDouble();
                        System.out.print("Esta vacinado? ");
                        boolean vacinado = false;
                        sc.nextLine();
                        if (sc.next().equals("sim")) {
                            vacinado = true;
                        }

                        System.out.print("Cor do Animal:");
                        sc.nextLine();
                        String corAnimal = sc.nextLine();
                        System.out.print("Raca:");
                        String raca = sc.nextLine();

                        System.out.print("Nome do funcionario responsavel: ");
                        String nomeFuncionario = sc.nextLine();
                        System.out.print("Status do Serviço: ");
                        String statusServico = sc.nextLine();
                        StatusServico status = StatusServico.valueOf(statusServico);
                        System.out.print("Data: ");
                        Date data = sdt.parse(sc.nextLine());

                        System.out.print("Nome do cliente: ");
                        String nomeCliente = sc.nextLine();

                        System.out.println("tipo de servico: ");
                        System.out.println("\n-------------------\n\n" +
                                "1 - Luxo\n" +
                                "2 - Padrao\n" +
                                "\n-------------------\n");
                        int opcaoServico = sc.nextInt();

                        List<Cliente> lClientes = agenda.getClientes();
                        Cliente c = null;

                        for (int i = agenda.getClientes().size() - 1; i >= 0; i--) {
                            if (lClientes.get(i).getNome().equals(nomeCliente)) {
                                c = lClientes.get(i);
                                break;
                            }
                        }

                        Funcionario f = null;
                        List<Funcionario> lFuncionarios = Dados.funcionarios;
                        for (int i = Dados.funcionarios.size() - 1; i >= 0; i--) {
                            if (lFuncionarios.get(i).getNome().equals(nomeFuncionario)) {
                                f = lFuncionarios.get(i);
                            }
                        }

                        if (opcaoServico == 1) {
                            System.out.print("Possiu transporte: ");
                            boolean transporte = false;
                            if (sc.next().equals("sim")) {
                                transporte = true;
                            }
                            Servico servico = new Luxo(
                                    new Cachorro(nomeAnimal, idadeAnimal, pesoAnimal, vacinado, corAnimal, raca), f,
                                    status, transporte, data);

                            c.agendarServico(servico);
                            System.out.println(servico);

                        } else {
                            System.out.println("Não ha funcionarios cadastrados");
                        }
                    }
                    break;
                case 2:
                    break;
                default:
                    opcao = 0;
                    break;
            }
        } while (opcao != 0);
    }

    private static void cliente(Agenda agenda) {
        int opcao;
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("\n----------------------\n\n" +
                    "1 - Adicionar cliente\n" +
                    "2 - Remover cliente\n" +
                    "0 - Voltar para o menu\n" +
                    "\n----------------------\n");

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Add cliente: ");
                    System.out.print("Nome do cliente: ");
                    sc.nextLine();
                    String nomeAdicionar = sc.nextLine();
                    System.out.print("Email do cliente: ");
                    String email = sc.nextLine();
                    System.out.print("Telefone do cliente:");
                    int telefone = sc.nextInt();

                    Cliente cliente = new Cliente(nomeAdicionar, telefone, email);
                    agenda.addCliente(cliente);

                    System.out.println("\nCliente adicionado\n");

                    opcao = 99;
                    break;
                case 2:
                    System.out.println("Digite o nome do cliente que deseja remover: ");
                    sc.nextLine();
                    String nomeRemover = sc.nextLine();
                    agenda.removerCliente(nomeRemover);
                    opcao = 99;
                    break;
                case 0:
                    System.out.println("\nVoltando ao menu!\n");
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }
}