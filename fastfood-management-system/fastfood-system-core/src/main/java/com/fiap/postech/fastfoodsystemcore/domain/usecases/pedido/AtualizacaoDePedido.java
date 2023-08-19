package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;

public class AtualizacaoDePedido {

    private final PedidoRepository pedidoRepository;

    public AtualizacaoDePedido(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido atualizarPedido(Pedido pedido) {
        return this.pedidoRepository.atualizarPedido(pedido);
    }
}
