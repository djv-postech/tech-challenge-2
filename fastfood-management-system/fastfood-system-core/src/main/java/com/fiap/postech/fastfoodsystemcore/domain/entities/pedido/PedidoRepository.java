package com.fiap.postech.fastfoodsystemcore.domain.entities.pedido;


import java.util.List;

public interface PedidoRepository {

  Pedido cadastrarPedido(Pedido pedido);

  Pedido atualizarPedido(Pedido pedido);

  Pedido listarPedidoPorId(String id);

  List<Pedido> listarPedidosPorStatus(StatusPedido status);

  List<Pedido> listarPedidos();

  void excluirPedido(String numero);
}
