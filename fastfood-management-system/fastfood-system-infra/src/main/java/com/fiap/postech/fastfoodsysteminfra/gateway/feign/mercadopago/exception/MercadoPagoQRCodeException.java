package com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.exception;

public class MercadoPagoQRCodeException extends RuntimeException {
  public MercadoPagoQRCodeException(String message) {
    super(message);
  }
}
