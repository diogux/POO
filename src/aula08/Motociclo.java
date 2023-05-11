package aula08;

public class Motociclo extends Veiculo {
    private String tipo;

    public Motociclo(String matricula, String marca, String modelo, int potencia, String tipo) {
        super(matricula, marca, modelo, potencia);
        if (!tipo.equals("desportivo") && !tipo.equals("estrada")) throw new IllegalArgumentException("Tipo inválido.");
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Motociclo" + super.toString() ;
    }
}
