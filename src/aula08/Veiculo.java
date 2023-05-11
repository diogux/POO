package aula08;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Veiculo implements KmPercorridosInterface {
    private String matricula;
    private String marca;
    private String modelo;
    private int potencia;
    private int kmstotal = 0;
	private int tempKms = 0;

    public Veiculo(String matricula, String marca, String modelo, int potencia) {
        if(validMatricula(matricula)) {
            this.matricula = matricula;
        }
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getpotencia() {
        return potencia;
    }

    @Override
	public void trajeto(int quilometros) {
		tempKms = quilometros;
		kmstotal += quilometros;
	}

	@Override
	public int ultimoTrajeto() {
		return tempKms;
	}

	@Override
	public int distanciaTotal() {
		return kmstotal;
	}

    @Override
    public String toString() {
        return String.format("    Matrícula: %s\n    Marca: %s\n    Modelo: %s\n    Potência: %d",
        this.getMatricula() != null ? this.getMatricula() : "Inválida", this.getMarca(), this.getModelo(), this.getpotencia());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;
        Veiculo v = (Veiculo) obj;
        return v.getMatricula().equals(this.getMatricula());
    }

    @Override
    public int hashCode() {
        return this.getMatricula().hashCode();
    }

    //validar matricula

    public static boolean validMatricula(String matricula) {
        String padrao = "^[A-Z]{2}-\\d{2}-[A-Z]{2}$";
        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(matricula);
        return matcher.matches();
    }

    public static boolean validNQuadro(String nQuadro) {
        String regex = "^[A-HJ-NPR-Z\\d]{17}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nQuadro);
        return matcher.matches();
    }




}
