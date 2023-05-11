package aula08;

public class EletricoPesadoPassageiros extends PesadoPassageiros implements VeiculoEletrico {
    private int autonomiaMax;
    private int autonomia;
    private int bateria;

    public EletricoPesadoPassageiros(String matricula, String marca, String modelo, int potencia, String nQuadro, double peso,int nPassageiros, int autonomiaMax,int bateria) {
        super(matricula, marca, modelo, potencia, nQuadro, peso, nPassageiros);
        this.autonomiaMax = autonomiaMax;
        this.bateria = bateria;
        if (bateria > 0 && bateria <= 100) {
            this.autonomia = (int) (this.autonomiaMax * (bateria / 100.0));
        } else if (bateria > 100) {
            this.autonomia = this.autonomiaMax;
        }
    }

    @Override
    public int autonomia() {
        return this.autonomia;
    }

    @Override
    public void carregar(int percentagem) {
        if (percentagem > 0 && percentagem <= 100) {
            this.autonomia = (int) (this.autonomiaMax * (percentagem / 100.0));
            this.bateria += percentagem;
        } else if (percentagem > 100) {
            this.autonomia = this.autonomiaMax;
        }
        if (this.bateria > 100) {
            this.bateria = 100;
        }
    }
    
    @Override
    public String toString() {
        return "Veículo Elétrico: \n" + super.toString() + "\n    Autonomia: " + this.autonomia + "km" + "\n    Autonomia Máxima: " + this.autonomiaMax + "km"  + "\n    Bateria: " + this.bateria + "%";
    }

}
