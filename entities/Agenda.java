import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Cliente> clientes;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Agenda() {
        this.clientes = new ArrayList<>();
    };

    public Agenda(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
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

    public void exibirAgenda(){
        System.out.println("Clientes agendados: ");
        for (Cliente cliente : clientes) {
            System.out.println("\nNome do cliente: " + cliente.getNome());
            List<Servico> lServicos = cliente.getServicosAgendados();
            for (Servico servico : lServicos) {
                System.out.println("\n    Nome animal: " + servico.getAnimal().getNome() + "\n    Data: " + sdf.format(servico.getData()));
            }
            
        }
    }

}
