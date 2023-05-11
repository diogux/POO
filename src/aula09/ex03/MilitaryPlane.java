package aula09.ex03;

public class MilitaryPlane extends Plane {
    private int numMissiles;

    public MilitaryPlane(String id, String manufacturer, String model, int year, int maxPassengers, double maxSpeed,
            int numMissiles) {
        super(id, manufacturer, model, year, maxPassengers, maxSpeed);
        this.numMissiles = numMissiles;
    }

    public int getNumMissiles() {
        return numMissiles;
    }

    public void setNumMissiles(int numMissiles) {
        this.numMissiles = numMissiles;
    }

    @Override
    public String getPlaneType() {
        return "Military";
    }

    @Override
    public String toString() {
        return String.format("MilitaryPlane: %s , Number of Missiles %d", super.toString(), numMissiles);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof MilitaryPlane))
            return false;
        MilitaryPlane other = (MilitaryPlane) obj;
        return this.getId().equals(other.getId()) && this.getManufacturer().equals(other.getManufacturer())
                && this.getModel().equals(other.getModel()) && this.getYear() == other.getYear()
                && this.getMaxPassengers() == other.getMaxPassengers() && this.getMaxSpeed() == other.getMaxSpeed()
                && this.getNumMissiles() == other.getNumMissiles();
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
        result = 31 * result + getNumMissiles();
        return result;
    }

}