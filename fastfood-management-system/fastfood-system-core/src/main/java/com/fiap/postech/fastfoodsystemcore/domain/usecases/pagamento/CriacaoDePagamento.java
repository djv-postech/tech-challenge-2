package com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.MercadoPagoGateway;

public class CriacaoDePagamento {

  private final MercadoPagoGateway mercadoPagoGateway;

  public CriacaoDePagamento(MercadoPagoGateway mercadoPagoGateway) {
    this.mercadoPagoGateway = mercadoPagoGateway;
  }

  public String gerarQrCodeParaPagamento(Pedido pedido) {
    return mercadoPagoGateway.gerarQRCode(pedido);
  }
}
