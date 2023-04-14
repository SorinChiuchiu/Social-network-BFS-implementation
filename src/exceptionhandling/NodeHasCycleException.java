package exceptionhandling;

public class NodeHasCycleException extends Exception{
    public NodeHasCycleException(String message){
        super(message);
    }
}
