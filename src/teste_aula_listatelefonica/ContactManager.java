package teste_aula_listatelefonica;
import java.util.TreeMap;
import java.util.Map;
import java.util.Comparator;

public class ContactManager implements ContactManagerInterface {
    Map<Integer , Contact> contacts = new TreeMap<Integer, Contact>();

    @Override
    public void addContact(Contact contact){contacts.put(contact.getNumber(), contact);}
    
    @Override
    public void removeContact(Contact contact){contacts.remove(contact.getNumber());}


    @Override
    public void updateContact(Contact contact){contacts.put(contact.getNumber(), contact);}
    
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
        .sorted(Comparator.comparingInt(Contact::getNumber))  // Sort contacts by number
        .forEach(System.out::println);  // Print each contact
    }

    @Override
    public void listContactsOrderedByBirthDate(){

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



}
