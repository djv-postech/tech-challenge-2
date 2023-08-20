package com.fiap.postech.fastfoodsysteminfra.persistence.repository;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;
import com.fiap.postech.fastfoodsysteminfra.persistence.repository.converters.PedidoConverter;
import com.fiap.postech.fastfoodsysteminfra.persistence.repository.entity.PedidoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PedidoRepositoryImpl implements PedidoRepository {

  private final PedidoRepositoryMongo pedidoRepositoryMongo;
  private final PedidoConverter pedidoConverter;

  @Override
  public Pedido cadastrarPedido(Pedido pedido) {
    PedidoEntity pedidoEntity = pedidoRepositoryMongo.insert(new PedidoEntity(pedido));
    return pedidoConverter.convertFrom(pedidoEntity);
  }

  @Override
  public Pedido atualizarPedido(Pedido pedido) {
    PedidoEntity pedidoEntity = pedidoRepositoryMongo.save(new PedidoEntity(pedido));
    return pedidoConverter.convertFrom(pedidoEntity);
  }

  @Override
  public Pedido listarPedidoPorId(String id) {
    return pedidoRepositoryMongo.findById(id)
            .map(pedidoConverter::convertFrom)
            .orElseThrow(() -> new RuntimeException("Pedido de Id: "+ id +" não encontrado"));
  }

  @Override
  public List<Pedido> listarPedidosPorStatus(StatusPedido status) {
    return pedidoRepositoryMongo.findByStatusPedido(status).stream().map(pedidoConverter::convertFrom).collect(
            Collectors.toList());
  }

  @Override
  public List<Pedido> listarPedidos() {
    return pedidoRepositoryMongo.findAll()
            .stream()
            .map(pedidoConverter::convertFrom)
            .collect(Collectors.toList());
  }

  @Override
  public void excluirPedido(String numero) {
    this.pedidoRepositoryMongo.deleteById(numero);
  }

}
