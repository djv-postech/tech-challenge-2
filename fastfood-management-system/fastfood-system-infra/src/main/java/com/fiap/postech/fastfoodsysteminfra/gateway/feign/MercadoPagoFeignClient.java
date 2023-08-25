package com.fiap.postech.fastfoodsysteminfra.gateway.feign;


import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.GerarQRCodeRequest;
import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.QRCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
    name = "mercadoPago",
    url = "${mercado.pago.client.url}",
    configuration = MercadoPagoClientConfig.class)
public interface MercadoPagoFeignClient {

  @PostMapping("/{user_id}/pos/{external_pos_id}/qrs")
  QRCodeResponse gerarQRCode(
      @RequestHeader("Authorization") String authToken,
      @PathVariable("user_id") String userId,
      @PathVariable("external_pos_id") String externalPosId,
      @RequestBody GerarQRCodeRequest request);

}
