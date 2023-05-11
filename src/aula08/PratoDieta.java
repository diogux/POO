package aula08;

public class PratoDieta extends Prato {
    private double caloriasMax;

    public PratoDieta(String nome, double caloriasMax) {
        super(nome);
        this.caloriasMax = caloriasMax;
    }

    public double getCaloriasMax() {
        return caloriasMax;
    }

    public void setCaloriasMax(double caloriasMax) {
        this.caloriasMax = caloriasMax;
    }

    @Override
    public boolean addIngrediente(Alimento a) {
        if (a.getCalorias() > caloriasMax) {
            return false;
        } else {
            return super.addIngrediente(a);
        }
    }

    public void getCalorias() {
        double calorias = 0;
        for (Alimento a : getComposicao()) {
            calorias += a.getCalorias();
        }
        if (calorias > caloriasMax) {
            System.out.println("O prato excede as calorias máximas");
        } else {
            System.out.println("O prato não excede as calorias máximas");
        }
    }

    @Override
    public String toString() {
        if (super.getDia() != null)
        return String.format("Prato %s, composto por %d ingredientes - Dieta (%.2f Calorias), dia %s", super.getNome(), super.getComposicao().size(), caloriasMax, super.getDia());
        else{
            return String.format("Prato %s, composto por %d ingredientes - Dieta (%.2f Calorias)", super.getNome(), super.getComposicao().size(), caloriasMax);
        }
        
    }
    
}
