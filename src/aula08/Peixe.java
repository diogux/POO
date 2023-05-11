package aula08;

public class Peixe extends Alimento{
    private TipoPeixe tipo;

    public Peixe(TipoPeixe tipo,double peso, double calorias, double proteinas) {
        super(peso, calorias, proteinas);
        this.tipo = tipo;
    }

    public TipoPeixe getTipo(){
        return tipo;
    }

    public void setTipo(TipoPeixe tipo){
        this.tipo = tipo;
    }

    @Override 
    public String toString(){
        return String.format("Peixe: %s, %s", tipo, super.toString());
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 97 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Peixe other = (Peixe) obj;
        if (this.tipo != other.tipo){
            return false;
        }
        return true;
    }

}
