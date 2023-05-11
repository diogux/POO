package aula08;

public class PesadoPassageiros extends Veiculo {
    private String nQuadro;
    private double peso;
    private int nPassageiros;

    public PesadoPassageiros(String matricula, String marca, String modelo, int potencia, String nQuadro, double peso, int nPassageiros) {
        super(matricula, marca, modelo, potencia);
        if (validNQuadro(nQuadro)) {
            this.nQuadro = nQuadro;
        }
        this.peso = peso;
        this.nPassageiros = nPassageiros;
    }

    public String getNQuadro() {
        return nQuadro;
    }

    public double getPeso() {
        return peso;
    }

    public int getNPassageiros() {
        return nPassageiros;
    }

    @Override
    public String toString() {
        String nQuadro = this.getNQuadro();
        if (this.getNQuadro() == null) {nQuadro = "Inválido";}
        return "Pesado de Passageiros\n" + super.toString() + "\n    Número de Quadro: " + nQuadro + "\n    Peso: " + this.getPeso() + "\n    Número de Passageiros: " + this.getNPassageiros();
    }
}
