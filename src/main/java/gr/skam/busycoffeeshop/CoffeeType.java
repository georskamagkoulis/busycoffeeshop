package gr.skam.busycoffeeshop;

public enum CoffeeType {
    FREDDO_ESPRESSO("Freddo Espresso", 2.30),
    FREDDO_CAPPUCCINO("Freddo Cappuccino", 3.80),
    FRAPPE("Frappe", 2.50),
    LATTE("Latte", 3.30);

    private final String displayName;
    private final double price;

    CoffeeType(String displayName, double price) {
        this.displayName = displayName;
        this.price = price;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }

    public static CoffeeType fromName(String name) {
        if (name != null) {
            for (var type : values()) {
                if (type.displayName.equalsIgnoreCase(name.trim())) {
                    return type;
                }
            }
        }
        var validNames = new StringBuilder();
        for (var type : values()) {
            validNames.append("\n").append(type.displayName);
        }
        throw new InvalidProductNameException(
                "Invalid coffee name. Please give an appropriate name for the coffee product."
                        + "\nThe valid coffee names are:" + validNames + ".");
    }
}