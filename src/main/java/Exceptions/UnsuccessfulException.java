package Exceptions;

public class UnsuccessfulException extends Exception{
    @Override
    public String getMessage() {
        return "The Api Request failed. Try again later.";
    }
}
