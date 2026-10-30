package gr.skam.busycoffeeshop;

public record Employee(String name, int id, int maxPreparationTime,
                       int minPreparationTime, double salary) implements Runnable {

    @Override
    public void run() {
        System.out.println("Employee " + name + " (ID: " + id + ") is now working.");
    }

    public void work(OrderBoard board, ShiftReport report) {
    while (true) {
        var order = board.takeNext();
        if (order == null) {
            System.out.println(name + ": no more orders, going home");
            return;
        }
        prepare(order);
        report.recordServed(name, order);
    }
}

    public void prepare(Order order) {
        var product = order.product();
        System.out.println(name + " starts " + product.name() + " (order " + order.orderId() + ")");
        try {
            Thread.sleep(product.preparationTime() * 1000L);
            System.out.println(name + " finished " + product.name() + " (order " + order.orderId() + ")");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " was interrupted");
        }
    }
}