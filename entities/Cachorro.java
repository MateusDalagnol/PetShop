public class Cachorro extends Animal {
    
    private String raca;
    
    public Cachorro(String nome, int idade, double peso, boolean vacinado, String cor, String raca) {
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
}