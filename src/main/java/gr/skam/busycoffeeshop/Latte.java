package gr.skam.busycoffeeshop;

public class Latte extends Coffee {
    public Latte(int preparationTime, int quantity, boolean hasMilk, Coffee.sugarLevel sugar) {
        super("Latte", preparationTime, 3.30, quantity, hasMilk, sugar);
    }
}
