package com.example.springmvcmongogradle.task.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class NotFoundException extends RuntimeException {

    private final String message;

    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }
}