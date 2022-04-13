package Exceptions;

public class RealTimeNotConnected extends Exception {

    public static final String message = "Ably is not connected yet";

    public RealTimeNotConnected(String message) {
        super(message);
    }


    @Override
    public String getMessage() {
        return message;
    }
}
