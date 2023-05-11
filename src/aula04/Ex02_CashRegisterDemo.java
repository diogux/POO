package aula04;


class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int  getQuantity() {
        return quantity;
    }
}


class CashRegister {
    private Product[] products;
    private int count;

    public CashRegister() {
        products = new Product[10];
        count = 0;
    }

    public void addProduct(Product p) {
        if (count < products.length) {
            products[count] = p;
            count++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count;i++) {
            total += products[i].getTotalValue();
        }
        return total;
    }

    public String toString() {
        String print = String.format("%s %15s %18s %12s \n","Product","Price", "Quantity", "Total");
        for (int i = 0; i < count; i++) {
            print += String.format("%-15s %7.2f %18d %12.2f\n",products[i].getName(),products[i].getPrice(),products[i].getQuantity(),products[i].getTotalValue());
        }
        
        print += "\nTotal: " + getTotal();
        return print;
    }

}

public class Ex02_CashRegisterDemo {

    public static void main(String[] args) {

        // Cria e adiciona 5 produtos
        CashRegister cr = new CashRegister();
        cr.addProduct(new Product("Book", 9.99, 3));
        cr.addProduct(new Product("Pen", 1.99, 10));
        cr.addProduct(new Product("Headphones", 29.99, 2));
        cr.addProduct(new Product("Notebook", 19.99, 5));
        cr.addProduct(new Product("Phone case", 5.99, 1));
        
        System.out.println(cr);

    }
}