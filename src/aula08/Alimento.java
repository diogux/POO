package aula08;

public class Alimento {
    private double peso;
    private double calorias;
    private double proteinas;

    public Alimento(double peso, double calorias, double proteinas) {
        this.peso = peso;
        this.calorias = calorias;
        this.proteinas = proteinas;
    }


    public double getPeso() {
        return peso;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    @Override
    public String toString() {
        return String.format("Peso: %.2f, calorias: %.2f, proteinas: %.2f", peso, calorias, proteinas);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.calorias) ^ (Double.doubleToLongBits(this.calorias) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.proteinas) ^ (Double.doubleToLongBits(this.proteinas) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alimento other = (Alimento) obj;
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (Double.doubleToLongBits(this.calorias) != Double.doubleToLongBits(other.calorias)) {
            return false;
        }
        if (Double.doubleToLongBits(this.proteinas) != Double.doubleToLongBits(other.proteinas)) {
            return false;
        }
        return true;
    }
    

}