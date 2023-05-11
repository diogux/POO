package aula06;
import utils.DateYMD;
import utils.*;
import java.util.ArrayList;

public class Teste2 {
    private static ArrayList<Contactos> Contactos = new ArrayList<>();
    public static void main(String[] args) {
        boolean validChoice = false;
        while(!validChoice){
            System.out.println("1 - Inserir contacto");
            System.out.println("2 - Alterar contacto");
            System.out.println("3 - Apagar contacto");
            System.out.println("4 - Procurar contacto");
            System.out.println("5 - Listar contactos");
            System.out.println("0 - Sair");

            int choice = UserInput.newInt("Escolha uma opção: ");

           if (choice == 1) {
                Pessoa p = newPessoa();
                if(p == null) continue;
               
                while(true)
                    {
                        String phone = UserInput.newStringE("Insira o número de telefone:(não coloque nada se não quiser email) ");
                        String email = UserInput.newStringE("Insira o email:(não coloque nada se não quiser email) ");
                        if (phone.matches("^\\s*$")) phone = null;
                        if (email.matches("^\\s*$")) email = null;
                        try{
                            Contactos.add(new Contactos(p, phone, email));
                            break;
                        }catch(IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                    }



            } else if (choice == 2) {
                Contactos contacto = ContactSearch();
                System.out.println(contacto);

                if (contacto == null) continue;

                while(true) {
                    try{
                        String phone = UserInput.newStringE("Novo número de telemóvel (deixe vazio para não alterar): ");

                            if (!phone.matches("^\\s*$")) contacto.setPhone(phone);

                            String email = UserInput.newStringE("Novo email (deixe vazio para não alterar): ");

                            if (!email.matches("^\\s*$")) contacto.setEmail(email);
                        
                        break;

                    }catch(IllegalArgumentException e) {
                        System.out.println(e);
                    }

                }
                    
                }
             else if (choice == 3) {
                Contactos contacto = ContactSearch();
                if (contacto == null) continue;
                Contactos.remove(contacto);
                System.out.println(contacto);
                System.out.println("Contacto removido");
                }
             else if (choice == 4) {
                Contactos contacto = ContactSearch();
                if (contacto == null) continue;
                System.out.println(contacto);
            } else if (choice == 5) {
                if (Contactos.isEmpty()) {
                    System.out.println("Não existem contactos");
                    continue;
                }
                for (Contactos contacto : Contactos){
                    System.out.println(contacto);
                }
            } else if (choice == 0) {
                validChoice = true;
           }   
        
        }

    }
    private static Pessoa newPessoa() {
        String name = UserInput.newStringLetters("Insira o nome: ");
        int cc = UserInput.newInt("Insira o número de CC: ");
        for (Contactos contacto : Contactos){
            if (contacto.getPerson().getCc() == cc){
                System.out.println("Pessoa já existe");
                return null;
            }
        }
        int year = UserInput.newInt("Insira o ano de nascimento: ");
        int month = UserInput.newInt("Insira o mês de nascimento: ");
        int day = UserInput.newInt("Insira o dia de nascimento: ");
        while(true) {
        try{
            return new Pessoa(name, cc, new DateYMD(day, month, year));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            year = UserInput.newInt("Insira o ano de nascimento: ");
            month = UserInput.newInt("Insira o mês de nascimento: ");
            day = UserInput.newInt("Insira o dia de nascimento: ");
        }}
    }
    private static Contactos ContactSearch(){
        ArrayList<Contactos> contactosSearched = new ArrayList<>();
        boolean validChoice = false;
        System.out.println("1 - Procurar por nome");
        System.out.println("2 - Procurar por número");
        System.out.println("0 - Cancelar");
        int option = UserInput.newInt("Escolha uma opção:");

        if (Contactos.isEmpty()){
            System.out.println("Não existem contactos.");
            return null;
        }
        while(!validChoice){
            if (option == 0) {
                return null;
            }

            if(option == 1){
                String name = UserInput.newString("Insira o nome: ");
                for (Contactos contacto : Contactos){
                    if (contacto.getPerson().getName().contains(name)){
                        contactosSearched.add(contacto);
                    }
                    validChoice = true;
                }
            }else if(option == 2){
                String phone = UserInput.newString("Insira o número de telefone: ");
                for (Contactos contacto : Contactos){
                    if (contacto.getPhone().startsWith(phone)){
                        contactosSearched.add(contacto);
                    }
                    validChoice = true;
                }
            }else{
                    System.out.println("Opção inválida.");
                }
                }
                
                if (contactosSearched.isEmpty()){
                    System.out.println("Não foram encontrados contactos com esse número/nome.");
                    return null;
                }
                else if (contactosSearched.size() == 1){
                    return contactosSearched.get(0);
                }
                else{
                    System.out.println("Foram encontrados os seguintes contactos:");
                    for (Contactos contacto : contactosSearched){
                        System.out.println(contacto);
                    }
               
                while(true){
                    int id = UserInput.newInt("Insira o id do contacto que pretende ver: ");
                    for (Contactos contacto : contactosSearched){
                        if (contacto.getId() == id){
                            return contacto;
                        }
                    }
                    System.out.println("Não foi encontrado nenhum contacto com esse id.");
                } }
            
        
       
     

}
}