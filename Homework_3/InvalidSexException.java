package Homework_3;

public class InvalidSexException extends Exception {
    public InvalidSexException() {
        super("Incorrect gender specified");
    }
}
