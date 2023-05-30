package com.neizu.paydaytrade.exception;

public class EnoughMoneyException extends RuntimeException {
    public EnoughMoneyException(String message) {
        super(message);
    }
}
