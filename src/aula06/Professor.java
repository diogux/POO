package aula06;
import utils.DateYMD;

public class Professor extends Pessoa {
    private String category;
    private String department;

    public Professor(String name, int cc, DateYMD birthDate, String category, String department) {
        super(name, cc, birthDate);
        this.category = category;
        this.department = department;
    }

    public String getCategory() {
        return category;
    }

    public String getDepartment() {
        return department;
    }


    @Override
    public String toString() {
        return super.toString();  //+"; Categoria: " + getCategory() + "; Departamento: " + getDepartment();
    }
}

