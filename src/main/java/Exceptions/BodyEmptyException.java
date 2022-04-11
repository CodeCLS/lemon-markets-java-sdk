package Exceptions;

public class BodyEmptyException extends Exception {
    public BodyEmptyException() {
    }

    public BodyEmptyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "The Api didn't return a body. Try again later";
    }
}
