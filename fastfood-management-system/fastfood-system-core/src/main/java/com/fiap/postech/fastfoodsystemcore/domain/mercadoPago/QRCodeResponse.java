package com.fiap.postech.fastfoodsystemcore.domain.mercadoPago;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QRCodeResponse {
  @JsonProperty("in_store_order_id")
  private String inStoreOrderId;

  @JsonProperty("qr_data")
  private String qrCode;
}
