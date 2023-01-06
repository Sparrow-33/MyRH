package com.example.myrh.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GobalExceptionHandler {
    @Value(value = "${data.exception.UserNotFoundMessage}")
    private String message1;

    @ExceptionHandler(value = NoSuchUserException.class)
    public ResponseEntity blogNotFoundException(NoSuchUserException noSuchUserException) {
        return new ResponseEntity(message1, HttpStatus.NOT_FOUND);
    }
}
