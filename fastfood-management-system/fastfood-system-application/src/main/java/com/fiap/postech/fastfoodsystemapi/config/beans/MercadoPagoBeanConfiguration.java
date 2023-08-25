package com.fiap.postech.fastfoodsystemapi.config.beans;

import com.fiap.postech.fastfoodsysteminfra.gateway.feign.MercadoPagoFeignClient;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.MercadoPagoFeignGateway;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.MercadoPagoClientProperties;
import org.springframework.context.annotation.Bean;

public class MercadoPagoBeanConfiguration {

  private final MercadoPagoFeignClient feignClient;
  private final MercadoPagoClientProperties mercadoPagoClientProperties;

  public MercadoPagoBeanConfiguration(MercadoPagoFeignClient mercadoPagoClient, MercadoPagoClientProperties mercadoPagoClientProperties) {
    this.feignClient = mercadoPagoClient;
    this.mercadoPagoClientProperties = mercadoPagoClientProperties;

  }

  @Bean
  public MercadoPagoFeignGateway mercadoPagoFeignGateway(){
    return  new MercadoPagoFeignGateway(feignClient,mercadoPagoClientProperties );
  }
}
