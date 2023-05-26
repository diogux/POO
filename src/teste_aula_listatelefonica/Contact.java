package teste_aula_listatelefonica;
import java.time.LocalDate;

public class Contact {
    private int id;
    private static int counter = 1;
    private String name;
    private String number;
    private String email;
    private LocalDate birthDate; 

    public Contact(String name, String number, String email, LocalDate birthDate){
        this.id = counter++;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.number = number;
    }

    public String getName(){return this.name;}
    public String getNumber(){return this.number;}
    public String getEmail(){return this.email;}
    public LocalDate getBirthDate(){return this.birthDate;}
    public void setName(String name){this.name = name;}
    public void setNumber(String number){this.number = number;}
    public void setEmail(String email){this.email = email;}
    public void setBirthDate(LocalDate birthDate){this.birthDate = birthDate;}


    public String toString(){
        String birthDate = this.birthDate == null ? "Not defined" : this.birthDate.toString();
        return String.format("Contact -> %s Number: %s Email: %s BirthDate: %s ", this.name, this.number, this.email, birthDate);
    }


    public int hashCode(){
        return this.id;
    }

    public boolean equals(Object obj){
        return this.id == ((Contact) obj).id;
    }

    public int compareTo(Contact contact){
        return this.name.compareTo(contact.name);
    }


}
