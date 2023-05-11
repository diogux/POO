package aula05;
import java.util.ArrayList;

public class RealEstate {
    private ArrayList<Property> properties;
    private int nextId;

    public RealEstate() {
        properties = new ArrayList<>();
        nextId = 1000;
    }

    public void newProperty(String locality, int rooms, double price) {
        properties.add(new Property(nextId, locality, rooms, price));
        nextId++;
    }
    

    public void sell(int id) {
        Property property = getPropertyById(id);
        if (property != null) {
            if (property.isAvailable()) {
                System.out.println("Imóvel " + id + " vendido.");
                property.setAvailability(false);
            } else {
                System.out.println("Imóvel " + id + " não está disponível.");
            }
        } else {
            System.out.println("Imóvel " + id + " não existe.");
        }
    }

    private Property getPropertyById(int id) {
        for (Property property : properties) {
            if (property.getId() == id) {
                return property;
            }
        }
        return null;

    }

    public void setAuction(int id, DateYMD auctionStartDate, int days) {
        Property property = getPropertyById(id);
        if (property != null){
        if (property.isAvailable()) {
            property.setAuctionStartDate(auctionStartDate);
            property.setAuctionEndDate(auctionStartDate,days);
            property.setAvailability(false);
        }
        else{
            System.out.println("Imóvel " + id + " não está disponível.");
        }
    }   else{
        System.out.println("Imóvel " + id + " não existe.");
    }
    }
    
    public String toString() {
        String result = "Propriedades: \n";
        for (Property property : properties) {
            
            result += property.toString() + "\n";}
        return result;
        }


}




