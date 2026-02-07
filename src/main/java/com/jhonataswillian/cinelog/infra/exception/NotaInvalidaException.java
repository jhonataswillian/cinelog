package com.jhonataswillian.cinelog.infra.exception;

public class NotaInvalidaException extends IllegalArgumentException {
    public NotaInvalidaException(String message) {
        super(message);
    }
}
