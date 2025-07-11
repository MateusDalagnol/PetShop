
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import enums.StatusServico;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        Agenda agenda = new Agenda();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        char opcao;
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
            opcao = sc.next().charAt(0);
            switch (opcao) {
                case '1':
                    cliente(agenda, sc);
                    break;
                case '2':
                    servico(agenda, sc);
                    break;
                case '3':
                    funcionario(sc);
                    break;
                case '4':
                    exibir(agenda, sc, sdf);
                    break;
                case '0':
                    System.out.println("\nEncerrando programa!");
                default:
                    break;
            }
        } while (opcao != '0');

        sc.close();
    }

    private static void exibir(Agenda agenda, Scanner sc, SimpleDateFormat sdf) {
        char opcao;
        do {

            System.out.println("\n----------------------\n\n" +
                    "1 - Exibir agenda\n" +
                    "2 - Exibir Servico\n" +
                    "3 - Exibir cliente\n" +
                    "4 - Exibir funcionario\n" +
                    "5 - Exibir todos os funcionarios\n" +
                    "6 - Exibir animal\n" +
                    "0 - Voltar ao menu\n" +
                    "\n----------------------\n");

            System.out.print("Escolha uma opção: ");
            opcao = sc.next().charAt(0);

            switch (opcao) {
                case '1': {
                    agenda.exibirAgenda();
                    break;
                }
                case '2': {
                    sc.nextLine();
                    Cliente cliente = informarCliente(sc, agenda);
                    Servico servico = informarServico(sc, agenda, sdf, cliente);
                    if (servico == null) {
                        System.out.println("Este serviço nao existe!");
                        break;
                    }
                    cliente.exibirServicoUnitario(servico);
                    break;
                }
                case '3': {
                    sc.nextLine();
                    Cliente cliente = informarCliente(sc, agenda);
                    if (cliente == null) {
                        System.out.println("Este cliente nao existe!");
                        break;
                    }
                    cliente.exibirServico();
                    break;
                }
                case '4': {
                    sc.nextLine();
                    System.out.print("\nNome do funcionario: ");
                    String nomeFuncionario = sc.nextLine();
                    Funcionario funcionario = buscarFuncionario(nomeFuncionario, Dados.funcionarios);
                    if (funcionario == null) {
                        System.out.println("Funcionario nao existente!");
                        break;
                    }
                    Dados.exibirFuncionarioUnitario(funcionario);
                    break;
                }
                case '5': {
                    if (Dados.funcionarios.isEmpty()) {
                        System.out.println("Não ha funcionarios!");
                        break;
                    }
                    Dados.exibirFuncionarios();
                    break;
                }
                case '6': {
                    sc.nextLine();
                    Cliente cliente = informarCliente(sc, agenda);
                    Servico servico = informarServico(sc, agenda, sdf, cliente);
                    if (servico == null) {
                        System.out.println("Este serviço nao existe!");
                        break;
                    } else if (servico.getAnimal() == null) {
                        System.out.println("Este animal nao existe!");
                    }
                    System.out.println(servico.getAnimal().toString());
                    break;
                }
                case '0':
                    System.out.println("\nVoltando ao menu!\n");
                    break;
                default:
                    System.out.println("\nOpção invalida!\n");
                    break;
            }
        } while (opcao != '0');

    }

    private static void funcionario(Scanner sc) {
        char opcao;
        do {

            System.out.println("\n-------------------\n\n" +
                    "1 - Cadastrar funcionario\n" +
                    "2 - Trocar turno\n" +
                    "0 - Voltar para o menu\n" +
                    "\n-------------------\n");
            opcao = sc.next().charAt(0);

            switch (opcao) {
                case '1':
                    System.out.println("\nCadastro de funcionario: \n");
                    System.out.print("Nome do funcionario: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Turno do funcionario: ");
                    String turno = sc.nextLine();

                    Dados.funcionarios.add(new Funcionario(name, turno));
                    break;
                case '2':
                    System.out.print("Nome do funcionario: ");
                    String nomeFuncionario = sc.nextLine();
                    System.out.print("Digite o novo turno: ");
                    String novoTurno = sc.nextLine();
                    Funcionario f = buscarFuncionario(nomeFuncionario, Dados.funcionarios);
                    f.trocarTurno(novoTurno);
                    break;
                default:
                    System.out.println("\nOpção invalida!\n");
                    break;
            }
        } while (opcao != '0');
    }

    private static void servico(Agenda agenda, Scanner sc) {
        char opcao = 99;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        do {
            try {
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
                opcao = sc.next().charAt(0);

                switch (opcao) {
                    case '1':
                        if (!Dados.funcionarios.isEmpty() && !agenda.getClientes().isEmpty()) {

                            char opcaoAnimal = 99;
                            while (opcaoAnimal != '1' && opcaoAnimal != '2' && opcaoAnimal != '3') {
                                System.out.println("\n----------------\n\n" +
                                        "Cadastro de servico: \n" +
                                        "1 - Cachorro\n" +
                                        "2 - Gato\n" +
                                        "3 - Animal Generico\n" +
                                        "\n----------------\n");
                                System.out.print("Escolha uma opção: ");
                                opcaoAnimal = sc.next().charAt(0);
                            }

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
                            String nomeFuncionario;
                            do {
                                System.out.print("Nome do funcionario responsavel: ");
                                nomeFuncionario = sc.nextLine();
                                if (buscarFuncionario(nomeFuncionario, Dados.funcionarios) == null) {
                                    System.out.println("Este funcionario nao existe!\n");
                                }
                            } while (buscarFuncionario(nomeFuncionario, Dados.funcionarios) == null);
                            System.out.print("Data: ");
                            Date data = sdf.parse(sc.nextLine());
                            String nomeCliente;
                            do {
                                System.out.print("Nome do cliente: ");
                                nomeCliente = sc.nextLine();
                                if (buscarCliente(nomeCliente, agenda.getClientes()) == null) {
                                    System.out.println("Este cliente nao existe!\n");
                                }
                            } while (buscarCliente(nomeCliente, agenda.getClientes()) == null);

                            System.out.println("tipo de servico: ");
                            System.out.println("\n-------------------\n\n" +
                                    "1 - Luxo\n" +
                                    "2 - Padrao\n" +
                                    "\n-------------------\n");

                            System.out.print("Escolha uma opção: ");
                            char opcaoServico = sc.next().charAt(0);

                            Cliente c = buscarCliente(nomeCliente, agenda.getClientes());

                            Funcionario f = buscarFuncionario(nomeFuncionario, Dados.funcionarios);

                            if (opcaoServico == '1') {
                                Servico servico;
                                String raca;
                                System.out.print("Possiu transporte: ");
                                boolean transporte = false;
                                if (sc.next().equals("sim")) {
                                    transporte = true;
                                }

                                StatusServico status = StatusServico.AGENDADO;
                                switch (opcaoAnimal) {
                                    case '1': {

                                        System.out.print("Raca:");
                                        sc.nextLine();
                                        raca = sc.nextLine();
                                        servico = new Luxo(
                                                new Cachorro(nomeAnimal, idadeAnimal, pesoAnimal, vacinado, corAnimal,
                                                        raca),
                                                f,
                                                status, transporte, data);

                                        c.agendarServico(servico);
                                        break;
                                    }
                                    case '2': {
                                        System.out.print("Raca:");
                                        sc.nextLine();
                                        raca = sc.nextLine();
                                        servico = new Luxo(
                                                new Gato(nomeAnimal, idadeAnimal, pesoAnimal, vacinado, corAnimal,
                                                        raca),
                                                f,
                                                status, transporte, data);

                                        c.agendarServico(servico);
                                        break;
                                    }
                                    case '3': {
                                        System.out.print("Especie:");
                                        sc.nextLine();
                                        String especie = sc.nextLine();
                                        System.out.println();
                                        servico = new Luxo(
                                                new AnimalExotico(nomeAnimal, idadeAnimal, pesoAnimal, vacinado,
                                                        corAnimal,
                                                        especie),
                                                f,
                                                status, transporte, data);

                                        c.agendarServico(servico);
                                        break;
                                    }
                                    default:
                                        System.out.println("Opções invalidas!");
                                        break;
                                }
                            } else if (opcaoServico == '2') {
                                Servico servico;
                                String raca;

                                StatusServico status = StatusServico.AGENDADO;
                                switch (opcaoAnimal) {
                                    case '1':
                                        System.out.print("Raca:");
                                        sc.nextLine();
                                        raca = sc.nextLine();
                                        servico = new Padrao(
                                                new Cachorro(nomeAnimal, idadeAnimal, pesoAnimal, vacinado, corAnimal,
                                                        raca),
                                                f,
                                                status, data);

                                        c.agendarServico(servico);
                                        break;
                                    case '2':
                                        System.out.print("Raca:");
                                        sc.nextLine();
                                        raca = sc.nextLine();
                                        servico = new Padrao(
                                                new Gato(nomeAnimal, idadeAnimal, pesoAnimal, vacinado, corAnimal,
                                                        raca),
                                                f,
                                                status, data);

                                        c.agendarServico(servico);
                                        break;
                                    case '3':
                                        System.out.print("Especie:");
                                        sc.nextLine();
                                        String especie = sc.nextLine();
                                        System.out.println();
                                        servico = new Padrao(
                                                new AnimalExotico(nomeAnimal, idadeAnimal, pesoAnimal, vacinado,
                                                        corAnimal,
                                                        especie),
                                                f,
                                                status, data);

                                        c.agendarServico(servico);
                                    default:
                                        System.out.println("Opções invalidas!");
                                        break;
                                }

                            }
                        } else {
                            System.out.println("\nNão ha funcionarios cadastrados ou clientes cadastrados");
                            System.out.println("Cadastre um funcionario ou um cliente primeiro!\n");
                        }
                        break;
                    case '2':
                        System.out.println("Qual servico deseja remover? ");
                        sc.nextLine();
                        System.out.print("Nome do cliente: ");
                        String nomeCliente = sc.nextLine();
                        System.out.print("Nome do Animal: ");
                        String nomeAnimal = sc.nextLine();
                        System.out.print("Data do servico: ");
                        Date data = sdf.parse(sc.next());

                        Cliente c = buscarCliente(nomeCliente, agenda.getClientes());

                        Servico s = buscarServico(nomeAnimal, data, c.getServicosAgendados());

                        if (c != null && s != null) {
                            System.out.println("achou");
                            c.removerServico(s);
                        }
                        break;
                    case '3': {
                        System.out.println("Qual servico deseja alterar a data? ");
                        sc.nextLine();
                        Cliente cliente = informarCliente(sc, agenda);
                        Servico servico = informarServico(sc, agenda, sdf, cliente);

                        if (cliente != null && servico != null) {
                            String novaData = sc.next();
                            servico.alterarData(sdf.parse(novaData));
                        }
                        break;
                    }
                    case '4': {
                        System.out.println("Qual servico deseja alterar o status? ");
                        sc.nextLine();
                        Cliente cliente = informarCliente(sc, agenda);
                        Servico servico = informarServico(sc, agenda, sdf, cliente);

                        if (cliente != null && servico != null) {
                            System.out.println("Novo status: \n" +
                                    "\nAGENDADO\n" +
                                    "EM_ANDAMENTO\n" +
                                    "CONCLIUDO\n" +
                                    "CANCELADO\n");

                            StatusServico novoStatusServico = StatusServico.valueOf(sc.next());
                            servico.mudarStatus(novoStatusServico);
                        }
                        break;
                    }
                    case '5': {
                        System.out.println("Vacinar animal: ");
                        sc.nextLine();
                        Cliente cliente = informarCliente(sc, agenda);
                        Servico servico = informarServico(sc, agenda, sdf, cliente);

                        if (cliente != null && servico != null) {
                            servico.vacinar();
                        }
                        break;
                    }
                    case '6': {
                        System.out.println("Novo preco base");
                        double novoPreco = sc.nextDouble();
                        Servico.alterarPrecoBase(novoPreco);
                        break;
                    }
                    case '7': {
                        System.out.println("\nPreco final");
                        System.out.println("Qual servico deseja consultar o preco final? ");
                        sc.nextLine();
                        Cliente cliente = informarCliente(sc, agenda);
                        Servico servico = informarServico(sc, agenda, sdf, cliente);

                        System.out.println("Preco final: " + servico.calcularPrecoFinal() +
                                "\nservicos adicionais: " + servico.getServicosAdd());
                        break;
                    }
                    case '8': {
                        System.out.print("Digite o novo preco transporte - PACOTE LUXO: ");
                        double novoPreco = sc.nextDouble();
                        Luxo.alterarPrecoTransporte(novoPreco);
                        break;
                    }
                    case '9': {
                        System.out.print("Digite o novo preco adicional - PACOTE LUXO: ");
                        Double novoPreco = sc.nextDouble();
                        Luxo.alterarPrecoAdd(novoPreco);
                        break;
                    }
                    case '0':
                        System.out.println("\nVoltando ao menu!\n");
                        break;
                    default:
                        System.out.println("\nOpção invalida!\n");
                        break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\nO objeto de vc tentou acessar nao existe!");
                opcao = 99;
            } catch (NullPointerException e) {
                System.out.println("\nO objeto de vc tentou acessar nao existe!");
                opcao = 99;
            } catch (InputMismatchException e) {
                System.out.println("Erro: entrada inválida. Por favor, digite a entrada corretamente!");
            } catch(ParseException e){
                 System.out.println("Erro ao ler a data. Formato correto: dd/MM/yyyy");
            }catch (Exception e){
                System.err.println("Erro: insesperado!");
            }
        } while (opcao != '0');

    }

    private static void cliente(Agenda agenda, Scanner sc) {
        char opcao;
        do {

            System.out.println("\n----------------------\n\n" +
                    "1 - Adicionar cliente\n" +
                    "2 - Remover cliente\n" +
                    "0 - Voltar para o menu\n" +
                    "\n----------------------\n");

            System.out.print("Escolha uma opção: ");
            opcao = sc.next().charAt(0);
            switch (opcao) {
                case '1':
                    System.out.println("\nAdd cliente: ");
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
                    break;
                case '2':
                    System.out.print("\nDigite o nome do cliente que deseja remover: ");
                    sc.nextLine();
                    String nomeRemover = sc.nextLine();
                    agenda.removerCliente(nomeRemover);
                    break;
                case '0':
                    System.out.println("\nVoltando ao menu!\n");
                    break;
                default:
                    System.out.println("\nOpção invalida!\n");
                    break;
            }
        } while (opcao != '0');
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
        System.out.print("\nNome do cliente: ");
        String nomeCliente = sc.nextLine();

        return buscarCliente(nomeCliente, agenda.getClientes());

    }

    private static Servico informarServico(Scanner sc, Agenda agenda, SimpleDateFormat sdt, Cliente cliente)
         {
        System.out.print("\nNome do Animal: ");
        try {
            String nomeAnimal = sc.nextLine();
            System.out.print("Data do servico: ");
            Date data = sdt.parse(sc.next());

            return buscarServico(nomeAnimal, data, cliente.getServicosAgendados());
        } catch (NullPointerException e) {
            System.out.println("Este clinte nao existe!");
            return null;
        } catch(ParseException e){
             System.out.println("Erro ao ler a data. Formato correto: dd/MM/yyyy");
             return null;
        }
    }

}