package aula06;
import utils.DateYMD;

public class Bolseiro extends Aluno {
    private Professor advisor;
    private double bolsa;
    
    public Bolseiro(String name, int cc, DateYMD birthDate, DateYMD joinDate, Professor advisor, double bolsa) {
        super(name, cc, birthDate, joinDate);
        this.bolsa = bolsa;
        this.advisor = advisor;
    }

    public Bolseiro(String name, int cc, DateYMD birthDate, Professor advisor, double bolsa) {
        super(name, cc, birthDate);
        this.bolsa = bolsa;
        this.advisor = advisor;
    }

    public Professor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Professor advisor) {
        this.advisor = advisor;
    }

    public void setBolsa(double bolsa) {
        this.bolsa = bolsa;
    }


    public double getBolsa() {
        return bolsa;
    }

    @Override
    public String toString() {
        return super.toString() + "; Bolsa: " + bolsa;
    }

}