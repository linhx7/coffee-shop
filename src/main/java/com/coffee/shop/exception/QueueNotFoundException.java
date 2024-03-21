package com.coffee.shop.exception;

public class QueueNotFoundException extends RuntimeException {

    public QueueNotFoundException() {
        super();
    }

    public QueueNotFoundException(String message) {
        super(message);
    }

    public QueueNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueueNotFoundException(Throwable cause) {
        super(cause);
    }
}

