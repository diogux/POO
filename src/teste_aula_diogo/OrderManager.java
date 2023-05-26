package teste_aula_diogo;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.time.LocalDate;
import java.io.FileWriter;
//import date formatter
import java.time.format.DateTimeFormatter;


public class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>();


    public void load(String filename){

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] fields = line.split(";");

                String clientId = fields[0];
                String storeId = fields[1];
                String[] itemsArray = fields[2].split("\\|");
                ArrayList<Item> items = new ArrayList<>();

            for (String itemString : itemsArray) {
                String[] itemParts = itemString.split(":");
                String itemName = itemParts[0];
                double itemPrice = Double.parseDouble(itemParts[1]);

                Item item = new Item(itemName, itemPrice);
                items.add(item);
            }
                double price = calculatePrice(items);
                boolean express = fields[4].equals("expresso");
                
                String date = fields[3];
                System.out.println(date);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDate orderDate = LocalDate.parse(date, formatter);
                // String[] dateParts = fields[3].split("-");
                // int year = Integer.parseInt(dateParts[0]);
                // int month = Integer.parseInt(dateParts[1]);
                // String[] dayPart = dateParts[2].split(" ");
                // int day = Integer.parseInt(dayPart[0]);
                // LocalDate orderDate = LocalDate.of(year, month, day);
                Order order = new Order(price, storeId, clientId, orderDate, express, items);
                orders.add(order);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double calculatePrice(List<Item> items) {
        double totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public double calculateOrderCost(int id){
        StandartOrderCostCalculator calculator = new StandartOrderCostCalculator();
        Order order = getOrderById(id);
        if (order == null) {
            return -1;
        }
        return calculator.calculateCost(order);

    }

    public void printAllOrders(){
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public double orderCostByMOnth(int month){
        double totalCost = 0.0;
        for (Order order : orders) {
            if (order.getOrderDateTime().getMonthValue() == month) {
                StandartOrderCostCalculator calculator = new StandartOrderCostCalculator();
                totalCost += calculator.calculateCost(order);
            }
        }
        return totalCost;
    }


    public void addOrder(Order order){
        orders.add(order);
    }

    public void removeOrder(int id){
        for (Order order : orders) {
            if (order.getId() == id) {
                orders.remove(order);
                break;
            }
        }
    }

    public Order getOrderById(int id){
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public void writeOrdersToFile(String filename){
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write("id;clientId;storeId;items;orderDate;express;totalPrice\n");
            for (Order order : orders) {
                fw.write(order.getId() + ";" + order.getClientId() + ";" + order.getStoreId() + ";");
                for (Item item : order.getItems()) {
                    fw.write(item.getName() + ":" + item.getPrice() + "|");
                }
                String ex = "";
                if (order.isExpress()) {
                    ex = "expresso";
                } else{ ex = "normal";}
                fw.write(";" + order.getOrderDateTime() + ";" + ex + ";" + order.getTotalPrice() + "\n");
            }
            fw.close();
            System.out.println("File created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }

    }   

    

    
}
