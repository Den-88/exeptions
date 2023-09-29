package Homework_3;

public class InvalidInputNumberPhoneException extends Exception {
    public InvalidInputNumberPhoneException() {
        super("Invalid number of characters in the phone number");
    }
}
