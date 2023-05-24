package teste_doPedro_OficialOMG;

public class Package {
    private int id = 1;
    private double weight;
    private String destination;
    private String sender;

    public Package(int id, double weight, String destination, String sender) {
        this.id = id;
        this.weight = weight;
        this.destination = destination;
        this.sender = sender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            System.out.println("Invalid id");
        }
        this.id = id;
        id++;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            System.out.println("Invalid weight");
        }
        this.weight = weight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        if (destination == null || destination.trim().isEmpty()) {
            System.out.println("Invalid destination");
        }
        this.destination = destination;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        if (sender == null || sender.trim().isEmpty()) {
            System.out.println("Invalid sender");
        }
        this.sender = sender;
    }
    
    @Override
    public String toString() {
        return "Package: " + id + ", " + weight + ", " + destination + ", " + sender;
    }

}
