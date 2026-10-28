package gr.skam.busycoffeeshop;


import java.util.Scanner;

public class CoffeeShopMain {
    
    public static void main (String[] args) throws InterruptedException,InvalidProductNameException {
        Employee employee1 = new Employee("John", 1, 5, 2, 2000.0);
        Employee employee2 = new Employee("Jane", 2, 4, 1, 2200.0);
        Thread employeeThread1 = new Thread(employee1);
        Thread employeeThread2 = new Thread(employee2);
        Scanner scanner = new Scanner(System.in);
    
        
        boolean newOrder = true;
        while (newOrder) {
        Order.printMenu();
        System.out.print("Enter the product name: ");
            String productName = scanner.nextLine();
        
            employeeThread1.start();
             employeeThread1.join(3000);
            employeeThread2.start();
            break;
      
    }
}

}
