package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;

public class AtualizacaoDePedido {

  private final PedidoRepository pedidoRepository;

  public AtualizacaoDePedido(PedidoRepository pedidoRepository) {
    this.pedidoRepository = pedidoRepository;
  }

  public Pedido atualizarPedido(String numeroPedido, StatusPedido statusPedido) {
    final Pedido pedido = pedidoRepository.listarPedidoPorNumeroPedido(numeroPedido);

    pedido.setStatus(statusPedido);

    return pedidoRepository.atualizarPedido(pedido);
  }

  public Pedido atualizarPedido(String numeroPedido, Pagamento pagamento) {
    final Pedido pedido = pedidoRepository.listarPedidoPorNumeroPedido(numeroPedido);
    pedido.setPagamento(pagamento);
    pedido.setStatus(
        pagamento.getStatusPagamento().equals(StatusPagamento.APROVADO)
            ? StatusPedido.EM_PREPARACAO
            : StatusPedido.FINALIZADO);
    return pedidoRepository.atualizarPedido(pedido);
  }
}
