import java.text.SimpleDateFormat;
import java.util.Date;
import enums.StatusServico;

public class Padrao extends Servico {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Padrao(Animal animal, Funcionario responsavel, StatusServico status, Date data) {
        super(animal, responsavel, status, data);

    }
    
    @Override
    public String toString() {
        return "\nPadrão: " +
                "\n  Vacina = " + getAnimal().precisaVacina() +
                "\n  Animal = " + getAnimal().toString() +
                "\n  Responsavel = " + getResponsavel().toString() +
                "\n  Status = " + getStatus() +
                "\n  Data = " + sdf.format(getData()) +
                "\n";
    }
}
