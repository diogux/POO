package aula08;

public class Legume extends Alimento implements Vegetariana {
    private String nome;

    public Legume(String nome, double peso, double calorias, double proteinas) {
        super(peso, calorias, proteinas);
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String toString(){
        return String.format("Legume: %s, %s", nome, super.toString());
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 97 * hash + (this.nome != null ? this.nome.hashCode() : 0);
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
        final Legume other = (Legume) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)){
            return false;
        }
        return true;
    }
    
    @Override 
    public boolean isVegetariana(){
        return true;
    }

}
