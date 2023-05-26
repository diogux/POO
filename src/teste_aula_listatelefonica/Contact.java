package teste_aula_listatelefonica;
import java.time.LocalDate;

public class Contact {
    private int id;
    private static int counter = 1;
    private String name;
    private int number;
    private String email;
    private LocalDate birthDate; 

    public Contact(String name, int number, String email, LocalDate birthDate){
        this.id = counter++;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getName(){return this.name;}
    public int getNumber(){return this.number;}
    public String getEmail(){return this.email;}
    public LocalDate getBirthDate(){return this.birthDate;}

    public String toString(){
        return String.format("Contact -> %s Number: %d Email: %s BirthDate: ", this.name, this.number, this.email, this.birthDate);
    }


}
