package com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago;

import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.MercadoPagoClientProperties;

import feign.Request.Options;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MercadoPagoClientConfig {
  private final MercadoPagoClientProperties properties;

  @Bean("mercadoPagoClient")
  public Options options() {
    return new Options(properties.getConnectTimeout(), properties.getReadTimeout());
  }
}
