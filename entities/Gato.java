public class Gato extends Animal {

    private String raca;

    public Gato(String nome, int idade, double peso, boolean vacinado, String cor, String raca) {
        super(nome, idade, peso, vacinado, cor);
        this.raca = raca;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public boolean precisaVacina() {
        if (isVacinado() == false) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
         return "Gato" +
                "\n  Raca = " + getRaca() +
                "\n  Nome = " + getNome() +
                "\n  Idade = " + getIdade() +
                "\n  Peso = " + getPeso() +
                "\n  Vacinado = " + isVacinado() +
                "\n  Cor = " + getCor();
    }
}