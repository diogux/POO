package aula06;

import utils.DateYMD;

public class Pessoa {
    private String name;
    private int cc;
    private DateYMD birthDate;

    public DateYMD getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateYMD birthDate) {
        this.birthDate = birthDate;
    }

    public Pessoa(String name, int cc, DateYMD birthDate) {
        this.name = name;
        this.cc = cc;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public int getCc() {
        return cc;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s; CC: %d; Data de nascimento: %s", name, cc, birthDate.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Pessoa p = (Pessoa) obj;
        return p.cc == this.cc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.cc;
        return hash;
    }

}
