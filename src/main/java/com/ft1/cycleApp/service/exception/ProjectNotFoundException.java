package com.ft1.cycleApp.service.exception;

public class ProjectNotFoundException extends ServiceException {
    public ProjectNotFoundException() {
        super();
    }

    public ProjectNotFoundException(String message) {
        super(message);
    }

    public ProjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProjectNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
