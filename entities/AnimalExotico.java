public class AnimalExotico extends Animal {

    private String especie;

    public AnimalExotico(String nome, int idade, double peso, boolean vacinado, String cor, String especie) {
        super(nome, idade, peso, vacinado, cor);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public boolean precisaVacina() {
        if (isVacinado() == false) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Exotico: " +
                "\n  Especie = " + getEspecie() +
                "\n  Nome = " + getNome() +
                "\n  Idade = " + getIdade() +
                "\n  Peso = " + getPeso() +
                "\n  Vacinado = " + isVacinado() +
                "\n  Cor = " + getCor() +
                "\n";
    }
}