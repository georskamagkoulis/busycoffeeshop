package gr.skam.busycoffeeshop;

public class Frappe extends Coffee {
    public Frappe(int preparationTime, int quantity, boolean hasMilk, Coffee.sugarLevel sugar) {
        super("Frappe", preparationTime, 2.50, quantity, hasMilk, sugar);
    }
}
