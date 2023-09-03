package com.fiap.postech.fastfoodsystemapi.config;

import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.exception.MercadoPagoQRCodeException;
import com.fiap.postech.fastfoodsysteminfra.persistence.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<ApiError> handlerEntityNotFound(NotFoundException ex) {
        ApiError error = new ApiError(ex.getMessage(),HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {MercadoPagoQRCodeException.class})
    protected ResponseEntity<ApiError> handlerMercadoPagoQRCodeException(MercadoPagoQRCodeException ex) {
        ApiError error = new ApiError(ex.getMessage(),HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
