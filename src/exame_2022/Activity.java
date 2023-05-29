package exame_2022;

public abstract class Activity {
    private int participants;
    private int priceByParticipant;
    private String type;
    private String name;

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public void setPriceByParticipant(int priceByParticipant) {
        this.priceByParticipant = priceByParticipant;
    }

    public String getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public int getParticipants(){
        return this.participants;
    }

    public int getPriceByParticipant(){
        return this.priceByParticipant;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        if (this.name.equals("Catering")){
            String m = this.getType();
            if (m == "FULL_MENU"){m = "Full menu";}
            else if (m == "LIGHT_BITES"){m = "Light bites";}
            else {m = "Drinks and Snacks";}
            return String.format("       '%s' for %d participants", m, this.getParticipants());}
        else if (this.name.equals("Sport")){
            String m = this.getType();
            if (m == "KAYAK"){m = "Kayak";}
            else {m = "Bike";}
            return String.format("       %s sporting activity for %d participants", m, this.getParticipants());}
        else {
            String m = this.getType();
            if (m == "ARCHITECTURAL_TOUR"){m = "Architectural tour";}
            else if (m == "RIVER_TOUR"){m = "River tour";}
            else if (m == "ART_MUSEUM"){m = "Art museum tour";}
            else {m = "Wine tasting";}
            return String.format("       %s with %d participants", m, this.getParticipants());
        }  
}
}

