package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;

import java.util.List;

public class ListagemDePedido {

    //TODO - dividir cada busca em um usecase?!?!?!?! - em analise
    private final PedidoRepository pedidoRepository;

    public ListagemDePedido(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarPedidoPorStatus(StatusPedido statusPedido) {
        return this.pedidoRepository.listarPedidosPorStatus(statusPedido);
    }

    public Pedido listarPedidoPorId(String idPedido) {
        return this.pedidoRepository.listarPedidoPorId(idPedido);
    }

    public List<Pedido> listarPedidos() {
        return this.pedidoRepository.listarPedidos();
    }
}
