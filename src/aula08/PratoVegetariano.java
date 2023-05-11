package aula08;

public class PratoVegetariano extends Prato {

    public PratoVegetariano(String nome) {
        super(nome);
    }

    @Override
    public boolean addIngrediente(Alimento a) {
        if (a instanceof Carne) {
            return false;
        } else {
            return super.addIngrediente(a);
        }
    }

    @Override
    public String toString() {
        if (super.getDia() != null)
        return String.format("Prato %s, composto por %d ingredientes - Vegetariano, dia %s", super.getNome(), super.getComposicao().size(), super.getDia());
        else{
            return String.format("Prato %s, composto por %d ingredientes - Vegetariano", super.getNome(), super.getComposicao().size());
        }
    }

    
}
