package teste_aula_diogo;

public class StandartOrderCostCalculator implements OrderCostCalculator {
    
    @Override
    public double calculateCost(Order order) {
        double cost = 0;
        for (Item item : order.getItems()) {
            if (order.isExpress()) {
                cost += item.getPrice() * 1.3;

            } else {
                cost += item.getPrice();
            }
        }
        return Math.round(cost * 100.0) / 100.0;
        }
    
    }


