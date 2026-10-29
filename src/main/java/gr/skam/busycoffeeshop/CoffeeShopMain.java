package gr.skam.busycoffeeshop;

public class CoffeeShopMain {

    public static void main(String[] args) throws InterruptedException {
        var john = new Employee("John", 1, 5, 2, 2000.0);
        var jane = new Employee("Jane", 2, 4, 1, 2200.0);

        var board = new OrderBoard();
        try (var input = new ConsoleInput()) {
            for (var order : input.readOrders()) {
                board.add(order);
            }
        }

        if (board.isEmpty()) {
            System.out.println("No orders. Shop closed");
            return;
        }

        var t1 = new Thread(() -> john.work(board));
        var t2 = new Thread(() -> jane.work(board));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Shop closed");
    }
}