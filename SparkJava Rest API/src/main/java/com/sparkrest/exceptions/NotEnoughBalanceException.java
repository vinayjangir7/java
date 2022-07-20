package com.sparkrest.exceptions;

public class NotEnoughBalanceException extends Exception {

    public NotEnoughBalanceException(String message) {
        super(message);
    }

    public NotEnoughBalanceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
