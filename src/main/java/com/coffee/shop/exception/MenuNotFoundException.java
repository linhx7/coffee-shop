package com.coffee.shop.exception;

public class MenuNotFoundException extends RuntimeException {

    public MenuNotFoundException() {
        super();
    }

    public MenuNotFoundException(String message) {
        super(message);
    }

    public MenuNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuNotFoundException(Throwable cause) {
        super(cause);
    }
}

