package com.example.myrh.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoSuchUserException extends RuntimeException{
    private String message;

    public NoSuchUserException(String message) {
        super(message);
        this.message = message;
    }

}
