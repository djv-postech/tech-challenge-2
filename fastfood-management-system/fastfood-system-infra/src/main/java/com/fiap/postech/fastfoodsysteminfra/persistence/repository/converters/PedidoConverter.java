package com.fiap.postech.fastfoodsysteminfra.persistence.repository.converters;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsysteminfra.persistence.repository.entity.PedidoEntity;
import org.springframework.stereotype.Component;

@Component
public class PedidoConverter {

  public Pedido convertFrom(PedidoEntity pedidoEntity) {
    return new Pedido(
        pedidoEntity.getNumeroPedido(),
        pedidoEntity.getCliente(),
        pedidoEntity.getProdutos(),
        pedidoEntity.getValorTotal(),
        pedidoEntity.getPagamento(),
        pedidoEntity.getStatusPedido(),
        pedidoEntity.getDataCriacaoPedido());
  }
}
