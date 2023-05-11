package aula09.ex03;

public abstract class Plane {
    private String id;
    private String manufacturer;
    private String model;
    private int year;
    private int maxPassengers;
    private double maxSpeed;

    public Plane(String id, String manufacturer, String model, int year, int maxPassengers, double maxSpeed) {
        if (year < 1903 && year > 2023) // Ano de construção do primeiro avião e ano atual
            throw new IllegalArgumentException("Invalid year");
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
    }

    public String getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public abstract String getPlaneType();

    @Override
    public String toString() {
        return String.format(" Avião: Id: %s Manufacturer: %s Model: %s (%d) - %d passengers - %.2f km/h", id,
                manufacturer, model, year,
                maxPassengers, maxSpeed);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Plane))
            return false;
        Plane other = (Plane) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
