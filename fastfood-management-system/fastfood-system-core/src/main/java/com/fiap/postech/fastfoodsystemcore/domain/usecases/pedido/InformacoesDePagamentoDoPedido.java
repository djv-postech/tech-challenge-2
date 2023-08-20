package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;

public class InformacoesDePagamentoDoPedido {

    private final PedidoRepository pedidoRepository;

    public InformacoesDePagamentoDoPedido(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public StatusPagamento verificaStatusPagamentoPedido(String numeroPedido){
        Pedido pedido = this.pedidoRepository.listarPedidoPorId(numeroPedido);
        return pedido.getPagamento().getStatusPagamento();
    }

}
