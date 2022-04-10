package Exceptions;

public class BodyEmptyException extends Exception {
    @Override
    public String getMessage() {
        return "The Api didn't return a body. Try again later";
    }
}
