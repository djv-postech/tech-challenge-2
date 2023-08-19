package com.fiap.postech.fastfoodsysteminfra.persistence.repository.converters;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsysteminfra.persistence.repository.entity.PedidoEntity;
import org.springframework.stereotype.Component;

@Component
public class PedidoConverter {

    public Pedido convertFrom(PedidoEntity pedidoEntity){
        return new Pedido(pedidoEntity.getId(), pedidoEntity.getCliente(), pedidoEntity.getProdutos(), pedidoEntity.getPagamento(), pedidoEntity.getStatusPedido(),
                pedidoEntity.getDataCriacaoPedido());
    }

}
