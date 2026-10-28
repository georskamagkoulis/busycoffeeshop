package gr.skam.busycoffeeshop;

public class FreddoCappuccino extends Coffee {
    public FreddoCappuccino(int preparationTime, int quantity, boolean hasMilk, Coffee.sugarLevel sugar) {
        super("Freddo Cappuccino", preparationTime,3.80, quantity, hasMilk, sugar);
    }
}
