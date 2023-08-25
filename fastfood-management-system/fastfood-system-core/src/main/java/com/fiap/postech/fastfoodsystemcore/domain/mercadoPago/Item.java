package com.fiap.postech.fastfoodsystemcore.domain.mercadoPago;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
  private String title;

  @JsonProperty(value = "unit_price")
  private Integer unitPrice;

  private Integer quantity;

  @JsonProperty(value = "unit_measure")
  private String unitMeasure;

  @JsonProperty(value = "total_amount")
  private Integer totalAmount;
}
