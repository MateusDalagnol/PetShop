import java.text.SimpleDateFormat;
import java.util.Date;
import enums.StatusServico;

public class Luxo extends Servico {

    private boolean incluiTransporte;
    private static double precoAdd = 50.0;
    private static double precoTransporte = 30.00;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public Luxo(Animal animal, Funcionario responsavel, StatusServico status, boolean incluiTransporte, Date data) {
        super(animal, responsavel, status, data);
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

    public static void setPrecoAdd(double precoAdd) {
        Luxo.precoAdd = precoAdd;
    }

    public double getPrecoTransporte() {
        return precoTransporte;
    }

    public static void setPrecoTransporte(double precoTransporte) {
        Luxo.precoTransporte = precoTransporte;
    }

    public static void alterarPrecoAdd(double precoNovo) {
        setPrecoAdd(precoNovo);
    }

    public static void alterarPrecoTransporte(double precoNovo) {
        setPrecoTransporte(precoNovo);
    }

    public double calcularPrecoFinal() {
        if (incluiTransporte) {
            return getPrecoBase() + getPrecoAdd() + getPrecoTransporte() + (15*getServicosAdd());
        }
        return getPrecoAdd() + getPrecoBase() + (15*getServicosAdd());
    }

    @Override
    public String toString() {
        return "\nLuxo: " +
                "\n  Vacina = " + getAnimal().precisaVacina() +
                "\n  Transporte = " + isIncluiTransporte() +
                "\n  Animal = " + getAnimal().toString() +
                "\n  Responsavel = " + getResponsavel().toString() +
                "\n  Status = " + getStatus() +
                "\n  Data = " + sdf.format(getData()) +
                "\n";
    }

}
