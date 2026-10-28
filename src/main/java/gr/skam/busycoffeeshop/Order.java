package gr.skam.busycoffeeshop;

import java.util.concurrent.atomic.AtomicInteger;

public record Order(int orderId, Product product, int quantity) {

    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    public static Order create(Product product, int quantity) {
        return new Order(COUNTER.getAndIncrement(), product, quantity);
    }

    public static void printMenu() {
        System.out.println("Menu:");
        var number = 1;
        for (var type : CoffeeType.values()) {
            System.out.println(number++ + ". " + type.getDisplayName());
        }
    }
}