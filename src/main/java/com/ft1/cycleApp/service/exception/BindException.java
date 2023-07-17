package com.ft1.cycleApp.service.exception;

public class BindException extends ServiceException {
    public BindException() {
        super();
    }

    public BindException(String message) {
        super(message);
    }

    public BindException(String message, Throwable cause) {
        super(message, cause);
    }

    public BindException(Throwable cause) {
        super(cause);
    }

    protected BindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
