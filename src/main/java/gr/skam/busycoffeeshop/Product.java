package gr.skam.busycoffeeshop;

import java.util.Random;


public abstract class Product {
    private final String name;
    private int preparationTime;
    private final double price;
    private int quantity;
    private static final Random random = new Random();

    public Product(String name, int preparationTime,double price, int quantity) {
        this.name = name;
        this.preparationTime = random.nextInt(3,6);
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", preparationTime=" + preparationTime +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

   public abstract boolean getDiscount();


}