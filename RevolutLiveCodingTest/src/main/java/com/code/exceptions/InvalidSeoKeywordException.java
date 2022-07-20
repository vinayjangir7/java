package com.code.exceptions;

public class InvalidSeoKeywordException extends Exception {
    public InvalidSeoKeywordException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidSeoKeywordException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSeoKeywordException(Throwable cause) {
        super(cause);
    }

    public InvalidSeoKeywordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
