package ic.snakeai.Exceptions;

public class EmptyFieldException extends Exception {
    public EmptyFieldException() {
        super(String.format("Try again: empty field!"));
    }
}
