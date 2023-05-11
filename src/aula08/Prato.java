package aula08;
import java.util.ArrayList;

public class Prato {
    private String nome;
    private ArrayList<Alimento> composicao = new ArrayList<>();
    private DiaSemana dia;

    public Prato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Alimento> getComposicao() {
        return composicao;
    }

    public void setComposicao(ArrayList<Alimento> composicao) {
        this.composicao = composicao;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }

    public boolean addIngrediente(Alimento a){
        composicao.add(a);
        return true;
    }

    @Override
    public String toString() {
        if (dia == null)
            return String.format("Prato %s, composto por %d ingredientes",getNome() ,getComposicao().size());
        else{
            return String.format("Prato %s, composto por %d ingredientes - dia %s",getNome() ,getComposicao().size(), getDia());
        }
    }



    
}
