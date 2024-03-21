package com.coffee.shop.exception;

public class ShopNotFoundException extends RuntimeException {

    public ShopNotFoundException() {
        super();
    }

    public ShopNotFoundException(String message) {
        super(message);
    }

    public ShopNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShopNotFoundException(Throwable cause) {
        super(cause);
    }
}

