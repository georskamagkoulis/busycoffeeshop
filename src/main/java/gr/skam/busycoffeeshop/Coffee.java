package gr.skam.busycoffeeshop;

public abstract class Coffee extends Product {
    private final boolean hasMilk;
    public enum sugarLevel {NONE,LOW,MEDIUM,HIGH}
    private final sugarLevel sugar;

    public Coffee(String name, int preparationTime, double price, int quantity, boolean hasMilk, sugarLevel sugar) {
        super(name, preparationTime, price, quantity);
        if (name == null || (!name.equalsIgnoreCase("Freddo Espresso")
                && !name.equalsIgnoreCase("Freddo Cappuccino")
                && !name.equalsIgnoreCase("Frappe")
                && !name.equalsIgnoreCase("Latte"))) {
            throw new InvalidProductNameException("Invalid coffee name. Please give an appropriate name for the coffee product."
                    + "\nThe valid coffee names are:\nFreddo Espresso\nFreddo Cappuccino\nFrappe\nLatte.");
        }
        this.hasMilk = hasMilk;
        this.sugar = sugar;
    }

    public sugarLevel getSugar() {
        return sugar;
    }

    @Override
    public boolean getDiscount() {
        if (this.getQuantity() > 10) {
            return true;
        }
        return false;
    }

    @Override 
    public String toString() {
        return "Coffee{" +
                "name='" + getName() + '\'' +
                ", preparationTime=" + getPreparationTime() +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", hasMilk=" + hasMilk +
                ", sugar=" + sugar +
                '}';
    }
}
