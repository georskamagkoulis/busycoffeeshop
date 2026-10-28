package gr.skam.busycoffeeshop;

import java.util.Scanner;

public class CoffeeShopMain {

    public static void main(String[] args) throws InterruptedException {
        var employee1 = new Employee("John", 1, 5, 2, 2000.0);
        var employee2 = new Employee("Jane", 2, 4, 1, 2200.0);
        var employeeThread1 = new Thread(employee1);
        var employeeThread2 = new Thread(employee2);

        try (var scanner = new Scanner(System.in)) {
            Order.printMenu();
            System.out.print("Enter the product name: ");
            var type = CoffeeType.fromName(scanner.nextLine());

            var coffee = Coffee.of(type, 1, true, SugarLevel.MEDIUM);
            var order = Order.create(coffee, 1);
            System.out.println(order);
        }

        employeeThread1.start();
        employeeThread1.join(3000);
        employeeThread2.start();
    }
}