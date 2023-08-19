package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;

public class CadastroDePedido {

    private final PedidoRepository pedidoRepository;

    public CadastroDePedido(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido cadastrarPedido(Pedido pedido){
        return this.pedidoRepository.cadastrarPedido(pedido);
    }
}
