package gr.skam.busycoffeeshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements AutoCloseable {

    private final Scanner scanner = new Scanner(System.in);

    public List<Order> readOrders() {
        var orders = new ArrayList<Order>();
        while (true) {
            Order.printMenu();
            System.out.println("0. Done - start preparing");
            var choice = readInt("Choose: ", 0, CoffeeType.values().length);
            if (choice == 0) {
                return orders;
            }
            var type = CoffeeType.values()[choice - 1];
            var quantity = readInt("Quantity (1-20): ", 1, 20);
            var hasMilk = readYesNo("With milk? (y/n): ");
            var sugarChoice = readInt("Sugar (0=NONE, 1=LOW, 2=MEDIUM, 3=HIGH): ", 0, 3);
            var sugar = SugarLevel.values()[sugarChoice];

            var coffee = Coffee.of(type, quantity, hasMilk, sugar);
            orders.add(Order.create(coffee, quantity));
            System.out.println("Added: " + type.getDisplayName() + " x" + quantity + "\n");
        }
    }

    public int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            var line = scanner.nextLine().trim();
            try {
                var value = Integer.parseInt(line);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // δεν ήταν αριθμός, ρωτάμε ξανά
            }
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    public boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            var line = scanner.nextLine().trim().toLowerCase();
            if (line.equals("y")) {
                return true;
            }
            if (line.equals("n")) {
                return false;
            }
            System.out.println("Please type y or n.");
        }
    }

    @Override
    public void close() {
        scanner.close();
    }
}