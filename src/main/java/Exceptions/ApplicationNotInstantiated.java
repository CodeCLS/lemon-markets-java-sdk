package Exceptions;

public class ApplicationNotInstantiated extends Exception {
    @Override
    public String getMessage() {
        return "The Application wasn't initiated yet. Call TradingApplication and follow the documentation";
    }
}
