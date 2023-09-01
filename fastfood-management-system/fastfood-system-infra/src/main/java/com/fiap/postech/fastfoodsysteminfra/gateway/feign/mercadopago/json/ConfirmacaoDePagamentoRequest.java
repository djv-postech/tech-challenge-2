package com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ConfirmacaoDePagamentoRequest {
  private String id;

  @JsonProperty("action")
  private String acao;

  @JsonProperty("date_created")
  private LocalDateTime dataHoraDeConfirmacao;

  @JsonProperty("data")
  private DadosDoPagamento dadosDoPagamento;
}
