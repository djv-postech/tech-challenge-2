package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;

public class AtualizacaoDePedido {

    private final PedidoRepository pedidoRepository;

    public AtualizacaoDePedido(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido atualizarPedido(String id, StatusPedido statusPedido) {
        final Pedido pedido = pedidoRepository.listarPedidoPorId(id);

        pedido.setStatus(statusPedido);

        return pedidoRepository.atualizarPedido(pedido);
    }
}
