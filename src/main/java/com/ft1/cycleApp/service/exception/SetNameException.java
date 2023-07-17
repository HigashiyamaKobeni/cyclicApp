package com.ft1.cycleApp.service.exception;

public class SetNameException extends ServiceException {
    public SetNameException() {
        super();
    }

    public SetNameException(String message) {
        super(message);
    }

    public SetNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public SetNameException(Throwable cause) {
        super(cause);
    }

    protected SetNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
