package gr.skam.busycoffeeshop;

public class Order {
    private final int orderId;
    private final Product product;
    private final int quantity; 
    private static int orderCounter = 0;

    public Order( Product product, int quantity) {
        this.orderId = orderCounter++;
        this.product = product;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }

   public static  void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Freddo Espresso");
        System.out.println("2. Freddo Cappuccino");
        System.out.println("3. Frappe");
        System.out.println("4. Latte");
    }
    
}
