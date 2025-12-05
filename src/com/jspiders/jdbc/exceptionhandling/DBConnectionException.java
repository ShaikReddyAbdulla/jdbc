package com.jspiders.jdbc.exceptionhandling;

public class DBConnectionException extends RuntimeException {
    public DBConnectionException(String message) {
        super(message);
    }

}
