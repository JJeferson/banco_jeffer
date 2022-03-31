package com.banco_jeffer.config.controller_advice.exceptions;

public class InternalServerError extends RuntimeException{
    private static final long serialVersionUID = 5291022396354246343L;

    public InternalServerError(String message) {
        super(message);
    }
}
