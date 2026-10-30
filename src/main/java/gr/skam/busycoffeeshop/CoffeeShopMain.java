package gr.skam.busycoffeeshop;

import java.util.List;

public class CoffeeShopMain {

    public static void main(String[] args) throws InterruptedException {
        var john = new Employee("John", 1, 5, 2, 2000.0);
        var jane = new Employee("Jane", 2, 4, 1, 2200.0);

        List<Order> orders;
        try (var input = new ConsoleInput()) {
            orders = input.readOrders();
        }

        if (orders.isEmpty()) {
            System.out.println("No orders. Shop closed");
            return;
        }

        var board = new OrderBoard();
        for (var order : orders) {
            board.add(order);
        }

        var t1 = new Thread(() -> john.work(board));
        var t2 = new Thread(() -> jane.work(board));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Receipt.print(orders);
        System.out.println("Shop closed");
    }
}