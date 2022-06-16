package com.example.springmvcmongogradle.acommons.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

import static org.springframework.http.HttpStatus.*;


@ControllerAdvice
@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(code = NOT_FOUND)
    public ErrorDetail handlerNotFoundException(NotFoundException e) {
        return ErrorDetail.builder()
                .timestamp(new Date().getTime())
                .status(NOT_FOUND.value())
                .title("Resource Not Found Not Found Exception")
                .detail(e.getMessage())
                .developerMessage(NOT_FOUND.name())

                .build();
    }


    @ExceptionHandler(ErrorException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorDetail handlerNotFoundException(ErrorException e) {
        return ErrorDetail.builder()
                .timestamp(new Date().getTime())
                .status(NOT_FOUND.value())
                .title("Resource Not Found Error Exception")
                .detail(e.getMessage())
                .developerMessage(e.getClass().getName())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorDetail methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ErrorDetail.builder()
                .title("Method not Allowed")
                .status(BAD_REQUEST.value())
                .detail(ex.getFieldError().getDefaultMessage())
                .timestamp(new Date().getTime())
                .developerMessage(ex.getClass().getName())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorDetail handlerBadRequest(Exception e) {
        return ErrorDetail.builder()
                .timestamp(new Date().getTime())
                .status(NOT_FOUND.value())
                .title("Bad Request")
                .detail(e.getMessage() + "GENERIC ERROR")
                .developerMessage(e.getClass().getName())
                .build();
    }

}
