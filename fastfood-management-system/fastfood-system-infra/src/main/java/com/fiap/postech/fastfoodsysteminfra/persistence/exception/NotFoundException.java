package com.fiap.postech.fastfoodsysteminfra.persistence.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
