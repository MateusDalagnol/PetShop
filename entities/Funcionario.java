public class Funcionario {
    
    private String nome;
    private String turno;

    public Funcionario(String nome, String turno) {
        this.nome = nome;
        this.turno = turno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void trocarTurno(String novoTurno){
        setTurno(novoTurno);
    }
    
}