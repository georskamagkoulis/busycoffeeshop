package gr.skam.busycoffeeshop;

import java.util.ArrayList;
import java.util.List;

public class OrderBoard {

    private final List<Order> orders = new ArrayList<>();

    public synchronized void add(Order order) {
        orders.add(order);
    }

    public synchronized Order takeNext() {
        if (orders.isEmpty()) {
            return null;
        }
        return orders.remove(0);
    }

    public synchronized boolean isEmpty() {
        return orders.isEmpty();
    }
}