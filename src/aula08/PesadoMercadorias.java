package aula08;

public class PesadoMercadorias extends Veiculo {
    private String nQuadro;
    private double peso;
    private double cargaMax;

    public PesadoMercadorias(String matricula, String marca, String modelo, int potencia, String nQuadro, double peso, double cargaMax) {
        super(matricula, marca, modelo, potencia);
        if (validNQuadro(nQuadro)) {
            this.nQuadro = nQuadro;
        }
        if (peso > 0) {
            this.peso = peso;
        } else{ this.peso = 0;}
        if (cargaMax > 0) {
            this.cargaMax = cargaMax;
    } else{ this.cargaMax = 0;}
    }

    public String getnQuadro() {
        return nQuadro;
    }

    public double getPeso() {
        return peso;
    }

    public double getCargaMax() {
        return cargaMax;
    }

    @Override
    public String toString() {
        String nQuadro = this.getnQuadro();
        if (this.getnQuadro() == null) {nQuadro = "Inválido";}
        return "Pesado de Mercadorias" + super.toString() + "\n    Número de Quadro: " + nQuadro + "\n    Peso: " + this.getPeso() + "\n    Carga Máxima: " + this.getCargaMax();
     }
}
