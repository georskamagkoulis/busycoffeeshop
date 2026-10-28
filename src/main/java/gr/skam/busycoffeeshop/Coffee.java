package gr.skam.busycoffeeshop;

import java.util.Random;

public record Coffee(CoffeeType type, int preparationTime, int quantity,
                     boolean hasMilk, SugarLevel sugar) implements Product {

    private static final Random RANDOM = new Random();

    // compact constructor: μόνο έλεγχοι, τα πεδία ανατίθενται αυτόματα
    public Coffee {
        if (type == null) {
            throw new InvalidProductNameException("Coffee type cannot be null.");
        }
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be at least 1.");
        }
    }

    // όπως στο αρχικό Product: τυχαίος χρόνος προετοιμασίας 3-5
    public static Coffee of(CoffeeType type, int quantity, boolean hasMilk, SugarLevel sugar) {
        return new Coffee(type, RANDOM.nextInt(3, 6), quantity, hasMilk, sugar);
    }

    @Override
    public String name() {
        return type.getDisplayName();
    }

    @Override
    public double price() {
        return type.getPrice();
    }

    @Override
    public boolean hasDiscount() {
        return quantity > 10;
    }
}