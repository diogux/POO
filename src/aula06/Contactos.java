package aula06;

public class Contactos{
    private Pessoa person;
    private int id;
    private String phone;
    private String email;
    private static int idCounter = 1;

    public Contactos(Pessoa pessoa, String phone, String email) {
        if (pessoa == null)
            throw new IllegalArgumentException("A pessoa não pode ser nula.");

        if (phone == null && email == null)
            throw new IllegalArgumentException("O email e número do telemóvel não podem ser os dois nulos.");

        if (phone != null && !ValidatePhone(phone))
            throw new IllegalArgumentException("O número de telemóvel tem de conter 9 digitos e começar por 9.");

        if (email != null && !ValidateEmail(email))
            throw new IllegalArgumentException("O email nao é válido.");
        this.person = pessoa;
        this.phone = phone;
        this.email = email;
        this.id = idCounter++;
    }

    

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPerson(Pessoa person) {
        this.person = person;
    }

    public Pessoa getPerson() {
        return person;
    }

    public void setPhone(String phone) {
        if (!ValidatePhone(phone)) {
            throw new IllegalArgumentException("O número de telefone não é válido.");
        }

        this.phone = phone;
    }

    public void setEmail(String email) {
        if (!ValidateEmail(email)) {
            throw new IllegalArgumentException("O endereço de email não é válido.");
        }
        this.email = email;
    }

    public boolean ValidatePhone(String phone) {
        return phone.matches("^9[0-9]{8}$");
    }

    public boolean ValidateEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    @Override
    public String toString() {
        return String.format("Contacto =>  Nome: %s, Número: %s,Id: %d Email: %s", person.getName(), phone != null ? phone : "N/A",id,email != null ? email : "N/A" );
    }
}



