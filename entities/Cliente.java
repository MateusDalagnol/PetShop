import java.util.ArrayList;
import java.util.List;

public class Cliente {
    
    private String nome;
    private String telefone;
    private String email;
    private List<Servico> servicosAgendados = new ArrayList<>();

    public Cliente(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Cliente(String nome, String telefone, String email, List<Servico> servicosAgendados) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
