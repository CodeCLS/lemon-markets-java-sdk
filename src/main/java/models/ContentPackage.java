package models;

import Stock.Stock;

public class ContentPackage {
    private Object value;
    private Exception exception;

    public ContentPackage(Object value, Exception exception) {
        this.value = value;
        this.exception = exception;
    }

    public ContentPackage() {
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
    public interface ApiAsyncReturn{
        void getPackage(ContentPackage contentPackage);
    }

}
