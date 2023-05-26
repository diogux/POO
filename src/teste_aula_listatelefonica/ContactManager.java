package teste_aula_listatelefonica;
import java.util.TreeMap;
import java.util.Map;
import java.time.LocalDate;
import java.util.Comparator;

public class ContactManager implements ContactManagerInterface {
    Map<String , Contact> contacts = new TreeMap<>();

    @Override
    public void addContact(Contact contact)
        {contacts.put(contact.getNumber(), contact);}
    
    @Override
    public void removeContact(Contact contact){
        if (contacts.containsKey(contact.getNumber())){
            contacts.remove(contact.getNumber());
        }

    }


    @Override
    public void updateContact(Contact contact){
        if (contacts.containsKey(contact.getNumber())){
            contacts.put(contact.getNumber(), contact);
        }
    }

    public void updateMap(Contact contact, String number){
        if (contacts.containsKey(number)){
            contacts.remove(number);
            contacts.put(contact.getNumber(), contact);
        }
    }
    
    @Override   
    public void listContacts(){
        for(Contact contact : contacts.values()){
            System.out.println(contact);
        }
    }

    @Override    
    public void listContactsOrderedByName(){
        contacts.values().stream()  // Get the stream of contact values
                .sorted((c1, c2) -> c1.getName().compareTo(c2.getName()))  // Sort contacts by name
                .forEach(contact -> System.out.println(contact));  // Print each contact
    }

    @Override
    public void listContactsOrderedByEmail(){
        contacts.values().stream()  // Get the stream of contact values
                .sorted((c1, c2) -> c1.getEmail().compareTo(c2.getEmail()))  // Sort contacts by email
                .forEach(contact -> System.out.println(contact));  // Print each contact
    }
    
    @Override 
    public void listContactsOrderedByNumber(){
        contacts.values().stream()  // Get the stream of contact values
        .sorted(Comparator.comparing(Contact::getNumber))  // Sort contacts by number
        .forEach(System.out::println);  // Print each contact
    }

    @Override
    public void listContactsOrderedByBirthDate(){
        contacts.values().stream()  // Get the stream of contact values
        .sorted(Comparator.comparing(Contact::getBirthDate))  // Sort contacts by birth date
        .forEach(System.out::println);  // Print each contact
    }

    @Override
    public Contact searchContact(String name){
        for(Contact contact : contacts.values()){
            if(contact.getName().equals(name)){
                return contact;
            }
        }
        return null;
    }

    public Contact searchContactByNumber(String number){
        return contacts.get(number);
    }

    public void addContact(String name, int number, String email, LocalDate birthDate) {
    }



}
