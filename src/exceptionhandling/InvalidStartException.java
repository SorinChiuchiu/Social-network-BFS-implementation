package exceptionhandling;

public class InvalidStartException extends Exception {
    public InvalidStartException(int size) {
        super("Start position invalid. Try a node between 0 and " + size);
    }
}
