package Exceptions;

public class IncorrectLoginData extends Exception {
    public IncorrectLoginData() {
        super(String.format("Incorrect login data"));
    }
}
