package exceptionhandling;

public class InvalidTargetException extends Exception {
    public InvalidTargetException(int size) {
        super("Target position is invalid. Try a node between 0 and " + size);
    }
}
