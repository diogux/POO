package exame_2022;

public class Client {
    private String clientName;
    private String location;

    public Client(String clientName, String location){
        this.clientName = clientName;
        this.location = location;
    }

    public String getClientName(){
        return this.clientName;
    }

    public void setClientName(String clientName){
        this.clientName = clientName;
    }

    public String getLocation(){
        return this.location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    @Override
    public String toString(){
        return this.clientName + " [" + this.location + "]";
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Client){
            Client client = (Client) obj;
            return this.clientName.equals(client.getClientName()) && this.location.equals(client.getLocation());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.clientName.hashCode() + this.location.hashCode();
    }

}
