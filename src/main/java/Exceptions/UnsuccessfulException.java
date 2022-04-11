package Exceptions;

public class UnsuccessfulException extends Exception{
    public UnsuccessfulException() {
    }

    public UnsuccessfulException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "The Api Request failed. Try again later.";
    }
}
