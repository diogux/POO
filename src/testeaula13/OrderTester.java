package testeaula13;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderTester {
    public static void main(String[] args) {

        OrderManager orderManager = new OrderManager();
        orderManager.load("pedidos.txt");

        //Adicionar pedido no sistema
        Item item1 = new Item("Coca-Cola", 2.5);
        Item item2 = new Item("Pepsi", 2.5);

        ArrayList <Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        LocalDate orderDate = LocalDate.of(2004, 9, 1);
        Order order = new Order(100, "86", "97", orderDate, true , items);
        orderManager.addOrder(order);

        //Remover pedido do sistema
        orderManager.removeOrder(1);

        //Calcular custo de um pedido
        System.out.println();
        System.out.println("Custo do pedido 2: ");
        System.out.println(orderManager.calculateOrderCost(2));
        System.out.println();

        //Procurar pedido por id
        System.out.println("Pedido 3: ");
        System.out.println(orderManager.getOrderById(3));
        System.out.println();
        System.out.println("Pedido 4: ");
        System.out.println(orderManager.getOrderById(4));

        //Calcula o cust de todos os pedidos de um mês
        System.out.println();
        System.out.println("Custo de todos os pedidos do mês 9: ");
        System.out.println(orderManager.orderCostByMOnth(9));

        //Imprimir todos os pedidos
        System.out.println("Todos os pedidos:");
        System.out.println("-------------------------------------------------------");
        orderManager.printAllOrders();
        System.out.println("-------------------------------------------------------");

        //Escrever no ficheiro
        System.out.println("Escrever no ficheiro: ");
        orderManager.writeOrdersToFile("orders.txt");

    
    
    
    }

}
