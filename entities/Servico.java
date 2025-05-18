import java.util.Date;
import enums.StatusServico;

public class Servico {

    private Animal animal;
    private Funcionario responsavel;
    private double precoBase = 100.00;
    private int servicosAdd = 0;
    private StatusServico status;
    private Date data;

    public Servico(Animal animal, Funcionario responsavel, double precoBase, StatusServico status, Date data) {
        this.animal = animal;
        this.responsavel = responsavel;
        this.precoBase = precoBase;
        this.status = status;
        this.data = data;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public StatusServico getStatus() {
        return status;
    }

    public void setStatus(StatusServico status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void alterarData(Date date){
        setData(date);
    }

    public void alterarPrecoBase(double precoNovo){
        setPrecoBase(precoNovo);
    }

    public void vacinar(){
        animal.setVacinado(true);
        servicosAdd++;
    }

    public void mudarStatus(StatusServico status){
        setStatus(status);
    }

    public double calcularPrecoFinal() {
        return precoBase + (15*servicosAdd);
    }
}