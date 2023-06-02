package com.comp301.a03exceptions;

public class NegativeValueException extends RuntimeException {
    public NegativeValueException(String message) {
        super(message);
    }
}
