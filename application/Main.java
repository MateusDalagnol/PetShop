
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
                            "4 - Exibir\n" +
                            "0 - SAIR\n" +
                            "\n------------------\n");

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    cliente(agenda, sc);
                    break;
                case 2:
                    servico(agenda, sc);
                    break;
                case 3:
                    funcionario(sc);
                    break;
                case 4:
                    exibir(agenda, sc);
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void exibir(Agenda agenda, Scanner sc) {
        int opcao;
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

    private static void funcionario(Scanner sc) {
        int opcao;
        do {

            System.out.println("\n-------------------\n\n" +
                    "1 - Cadastrar funcionario\n" +
                    "2 - Trocar turno\n" +
                    "0 - Voltar para o menu\n" +
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
                    System.out.print("Nome do funcionario: ");
                    String nomeFuncionario = sc.nextLine();
                    System.out.print("Digite o novo turno: ");
                    String novoTurno = sc.nextLine();
                    Funcionario f = buscarFuncionario(nomeFuncionario, Dados.funcionarios);
                    f.trocarTurno(novoTurno);
                    break;
                default:
                    opcao = 0;
                    break;
            }
        } while (opcao != 0);
    }

    private static void servico(Agenda agenda, Scanner sc) throws ParseException {
        int opcao;
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
        do {
            System.out.println("\n-------------------\n\n" +
                    "1 - Adicionar servico\n" +
                    "2 - Remover servico\n" +
                    "3 - Alterar data\n" +
                    "4 - Alterar Status\n" +
                    "5 - Vacinar\n" +
                    "6 - ALterar preco base\n" +
                    "7 - Calcular preco final\n" +
                    "8 - Alterar preco transporte - PACOTE LUXO\n" +
                    "9 - ALterar preco adicional - PACOTE LUXO\n" +
                    "0 - Voltar para o menu\n" +
                    "\n-------------------\n");

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    if (!Dados.funcionarios.isEmpty()) {
                        System.out.println("Cadastro de servico: ");
                        System.out.println("\n----------------\n\n" +
                                "1 - Cachorro\n" +
                                "2 - Gato\n" +
                                "3 - Animal Generico\n" +
                                "\n----------------\n");
                        System.out.print("Escolha uma opção: ");
                        int opcaoAnimal = sc.nextInt();

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

                        System.out.print("Nome do funcionario responsavel: ");
                        String nomeFuncionario = sc.nextLine();
                        System.out.print("Data: ");
                        Date data = sdt.parse(sc.nextLine());

                        System.out.print("Nome do cliente: ");
                        String nomeCliente = sc.nextLine();

                        System.out.println("tipo de servico: ");
                        System.out.println("\n-------------------\n\n" +
                                "1 - Luxo\n" +
                                "2 - Padrao\n" +
                                "\n-------------------\n");

                        System.out.print("Escolha uma opção: ");
                        int opcaoServico = sc.nextInt();

                        Cliente c = buscarCliente(nomeCliente, agenda.getClientes());

                        Funcionario f = buscarFuncionario(nomeFuncionario, Dados.funcionarios);

                        if (opcaoServico == 1) {
                            Servico servico;
                            String raca;
                            System.out.print("Possiu transporte: ");
                            boolean transporte = false;
                            if (sc.next().equals("sim")) {
                                transporte = true;
                            }

                            StatusServico status = StatusServico.AGENDADO;
                            switch (opcaoAnimal) {
                                case 1:
                                    System.out.print("Raca:");
                                    sc.nextLine();
                                    raca = sc.nextLine();
                                    servico = new Luxo(
                                            new Cachorro(nomeAnimal, idadeAnimal, pesoAnimal, vacinado, corAnimal,
                                                    raca),
                                            f,
                                            status, transporte, data);

                                    c.agendarServico(servico);
                                    System.out.println(servico);
                                    break;
                                case 2:
                                    System.out.print("Raca:");
                                    sc.nextLine();
                                    raca = sc.nextLine();
                                    servico = new Luxo(
                                            new Gato(nomeAnimal, idadeAnimal, pesoAnimal, vacinado, corAnimal, raca), f,
                                            status, transporte, data);

                                    c.agendarServico(servico);
                                    System.out.println(servico);
                                    break;
                                case 3:
                                    System.out.print("Especie:");
                                    sc.nextLine();
                                    String especie = sc.nextLine();
                                    System.out.println();
                                    servico = new Luxo(
                                            new AnimalExotico(nomeAnimal, idadeAnimal, pesoAnimal, vacinado, corAnimal,
                                                    especie),
                                            f,
                                            status, transporte, data);

                                    c.agendarServico(servico);
                                    System.out.println(servico);
                                default:
                                    System.out.println("Opções invalidas!");
                                    break;
                            }
                        } else if (opcaoServico == 2) {
                            Servico servico;
                            String raca;

                            StatusServico status = StatusServico.AGENDADO;
                            switch (opcaoAnimal) {
                                case 1:
                                    System.out.print("Raca:");
                                    sc.nextLine();
                                    raca = sc.nextLine();
                                    servico = new Padrao(
                                            new Cachorro(nomeAnimal, idadeAnimal, pesoAnimal, vacinado, corAnimal,
                                                    raca),
                                            f,
                                            status, data);

                                    c.agendarServico(servico);
                                    System.out.println(servico);
                                    break;
                                case 2:
                                    System.out.print("Raca:");
                                    sc.nextLine();
                                    raca = sc.nextLine();
                                    servico = new Padrao(
                                            new Gato(nomeAnimal, idadeAnimal, pesoAnimal, vacinado, corAnimal, raca), f,
                                            status, data);

                                    c.agendarServico(servico);
                                    System.out.println(servico);
                                    break;
                                case 3:
                                    System.out.print("Especie:");
                                    sc.nextLine();
                                    String especie = sc.nextLine();
                                    System.out.println();
                                    servico = new Padrao(
                                            new AnimalExotico(nomeAnimal, idadeAnimal, pesoAnimal, vacinado, corAnimal,
                                                    especie),
                                            f,
                                            status, data);

                                    c.agendarServico(servico);
                                    System.out.println(servico);
                                default:
                                    System.out.println("Opções invalidas!");
                                    break;
                            }

                        }
                    } else {
                        System.out.println("\nNão ha funcionarios cadastrados");
                        System.out.println("Cadastre um funcionario primeiro!\n");
                    }
                    break;
                case 2:
                    System.out.println("Qual servico deseja remover? ");
                    sc.nextLine();
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = sc.nextLine();
                    System.out.print("Nome do Animal: ");
                    String nomeAnimal = sc.nextLine();
                    System.out.print("Data do servico: ");
                    Date data = sdt.parse(sc.next());

                    Cliente c = buscarCliente(nomeCliente, agenda.getClientes());

                    Servico s = buscarServico(nomeAnimal, data, c.getServicosAgendados());

                    if (c != null && s != null) {
                        System.out.println("achou");
                        c.removerServico(s);
                    }
                    break;
                case 3: {
                    System.out.println("Qual servico deseja alterar a data? ");
                    sc.nextLine();
                    Cliente cliente = informarCliente(sc, agenda);
                    Servico servico = informarServico(sc, agenda, sdt, cliente);

                    if (cliente != null && servico != null) {
                        String novaData = sc.next();
                        servico.alterarData(sdt.parse(novaData));
                    }
                    break;
                }
                case 4: {
                    System.out.println("Qual servico deseja alterar o status? ");
                    sc.nextLine();
                    Cliente cliente = informarCliente(sc, agenda);
                    Servico servico = informarServico(sc, agenda, sdt, cliente);


                    if (cliente != null && servico != null) {
                        System.out.println("Novo status: \n" +
                                "AGENDADO,\n" +
                                "EM_ANDAMENTO,\r\n" +
                                "CONCLIUDO,\r\n" +
                                "CANCELADO,");

                        StatusServico novoStatusServico = StatusServico.valueOf(sc.next());
                        servico.mudarStatus(novoStatusServico);
                    }
                    break;
                }
                case 5: {
                    System.out.println("Vacinar animal: ");
                    sc.nextLine();
                    Cliente cliente = informarCliente(sc, agenda);
                    Servico servico = informarServico(sc, agenda, sdt, cliente);

                    if (cliente != null && servico != null) {
                        servico.vacinar();
                    }
                    break;
                }
                case 6: {
                    System.out.println("Novo preco base");
                    double novoPreco = sc.nextDouble();
                    Servico.alterarPrecoBase(novoPreco);
                    break;
                }
                case 7: {
                    System.out.println("Preco final");
                    System.out.println("Qual servico deseja consultar o preco final? ");
                    sc.nextLine();
                    Cliente cliente = informarCliente(sc, agenda);
                    Servico servico = informarServico(sc, agenda, sdt, cliente);

                    System.out.println("Preco final: " + servico.calcularPrecoFinal() +
                            "\nservicos adicionais: " + servico.getServicosAdd());
                    break;
                }
                case 8: {
                    System.out.print("Digite o novo preco transporte - PACOTE LUXO: ");
                    double novoPreco = sc.nextDouble();
                    Luxo.alterarPrecoTransporte(novoPreco);
                    break;
                }
                case 9: {
                    System.out.print("Digite o novo preco adicional - PACOTE LUXO: ");
                    Double novoPreco = sc.nextDouble();
                    Luxo.alterarPrecoAdd(novoPreco);
                }
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (opcao != 0);
    }

    private static void cliente(Agenda agenda, Scanner sc) {
        int opcao;
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

    private static Cliente buscarCliente(String nome, List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    private static Funcionario buscarFuncionario(String nome, List<Funcionario> funcionarios) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equals(nome)) {
                return f;
            }
        }
        return null;
    }

    private static Servico buscarServico(String nomeAnimal, Date data, List<Servico> servicos) {
        for (Servico s : servicos) {
            if (s.getAnimal().getNome().equals(nomeAnimal)
                    && s.getData().equals(data)) {
                return s;
            }
        }
        return null;
    }

    private static Cliente informarCliente(Scanner sc, Agenda agenda) {
        System.out.print("Nome do cliente: ");
        String nomeCliente = sc.nextLine();

        return buscarCliente(nomeCliente, agenda.getClientes());

    }

    private static Servico informarServico(
        Scanner sc, Agenda agenda, SimpleDateFormat sdt, Cliente cliente
    ) throws ParseException {
        System.out.print("Nome do Animal: ");
        String nomeAnimal  = sc.nextLine();
        System.out.print("Data do servico: ");
        Date data = sdt.parse(sc.next());

       return buscarServico(nomeAnimal, data,cliente.getServicosAgendados());
    }

}