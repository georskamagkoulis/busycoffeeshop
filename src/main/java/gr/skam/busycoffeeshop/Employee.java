package gr.skam.busycoffeeshop;

public record Employee(String name, int id, int maxPreparationTime,
                       int minPreparationTime, double salary) implements Runnable {

    @Override
    public void run() {
        System.out.println("Employee " + name + " (ID: " + id + ") is now working.");
    }
}