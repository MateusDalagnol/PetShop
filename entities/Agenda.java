import java.util.ArrayList;
import java.util.List;

public class Agenda {
    
    private List<Cliente> clientes = new ArrayList<>();

    public Agenda(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void exibirServico(String cliente){
        for (Cliente c : clientes) {
            if(c.getNome().equals(cliente)){
                System.out.println("Exibir informações cliente");
                break;
            }
        }
    }

    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void removerCliente(String cliente){
        clientes.removeIf(c -> c.getNome().equals(cliente));

    }
}
