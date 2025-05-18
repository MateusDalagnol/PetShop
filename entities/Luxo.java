import java.util.Date;
import enums.StatusServico;

public class Luxo extends Servico {

    private boolean incluiTransporte;
    private double precoAdd = 50.0;
    private double precoTransporte = 30.00;

    public Luxo(Animal animal, Funcionario responsavel, double precoBase, StatusServico status, boolean incluiTransporte, Date data) {
        super(animal, responsavel, precoBase, status, data);
        this.incluiTransporte = incluiTransporte;

    }

    public boolean isIncluiTransporte() {
        return incluiTransporte;
    }

    public void setIncluiTransporte(boolean incluiTransporte) {
        this.incluiTransporte = incluiTransporte;
    }

    public double getPrecoAdd() {
        return precoAdd;
    }

    public void setPrecoAdd(double precoAdd) {
        this.precoAdd = precoAdd;
    }

    public double getPrecoTransporte() {
        return precoTransporte;
    }

    public void setPrecoTransporte(double precoTransporte) {
        this.precoTransporte = precoTransporte;
    }
    
    public void alterarPrecoAdd(double precoNovo){
        setPrecoAdd(precoNovo);
    }

    public void alterarPrecoTransporte(double precoNovo){
        setPrecoTransporte(precoNovo);
    }
    
    public double calcularPrecoFinal(){
        if(incluiTransporte){
            return getPrecoBase() + getPrecoAdd() + getPrecoTransporte();
        }
        return getPrecoAdd() + getPrecoBase();
    }
}
