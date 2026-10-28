package gr.skam.busycoffeeshop;

public sealed interface Product permits Coffee {
    String name();

    double price();

    int quantity();

    int preparationTime();

    boolean hasDiscount();
}