package gr.skam.busycoffeeshop;

import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class ShiftReport {

    private final ConcurrentHashMap<String, Integer> ordersByEmployee = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> secondsByEmployee = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> cupsByProduct = new ConcurrentHashMap<>();

    public void recordServed(String employeeName, Order order) {
        var product = order.product();
        ordersByEmployee.merge(employeeName, 1, Integer::sum);
        secondsByEmployee.merge(employeeName, product.preparationTime(), Integer::sum);
        cupsByProduct.merge(product.name(), order.quantity(), Integer::sum);
    }

    public void print() {
        System.out.println("========== SHIFT REPORT ==========");

        var totalOrders = 0;
        for (var entry : new TreeMap<>(ordersByEmployee).entrySet()) {
            var name = entry.getKey();
            var orders = entry.getValue();
            var seconds = secondsByEmployee.getOrDefault(name, 0);
            System.out.printf("%-7s: %d orders, %d s of work%n", name, orders, seconds);
            totalOrders += orders;
        }

        System.out.println("----------------------------------");
        System.out.println("Total orders : " + totalOrders);

        String bestName = null;
        var bestCups = 0;
        for (var entry : new TreeMap<>(cupsByProduct).entrySet()) {
            if (entry.getValue() > bestCups) {
                bestName = entry.getKey();
                bestCups = entry.getValue();
            }
        }
        if (bestName != null) {
            System.out.println("Best seller  : " + bestName + " (" + bestCups + ")");
        }
    }
}