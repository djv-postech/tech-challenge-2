package com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ConfirmacaoDePagamentoRequest {
  private String id;
  private String action;

  @JsonProperty("date_created")
  private LocalDateTime dateCreated;

  private PaymentData data;
}
