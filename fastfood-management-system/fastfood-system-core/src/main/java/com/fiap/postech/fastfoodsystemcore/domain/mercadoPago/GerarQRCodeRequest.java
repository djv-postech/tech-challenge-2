package com.fiap.postech.fastfoodsystemcore.domain.mercadoPago;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class GerarQRCodeRequest {
  @JsonProperty(value = "external_reference")
  private String externalReference;
  private String title;

  @JsonProperty(value = "total_amount")
  private Integer totalAmount;

  private String description;

  private List<Item> items;

  @JsonProperty(value = "cash_out")
  private CashOut cashOut;
}
