package com.example.springmvcmongogradle.task.exception;

public class ErrorException extends RuntimeException {
    public ErrorException(String message) {
        super(message);
    }
}