package teste_aula_orders_meu;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private int id;
    private static int nextId = 1;
    private double price;
    private String storeId;
    private String clientId;
    private LocalDate orderDateTime;
    private ArrayList<Item> items;
    private boolean express;

    public Order(double price, String storeId, String clientId, LocalDate orderDateTime, boolean express, ArrayList<Item> items) {
        this.id = nextId++;
        this.price = price;
        this.storeId = storeId;
        this.clientId = clientId;
        this.orderDateTime = orderDateTime;
        this.items = items;
        this.express = express;
    }

    public int getId() {return id;}
    public double getPrice() {return price;}
    public String getStoreId() {return storeId;}
    public String getClientId() {return clientId;}
    public LocalDate getOrderDateTime() {return orderDateTime;}
    public ArrayList<Item> getItems() {return items;}
    public boolean isExpress() {return express;}

    public double getTotalPrice(){
        OrderCostCalculator calculator = new StandartOrderCostCalculator();
        return calculator.calculateCost(this);
    }

    public String toString() {
        String ex = "";
        if (express == true) {
            ex = "Express";
        }
        else {
            ex = "Normal";
        }
        return "Order: " + id + ", price: " + price + ", storeId: " + storeId + ", clientId: " + clientId + ", orderDateTime: " + orderDateTime + ", items: " + items + ", express: " + ex;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
        result = prime * result + id;
        result = prime * result + ((items == null) ? 0 : items.hashCode());
        result = prime * result + ((orderDateTime == null) ? 0 : orderDateTime.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
        return result;
    }
     
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Order)) return false;
        Order other = (Order) obj;
        if (clientId == null) {
            if (other.clientId != null) return false;
        } else if (!clientId.equals(other.clientId)) return false;
        if (id != other.id) return false;
        if (items == null) {
            if (other.items != null) return false;
        } else if (!items.equals(other.items)) return false;
        if (orderDateTime == null) {
            if (other.orderDateTime != null) return false;
        } else if (!orderDateTime.equals(other.orderDateTime)) return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) return false;
        if (storeId == null) {
            if (other.storeId != null) return false;
        } else if (!storeId.equals(other.storeId)) return false;
        return true;
    }


}
