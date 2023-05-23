package teste_Pedro;

public class ShippingCost implements ShippingCostCalculator {

    @Override
    public double calculateShippingCost(Package p){
        double cost = p.getWeight() * 3.5;
        return cost;
    }
    
}
