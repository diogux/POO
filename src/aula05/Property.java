package aula05;

public class Property {
    private int id;
    private String locality;
    private int rooms;
    private double price;
    private boolean available;
    private DateYMD auctionStartDate;
    private DateYMD auctionEndDate;
    


    public Property(int id, String locality, int rooms, double price) {
        this.id = id;
        this.locality = locality;
        this.rooms = rooms;
        this.price = price;
        this.available = true;
        this.auctionStartDate = null;
        this.auctionEndDate = null;
    }

    public int getId() {
        return id;
    }

    public String getLocality() {
        return locality;
    }

    public int getRooms() {
        return rooms;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public DateYMD getAuctionStartDate() {
        return auctionStartDate;
    }

    public DateYMD getAuctionEndDate() {
        return auctionEndDate;
    }

    public void setAvailability(boolean available) {
        this.available = available;
    }

    public String toString() {
        if (auctionStartDate == null){
        return String.format("Imóvel: %d; quartos: %d; localidade: %s; preço: %.0f; disponível: %s ", id, rooms, locality, price, available ? "sim" : "não");
        } else{ 
            return String.format("Imóvel: %d; quartos: %d; localidade: %s; preço: %.0f; disponível: %s; leilão: %s a %s", id, rooms, locality, price, available ? "sim" : "não", auctionStartDate.toString(), auctionEndDate.toString());
        }
}
    public void setAuctionStartDate(DateYMD auctionStartDate){
        this.auctionStartDate = auctionStartDate;
    }
    
    public void setAuctionEndDate(DateYMD auctionStarDate,int days){
        DateYMD initialDate = auctionStartDate;
        for(int i = 0; i < days; i++){ //incrementa o dia até chegar à data final
            initialDate.increment();
        }
        this.auctionEndDate = initialDate;
    }
    
}
