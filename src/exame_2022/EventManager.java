package exame_2022;
import java.util.Map;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class EventManager {
    private String name;
    private Map<Client, ArrayList<Event>> events = new HashMap<>();
    
    
    public EventManager(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Client addClient(String clientName, String location){
        Client client = new Client(clientName, location);
        if (events.containsKey(client)){
            System.out.println("Client already exists");
            return null;
        }
        else{
            events.put(client, new ArrayList<Event>());
            return client;
        }
    }

   
    public Event addEvent(Client client, LocalDate date){
        if (events.containsKey(client)){
            ArrayList<Event> clientEvents = events.get(client);
            for (Event e : clientEvents){
                if (e.getDate().equals(date)){
                    System.out.println("Event already exists");
                    return null;
                }
            }
            Event event = new Event(date, new ArrayList<Activity>());
            clientEvents.add(event);
            return event;
        }
        else{
            System.out.println("Client does not exist");
            return null;
        }
    }



    public String listClients(){
        if (events.isEmpty()){
            return "";
        }
        else{
            String result = "Clients:\n";
            for (Client client : events.keySet()){
                result += client + "\n";
            }
            return result;
        }
    }

    public String listEvents(){
        if (events.isEmpty()){
            return "";
        }
        else{
            String result = "Events:\n";
            for (Client client : events.keySet()){
                for (Event event : events.get(client)){
                    result += event + "\n";
                    
                }
            }
            return result;
        }
        }
    }





