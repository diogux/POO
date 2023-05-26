package teste_aula_orders_meu;

public class Item {
    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {return name;}

    public String toString() {
        return "Item: " + name + ", price: " + price;
    }
}
