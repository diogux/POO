package aula09.ex03;

public class CommercialPlane extends Plane {
    private int numOfCrewMembers;

    public CommercialPlane(String id, String manufacturer, String model, int year, int maxPassengers, double maxSpeed,
            int numOfCrewMembers) {
        super(id, manufacturer, model, year, maxPassengers, maxSpeed);
        this.numOfCrewMembers = numOfCrewMembers;
    }

    public int getNumOfCrewMembers() {
        return numOfCrewMembers;
    }

    public void setNumOfCrewMembers(int numOfCrewMembers) {
        this.numOfCrewMembers = numOfCrewMembers;
    }

    @Override
    public String getPlaneType() {
        return "Commercial";
    }

    @Override
    public String toString() {
        return String.format("CommercialPlane: %s , Number of Crew Members %d", super.toString(), numOfCrewMembers);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof CommercialPlane))
            return false;
        CommercialPlane other = (CommercialPlane) obj;
        return this.getId().equals(other.getId()) && this.getManufacturer().equals(other.getManufacturer())
                && this.getModel().equals(other.getModel()) && this.getYear() == other.getYear()
                && this.getMaxPassengers() == other.getMaxPassengers() && this.getMaxSpeed() == other.getMaxSpeed()
                && this.getNumOfCrewMembers() == other.getNumOfCrewMembers();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getId().hashCode();
        result = 31 * result + getManufacturer().hashCode();
        result = 31 * result + getModel().hashCode();
        result = 31 * result + getYear();
        result = 31 * result + getMaxPassengers();
        result = 31 * result + (int) getMaxSpeed();
        result = 31 * result + getNumOfCrewMembers();
        return result;
    }
}
