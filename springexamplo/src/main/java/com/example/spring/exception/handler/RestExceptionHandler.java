package com.example.spring_mvc_mongo_gradle.exception.handler;

import com.example.spring_mvc_mongo_gradle.exception.ResourceNotFoundDetails;
import com.example.spring_mvc_mongo_gradle.exception.notFound.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

//@ControllerAdvice
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResourceNotFoundDetails handlerNotFoundException(ResourceNotFoundException e) {
        return ResourceNotFoundDetails.builder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource Not Found")
                .detail(e.getMessage())
                .developerMessage(e.getClass().getName())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResourceNotFoundDetails handlerBadRequest(Exception e) {
        return ResourceNotFoundDetails.builder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Bad Request")
                .detail(e.getMessage() + "GENERIC ERROR")
                .developerMessage(e.getClass().getName())
                .build();
    }
}
