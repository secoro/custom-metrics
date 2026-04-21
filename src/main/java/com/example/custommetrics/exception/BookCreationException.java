package com.example.custommetrics.exception;

public class BookCreationException extends RuntimeException {
    public BookCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
