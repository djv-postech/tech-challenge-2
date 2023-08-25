package com.fiap.postech.fastfoodsysteminfra.gateway.feign;

import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.GerarQRCodeRequest;
import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.MercadoPagoGateway;
import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.QRCodeResponse;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.MercadoPagoClientProperties;
import feign.FeignException;
import org.springframework.stereotype.Service;

@Service
public class MercadoPagoFeignGateway implements MercadoPagoGateway {

  private final MercadoPagoFeignClient feignClient;
  private final MercadoPagoClientProperties properties;

  public MercadoPagoFeignGateway(
      MercadoPagoFeignClient feignClient, MercadoPagoClientProperties properties) {
    this.feignClient = feignClient;
    this.properties = properties;
  }

  @Override
  public QRCodeResponse gerarQRCode(GerarQRCodeRequest request) {

    // TODO: Tratamento de exceções específicas
    try {
      return feignClient.gerarQRCode(
          properties.getAuthToken(),
          properties.getUserId(),
          properties.getExternalPosId(),
          request);

    } catch (FeignException e) {
      System.out.print("Erro: " + e);
      throw e;
    }
  }
}
