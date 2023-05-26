package teste_aula_packages;
import java.util.TreeMap;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class PackageManager{

    TreeMap<Integer, Package> packages = new TreeMap<>();

    ShoppingCostCalculator Calculator = new StandardShoppingCalculator();

    public void addPackage(Package p){
        if (packages.containsKey(p.getId())) {
            throw new IllegalArgumentException("Package already exists");
        }
        packages.put(p.getId(), p);
    }

    public void removePackage(int id) {
        if (id < 0) {
            System.out.println("Invalid id");
        }
        if (packages.containsKey(id)) {
            packages.remove(id);
        }
    }

    public Package searchPackage(int id) {
        if (id < 0) {
            System.out.println("Invalid id");
        }
        return packages.get(id);
    }

    public double cost(Package pkg) {
        if (pkg == null) {
            System.out.println("Invalid package");
        }
        return Calculator.calculateShippingCost(pkg);
    }
    
    public void printAllPackages() {
        for (Package pkg : packages.values()) {
            System.out.println(pkg.toString());
        }
    }

    public void loadFile(String filename){
        try {
            BufferedReader br = new BufferedReader(new FileReader("encomendas.txt"));
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] fields = line.split(";");
                int id = Integer.parseInt(fields[0]);
                double weight = Double.parseDouble(fields[1]);
                String destination = fields[2];
                String sender = fields[3];
                Package p = new Package(id, weight, destination, sender);
                addPackage(p);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String filename) {
        try (PrintWriter output1 = new PrintWriter(filename)) {
            output1.printf("%-3s | %-7s | %-20s | %-20s%n", "ID", "Weight", "Destinations", "Sender"); // Header
            for (Package pkg : packages.values()) {
                output1.printf("%-3s | %-7s | %-20s | %-20s%n", pkg.getId(), pkg.getWeight(), pkg.getDestination(), pkg.getSender());
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
            return;
        }
    }
    
    
}
