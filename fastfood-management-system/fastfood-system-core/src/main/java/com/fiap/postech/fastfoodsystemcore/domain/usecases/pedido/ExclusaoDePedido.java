package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;

public class ExclusaoDePedido {

    private final PedidoRepository pedidoRepository;

    public ExclusaoDePedido(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public void excluirPedido(String idPedido){
        this.pedidoRepository.excluirPedido(idPedido);
    }
}
