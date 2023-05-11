package aula08;

public class Taxi extends AutomovelLigeiro {
    private int nLicensa;

    public Taxi(String matricula, String marca, String modelo, int potencia, String nQuadro, int capBagageira, int nLicensa) {
        super(matricula, marca, modelo, potencia, nQuadro, capBagageira);
        if (nLicensa > 0) {
            this.nLicensa = nLicensa;
        }
    }

    public int getNLicenca() {
        return nLicensa;
    }

    @Override
    public String toString() {
        return "Táxi:" + "\n" + super.toString() + "\n    Número de Licença: " + this.getNLicenca();
    }
}
