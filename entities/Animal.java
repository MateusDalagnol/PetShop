public abstract class Animal {

    private String nome;
    private String cor;
    private int idade;
    private double peso;
    private boolean vacinado;

    public Animal(String nome, int idade, double peso, boolean vacinado, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.vacinado = vacinado;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isVacinado() {
        return vacinado;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean precisaVacina(){
        return isVacinado();
    }

}
