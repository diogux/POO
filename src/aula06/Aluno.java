package aula06;
import utils.DateYMD;

public class Aluno extends Pessoa {
    private DateYMD joinDate;
    private int nMec;
    private static int nextNMec = 100;

    public Aluno(String name, int cc, DateYMD birthDate, DateYMD joinDate) {
        super(name, cc,birthDate);
        this.joinDate = joinDate;
        this.nMec = nextNMec++;
    }

    public Aluno(String name, int cc, DateYMD birthDate) {
        super(name, cc,birthDate);
        this.joinDate = DateYMD.today();
        this.nMec = nextNMec++;

    }

    public int getNMec() {
        return nMec;
    }

    public DateYMD getJoinDate() {
        return joinDate;
    }

    public String getName() {
        return super.getName();
    }

    public int getCc() {
        return super.getCc();
    }

    public DateYMD getBirthDate() {
        return super.getBirthDate();
    }
    
    @Override
    public String toString() {
        return String.format("Nome: %s; CC: %d; nMec: %d; Data de nascimento: %s; Data de inscrição: %s", getName(), getCc(), nMec, getBirthDate().toString(), joinDate.toString());
    }
}