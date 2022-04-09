package Exceptions;

public class StockBodyEmptyException extends Exception {
    public StockBodyEmptyException() {
    }

    public StockBodyEmptyException(String message) {
        super(message);
    }
}
