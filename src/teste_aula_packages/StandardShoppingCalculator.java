package teste_aula_packages;

public class StandardShoppingCalculator  implements ShoppingCostCalculator{

    @Override
    public double calculateShippingCost(Package pkg) {
        double cost = 0;
        if (pkg.getWeight() < 5) {
            cost = pkg.getWeight();
        } else if (pkg.getWeight() >= 5 && pkg.getWeight() < 10) {
            cost = 2 * pkg.getWeight();
        } else if (pkg.getWeight() >= 10) {
            cost = 3 * pkg.getWeight();
        }
        return cost = Math.round(cost * 100.0) / 100.0;
    }
    
}
