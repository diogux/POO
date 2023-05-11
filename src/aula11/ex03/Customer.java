package aula11.ex03;
import java.util.List;

public class Customer {
    private int customerId;
    private List<Double> meterReadings;

    public Customer(int customerId, List<Double> meterReadings) {
        this.customerId = customerId;
        this.meterReadings = meterReadings;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Double> getMeterReadings() {
        return meterReadings;
    }

    public void setMeterReadings(List<Double> meterReadings) {
        this.meterReadings = meterReadings;
    }

    // @Override
    // public String toString() {
    //     return String.format("Customer ID:  Meter Readings: %s", customerId, meterReadings);
    // }
}
