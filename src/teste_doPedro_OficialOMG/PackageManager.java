package teste_doPedro_OficialOMG;
import java.util.TreeMap;


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
}
