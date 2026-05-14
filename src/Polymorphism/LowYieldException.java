package Polymorphism;

public class LowYieldException extends Exception {
    public LowYieldException(String message) { // This constructor takes a custom error message
        super(message); // super(message) sends the text to the main Exception class so it can be printed in the console later
    }
}