package ic.snakeai.Exceptions;

public class CouldNotWriteUsersException extends RuntimeException {
    public CouldNotWriteUsersException() {
        super(String.format("Error!"));
    }
}
