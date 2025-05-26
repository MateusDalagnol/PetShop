import java.util.Date;
import enums.StatusServico;

public class Servico {

    private Animal animal;
    private Funcionario responsavel;
    private static double precoBase = 100.00;
    private int servicosAdd = 0;
    private StatusServico status;
    private Date data;
    

    public Servico(Animal animal, Funcionario responsavel, StatusServico status, Date data) {
        this.animal = animal;
        this.responsavel = responsavel;
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

    public static void setPrecoBase(double precoBase) {
        Servico.precoBase = precoBase;
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
        System.out.println("Data alterada!");
    }

    public static void alterarPrecoBase(double precoNovo){
        setPrecoBase(precoNovo);
        System.out.println("Preco alterado!");
    }

    public void vacinar(){
        if(!getAnimal().isVacinado()){
            animal.setVacinado(true);
            System.out.println("Vacinado!");
            servicosAdd++;
        }else{
            System.out.println("Animal ja vacinado");
        }
        
    }

    public void mudarStatus(StatusServico status){
        setStatus(status);
        System.out.println("Status alterado!");
    }

    public double calcularPrecoFinal() {
        return precoBase + (15*servicosAdd);
    }

    public int getServicosAdd() {
        return servicosAdd;
    }

}