package com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.MercadoPagoGateway;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.MercadoPagoFeignClient;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.converter.GerarQRCodeRequestConverter;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.exception.MercadoPagoException;
import feign.FeignException;
import org.springframework.stereotype.Service;

@Service
public class MercadoPagoFeignGateway implements MercadoPagoGateway {

  private final MercadoPagoFeignClient feignClient;
  private final MercadoPagoClientProperties properties;

  private final GerarQRCodeRequestConverter converter;

  private static final String REQUEST = ", Request: ";
  private static final String RESPONSE = ", Response: ";

  public MercadoPagoFeignGateway(
      MercadoPagoFeignClient feignClient,
      MercadoPagoClientProperties properties,
      GerarQRCodeRequestConverter converter) {
    this.feignClient = feignClient;
    this.properties = properties;
    this.converter = converter;
  }

  @Override
  public String gerarQRCode(Pedido pedido) {
    // TODO: Verificar outras possíveis exceções
    try {
      return converter.convertFrom(
          feignClient.gerarQRCode(
              properties.getAuthToken(),
              properties.getUserId(),
              properties.getExternalPosId(),
              converter.convertFrom(pedido)));

    } catch (FeignException e) {
      String message =
          e.getMessage()
              .concat(REQUEST)
              .concat(converter.convertFrom(pedido).toString())
              .concat(RESPONSE)
              .concat(e.contentUTF8());
      throw new MercadoPagoException(message);
    }
  }
}
