package com.ft1.cycleApp.service.exception;

public class NoteNotFoundException extends ServiceException{
    public NoteNotFoundException() {
        super();
    }

    public NoteNotFoundException(String message) {
        super(message);
    }

    public NoteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoteNotFoundException(Throwable cause) {
        super(cause);
    }

    protected NoteNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
