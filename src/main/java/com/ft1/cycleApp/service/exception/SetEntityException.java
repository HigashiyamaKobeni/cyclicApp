package com.ft1.cycleApp.service.exception;

public class SetEntityException extends ServiceException {
    public SetEntityException() {
    }

    public SetEntityException(String message) {
        super(message);
    }

    public SetEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public SetEntityException(Throwable cause) {
        super(cause);
    }

    public SetEntityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
