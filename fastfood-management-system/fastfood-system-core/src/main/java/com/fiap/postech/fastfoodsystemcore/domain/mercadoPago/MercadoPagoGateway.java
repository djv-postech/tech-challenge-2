package com.fiap.postech.fastfoodsystemcore.domain.mercadoPago;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;

public interface MercadoPagoGateway {


  String gerarQRCode(Pedido pedido);
}
