import java.util.ArrayList;
import java.util.List;

public class Dados {
    public static List<Funcionario> funcionarios = new ArrayList<>();

    public static void exibirFuncionarios(){
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }
    
    public static void exibirFuncionarioUnitario(Funcionario funcionario){
        System.out.println(funcionario);
    }
}
