package aula08;

public class AutomovelLigeiro extends Veiculo {
    private String nQuadro;
    private int capBagageira;

    public AutomovelLigeiro(String matricula, String marca, String modelo, int potencia, String  nQuadro, int capBagageira) {
        super(matricula, marca, modelo, potencia);
        if (validNQuadro(nQuadro)) {
            this.nQuadro = nQuadro;
        }
        this.capBagageira = capBagageira;
    }

    public String getNQuadro() {
        return nQuadro;
    }

    public int getCapBagageira() {
        return capBagageira;
    }

    @Override
    public String toString() {
        return String.format("Automóvel Ligeiro:\n    %s\n    Nº Quadro: %s\n    Capacidade Bagageira: %d",
        super.toString(), this.getNQuadro() != null ? this.getNQuadro() : "Inválido", this.getCapBagageira());

    }
}
