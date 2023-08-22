package com.fiap.postech.fastfoodsystemapi.config.beans;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.AtualizacaoDePedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.CadastroDePedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.ListagemDePedidoOrdenadosPorRecebimentoEStatus;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.ListagemDePedidoPorNumeroDePedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.ListagemDePedidoPorStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoBeanConfiguration {

  private final PedidoRepository pedidoRepository;

  public PedidoBeanConfiguration(PedidoRepository pedidoRepository) {
    this.pedidoRepository = pedidoRepository;
  }

  @Bean
  public CadastroDePedido cadastroDePedido() {
    return new CadastroDePedido(pedidoRepository);
  }

  @Bean
  public AtualizacaoDePedido atualizacaoDePedido() {
    return new AtualizacaoDePedido(pedidoRepository);
  }

  @Bean
  public ListagemDePedidoPorNumeroDePedido listagemDePedidoPorNumeroDePedido() {
    return new ListagemDePedidoPorNumeroDePedido(pedidoRepository);
  }

  @Bean
  public ListagemDePedidoOrdenadosPorRecebimentoEStatus
      listagemDePedidoOrdenadosPorRecebimentoEStatus() {
    return new ListagemDePedidoOrdenadosPorRecebimentoEStatus(pedidoRepository);
  }

  @Bean
  public ListagemDePedidoPorStatus listagemDePedidoPorStatus() {
    return new ListagemDePedidoPorStatus(pedidoRepository);
  }
}
