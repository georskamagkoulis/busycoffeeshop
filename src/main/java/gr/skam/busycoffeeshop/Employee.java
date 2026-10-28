package gr.skam.busycoffeeshop;


public class Employee implements Runnable {
    private final String name;
    private final int id;
    private int maxPreparationTime;
    private int minPreparationTime;
    private double salary;
    
    public Employee(String name, int id, int maxPreparationTime, int minPreparationTime, double salary) {
        this.name = name;
        this.id = id;
        this.maxPreparationTime = maxPreparationTime;
        this.minPreparationTime = minPreparationTime;
        this.salary = salary;
    }

    @Override 
    public void run() {
    
        System.out.println("Employee " + name + " (ID: " + id + ") is now working.");
     


    }

}
