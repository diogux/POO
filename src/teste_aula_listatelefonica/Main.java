package teste_aula_listatelefonica;
import utils.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Contact contact9 = new Contact("diogu","967229806","dio@di", LocalDate.of(1999, 12, 12)); 
        contactManager.addContact(contact9);

        int option = -1;

        while(option != 0){
            System.out.println("----- Menu -----");
            System.out.println("1 - Add contact");
            System.out.println("2 - Update contact");
            System.out.println("3 - Remove contact");
            System.out.println("4 - Search contact by Name");
            System.out.println("5 - Search by number");
            System.out.println("6 - Search by email");
            System.out.println("7 - List all contacts");
            System.out.println("8 - List contacts orderd by name");
            System.out.println("9 - List contacts orderd by number");
            System.out.println("10 - List contacts orderd by email");
            System.out.println("11 - List contacts orderd by birthdate");
            System.out.println("0 - Exit");


            option = UserInput.intInRange("Option: ", 0, 11);
            System.out.println();
        
            switch (option) {
                case 1:
                    Contact contact = createContact();
                    contactManager.addContact(contact);
                    break;
                case 2:
                    int option2 = -1;    
                    System.out.println("Which contact do you want to update?");
                    String number;
                    do {
                        number = UserInput.newString("Number: ");
                    } while (!number.matches("\\d{9}"));
                    Contact contact1 = contactManager.searchContactByNumber(number);
                    if (contact1 == null) {
                        System.out.println("Contact not found.");
                        break;
                    }

                    while (option2 != 0){
                        System.out.println("Update contact by:");
                        System.out.println("1 - Name");
                        System.out.println("2 - Number");
                        System.out.println("3 - Email");
                        System.out.println("4 - Birthdate");
                        System.out.println("0 - Exit");

                        option2 = UserInput.intInRange("Option: ", 0, 4);
                        System.out.println();

                        switch (option2){
                            case 1:
                                String name = UserInput.newString("Name: ");
                                contact1.setName(name);
                                break;
                            case 2:
                                String number2;
                                do {
                                    number2 = UserInput.newString("Number: ");
                                } while (!number2.matches("\\d{9}"));
                                contact1.setNumber(number2);
                                contactManager.updateMap(contact9, number);
                                break;
                            case 3:
                                String email;
                                do {
                                    email = UserInput.newString("Email: ");
                                } while (!email.matches(".*@.*"));
                                contact1.setEmail(email);
                                break;
                            case 4:
                                String birthDateStr;
                                int day;
                                int month;
                                int year;
                                do {
                                    birthDateStr = UserInput.newString("Birthdate (yyyy-mm-dd): ");
                                    String[] birthDateStrArr = birthDateStr.split("-");
                                    day = Integer.parseInt(birthDateStrArr[2]);
                                    month = Integer.parseInt(birthDateStrArr[1]);
                                    year = Integer.parseInt(birthDateStrArr[0]);
                                } while (!birthDateStr.matches("\\d{4}-\\d{2}-\\d{2}") && day < 0 && day > 31 && month < 0 && month > 12 && year < 0 );
                                birthDateStr = birthDateStr.replace("-", "");
                                LocalDate birthDate = LocalDate.parse(birthDateStr);
                                contact1.setBirthDate(birthDate);
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Which contact do you want to remove?");
                    String number3;
                    do {
                        number3 = UserInput.newString("Number: ");
                    } while (!number3.matches("\\d{9}"));
                    Contact contact2 = contactManager.searchContact(number3);
                    contactManager.removeContact(contact2);
                    break;
                case 4:
                    String name = UserInput.newString("Name: ");
                    Contact contact3 = contactManager.searchContact(name);
                    if (contact3 == null) {
                        System.out.println("Contact not found!");
                    } else{System.out.println(contact3);}
                    break;
                case 5:
                    String number4; 
                do {
                    number4 = UserInput.newString("Number: ");
                    } while(!number4.matches("\\d{9}") && number4 == null);
                    Contact contact4 = contactManager.searchContactByNumber(number4);
                    if (contact4 == null) {
                        System.out.println("Contact not found!");
                    } else{System.out.println(contact4);}
                    break;
                case 6:
                    String email;
                    do {
                        email = UserInput.newString("Email: ");
                    } while (!email.matches(".*@.*") || email == null);
                    Contact contact5 = contactManager.searchContact(email);
                    if (contact5 == null) {
                        System.out.println("Contact not found!");
                    } else{System.out.println(contact5);}
                    break;
                case 7:
                    contactManager.listContacts();
                    break;
                case 8: 
                    contactManager.listContactsOrderedByName();
                    break;
                case 9:
                    contactManager.listContactsOrderedByNumber();
                    break;
                case 10:
                    contactManager.listContactsOrderedByEmail();
                    break;
                case 11:
                    contactManager.listContactsOrderedByBirthDate();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            
                }
                System.out.println();
        }

}

    public static Contact createContact() {
        String name = UserInput.newString("Name: ");
        String number;

        do {
            number = UserInput.newString("Number: ");
        } while (!number.matches("\\d{9}"));
        String email;
        String birthDateStr;
        int day;
        int month;
        int year;
        do {
            email = UserInput.newString("Email: ");
        } while (!email.matches(".*@.*") || email == null);
        do { 
            birthDateStr = UserInput.newString("Birthdate (yyyy-mm-dd): ");
            String[] birthDateStrArr = birthDateStr.split("-");
            day = Integer.parseInt(birthDateStrArr[2]);
            month = Integer.parseInt(birthDateStrArr[1]);
            year = Integer.parseInt(birthDateStrArr[0]);
        } while (!birthDateStr.matches("\\d{4}-\\d{2}-\\d{2}") || birthDateStr == null || day < 0 || day > 31 || month < 0 || month > 12 || year < 0);

        LocalDate birthDate = LocalDate.parse(birthDateStr);
        Contact contact = new Contact(name, number, email, birthDate);
        return contact;
    }



}
