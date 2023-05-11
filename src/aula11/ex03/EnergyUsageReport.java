package aula11.ex03;

import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;



public class EnergyUsageReport {
    private TreeMap<Integer, Customer> customers = new TreeMap<>();

    public void load(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            int id = Integer.parseInt(parts[0]);
            ArrayList<Double> meterReadings = new ArrayList<>();

            for (int i = 1; i < parts.length; i++) {
                double meters = Double.parseDouble(parts[i]);
                meterReadings.add(meters);
            }
            addCustomer(id, meterReadings);
        }
        reader.close();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    public void addCustomer(int customerId, ArrayList<Double> meterReadings) {
        Customer newCustomer = new Customer(customerId, meterReadings);
        customers.put(customerId, newCustomer);
    }

    public void removeCustomer(int customerId){
        customers.remove(customerId);
    }

    public Customer getCustomer(int customerId) {
        for (Customer customer : customers.values()) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public double calculateTotalUsage(int customerId) {
        double totalUsage = 0;
        for (Customer customer : customers.values()) {
            if (customer.getCustomerId() == customerId) {
                for (Double meterReading : customer.getMeterReadings()) {
                    totalUsage += meterReading;
                }
            }
        }
        return totalUsage;
    }

    public void generateReport(String filename){
        try {
        FileWriter fw = new FileWriter(filename);
        PrintWriter pw = new PrintWriter(fw);
        pw.write("Customer ID | Meter Readings\n");
        for (Customer customer : customers.values()) {
            String line = String.format("%d | %.0f", customer.getCustomerId(), calculateTotalUsage(customer.getCustomerId()));
            pw.write(line);
            pw.write("\n");
        }
        pw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    




}
