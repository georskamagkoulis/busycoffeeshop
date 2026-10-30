package gr.skam.busycoffeeshop;

import java.util.List;

public final class Receipt {

    private static final double DISCOUNT_RATE = 0.10;

    private Receipt() {
    }

    public static double lineTotal(Order order) {
        var product = order.product();
        var total = product.price() * order.quantity();
        return product.hasDiscount() ? total * (1 - DISCOUNT_RATE) : total;
    }

    public static double total(List<Order> orders) {
        var sum = 0.0;
        for (var order : orders) {
            sum += lineTotal(order);
        }
        return sum;
    }

    public static void print(List<Order> orders) {
        System.out.println("============ RECEIPT ============");
        for (var order : orders) {
            var product = order.product();
            System.out.printf("#%d %-18s %2d x %5.2f = %7.2f%s%n",
                    order.orderId(), product.name(), order.quantity(),
                    product.price(), lineTotal(order),
                    product.hasDiscount() ? "  (-10%)" : "");
        }
        System.out.println("---------------------------------");
        System.out.printf("TOTAL: %.2f EUR%n", total(orders));
    }
}