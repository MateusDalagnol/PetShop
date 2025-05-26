import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Cliente> clientes;

    public Agenda() {
        this.clientes = new ArrayList<>();
    };

    public Agenda(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void exibirServico(String cliente) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(cliente)) {
                System.out.println("Exibir informações cliente\n" +
                        "Nome: " + c.getNome() +
                        "\nEmail: " + c.getEmail() +
                        "\nTelefone: " + c.getTelefone());

                break;
            }
        }
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(String nomeCliente) {
        for (int i = clientes.size() - 1; i >= 0; i--) {
            if (clientes.get(i).getNome().equals(nomeCliente)) {
                clientes.remove(i);
                System.out.println("\nCliente removido!");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

}
