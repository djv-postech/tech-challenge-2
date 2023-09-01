package com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.json;

import lombok.AllArgsConstructor;
import lombok.Data;

//FIXME: Verificar o local correto para estes arquivos
@AllArgsConstructor
@Data
public class CashOut {
  private Integer amount;
}
