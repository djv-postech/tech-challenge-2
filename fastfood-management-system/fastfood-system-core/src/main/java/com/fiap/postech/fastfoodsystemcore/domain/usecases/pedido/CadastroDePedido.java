package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.PagamentoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;

public class CadastroDePedido {

    private final PedidoRepository pedidoRepository;
    //private final PagamentoRepository pagamentoRepository;

    public CadastroDePedido(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
       // this.pagamentoRepository = pagamentoRepository;
    }

    public Pedido cadastrarPedido(Pedido pedido){
       // Pagamento pagamento = pagamentoRepository.retornarPagamento(pedido.getId());

//        if (pagamento.getStatusPagamento().equals(StatusPagamento.PROCESSANDO)) {
//            pedido.setPagamento(pagamentoRepository.confirmarPagamento(pagamento.getIdPedido()));
//        }
        return pedidoRepository.cadastrarPedido(pedido);
    }
}
