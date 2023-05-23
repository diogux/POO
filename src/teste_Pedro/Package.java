package teste_Pedro;

public class Package {
    private int id;
    private double weight;
    private String destination;
    private String sender;


    public Package(int id, double weight, String destination, String sender) {
        this.id = id;
        this.weight = weight;
        this.destination = destination;
        this.sender = sender;
    }

    public int getId() {return id;}
    public double getWeight() {return weight;}
    public String getDestination() {return destination;}
    public String getSender() {return sender;}

    public String toString(){
        return String.format("%d : %.2fkg: %s : %s :", id, weight, destination, sender);
    }

}
