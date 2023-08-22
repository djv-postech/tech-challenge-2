package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListagemDePedidoPorNumeroDePedido {

    private final PedidoRepository pedidoRepository;

    public ListagemDePedidoPorNumeroDePedido(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido listarPedidoPorNumeroPedido(String idPedido) {
        return this.pedidoRepository.listarPedidoPorNumeroPedido(idPedido);
    }

}
