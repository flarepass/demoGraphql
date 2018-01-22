package com.example.demographql.exception;

/**
 * Created by wilyanto.salim on 10/3/16.
 */
public class TestException extends RuntimeException {
    String path;

    public TestException() {
    }

    public TestException(String message, String path) {
        super(message);
        this.path = path;
    }

    public TestException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestException(Throwable cause) {
        super(cause);
    }

    public TestException(String message, Throwable cause, boolean enableSuppression,
                         boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getPath() {
        return path;
    }
}
