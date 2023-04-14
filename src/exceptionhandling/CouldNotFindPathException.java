package exceptionhandling;

public class CouldNotFindPathException extends Exception{
    public CouldNotFindPathException(int start, int target){
        super("BFS algorithm could not find the distance between " + start + " and " + target);
    }
}
