package gr.skam.busycoffeeshop;

public class InvalidProductNameException extends IllegalArgumentException {
    public InvalidProductNameException(String message) {
        super(message);
    }
    
}
