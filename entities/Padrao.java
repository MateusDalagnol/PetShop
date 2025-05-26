import java.util.Date;
import enums.StatusServico;

public class Padrao extends Servico {

    public Padrao(Animal animal, Funcionario responsavel, StatusServico status, Date data) {
        super(animal, responsavel, status, data);

    }
    
    @Override
    public String toString() {
        return "Padrao: " +
                "\n  Animal = " + getAnimal().toString() +
                "\n  Responsavel = " + getResponsavel().toString() +
                "\n  Status = " + getStatus() +
                "\n  Data = " + getData() +
                "\n";
    }
}
