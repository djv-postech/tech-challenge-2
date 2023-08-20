package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListagemDePedido {

    //TODO - dividir cada busca em um usecase?!?!?!?! - em analise
    private final PedidoRepository pedidoRepository;

    public ListagemDePedido(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarPedidoPorStatus(StatusPedido statusPedido) {
        return this.pedidoRepository.listarPedidosPorStatus(statusPedido);
    }

    public Pedido listarPedidoPorNumeroPedido(String idPedido) {
        return this.pedidoRepository.listarPedidoPorId(idPedido);
    }

    public List<Pedido> listarPedidosOrdenadosPorRecebimentoEStatus() {
        return this.pedidoRepository.listarPedidos().stream()
                .filter(pedido -> pedido.getStatusPedido() != StatusPedido.FINALIZADO)
                .sorted(Comparator.comparing(Pedido::getDataCriacaoPedido)
                        .thenComparing(Pedido::getStatusPedido))
                .collect(Collectors.toList());
    }
}
