package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListagemDePedidoOrdenadosPorRecebimentoEStatus {

  // FIXME: Pesquisar sobre padrao dos métodos para nao ficar redundante, já que cada use case tem
  // apenas uma única responsabilidade
  private final PedidoRepository pedidoRepository;

  public ListagemDePedidoOrdenadosPorRecebimentoEStatus(PedidoRepository pedidoRepository) {
    this.pedidoRepository = pedidoRepository;
  }

  public List<Pedido> listarPedidosOrdenadosPorRecebimentoEStatus() {
    // FIXME: Alterei a ordem, para agrupar os status, se não, um pedido pronto poderia ficar por
    // ultimo caso ele seja o menos recente dentro todos pedidos, tambem coloquei o reversed pq
    // imagino que os mais antigos devem aparecer primeiro
    return this.pedidoRepository.listarPedidos().stream()
        .filter(pedido -> pedido.getStatusPedido() != StatusPedido.FINALIZADO)
        .sorted(Comparator.comparing(Pedido::getStatusPedido))
        .sorted(Comparator.comparing(Pedido::getDataCriacaoPedido).reversed())
        .collect(Collectors.toList());
  }
}
