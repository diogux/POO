package aula08;
import java.util.ArrayList;

public class Ementa {
    private String nome;
    private String local;
    private ArrayList<Prato> pratos = new ArrayList<>();

    public Ementa(String nome, String local) {
        this.nome = nome;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }

    public boolean addPrato(Prato p, DiaSemana d){
        pratos.add(p);
        p.setDia(d);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        for (Prato p : pratos) {
            sb.append(p.toString() + "\n");
        }

        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 97 * hash + (this.local != null ? this.local.hashCode() : 0);
        hash = 97 * hash + (this.pratos != null ? this.pratos.hashCode() : 0);
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
        final Ementa other = (Ementa) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.local == null) ? (other.local != null) : !this.local.equals(other.local)) {
            return false;
        }
        if (this.pratos != other.pratos && (this.pratos == null || !this.pratos.equals(other.pratos))) {
            return false;
        }
        return true;
    }   





}
