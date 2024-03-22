package com.coffee.shop.exception;

public class QueueFullException extends RuntimeException {

    public QueueFullException() {
        super();
    }

    public QueueFullException(String message) {
        super(message);
    }

    public QueueFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueueFullException(Throwable cause) {
        super(cause);
    }
}

