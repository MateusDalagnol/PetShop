import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    
    private String nome;
    private int telefone;
    private String email;
    private List<Servico> servicosAgendados = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Cliente(String nome, int telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Cliente(String nome, int telefone, String email, List<Servico> servicosAgendados) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.servicosAgendados = servicosAgendados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void exibirServico(){
        System.out.println("\nServicos Agendados: ");
        for (Servico servico : servicosAgendados) {
                System.out.println("\nNome animal: " + servico.getAnimal().getNome() + "\n    Data: " + sdf.format(servico.getData()));
            }
    }

    public void exibirServicoUnitario(Servico servico){
        System.out.println(servico.toString());
    }

    public List<Servico> getServicosAgendados() {
        return servicosAgendados;
    }

    public void agendarServico(Servico servico) {
        servicosAgendados.add(servico);
        System.out.println("Servico adicionado!");
    }

    public void removerServico(Servico servico){
        servicosAgendados.remove(servico);
        System.out.println("Serviço removido!");
    }
}
