package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListagemDePedidoPorNumeroDePedidoTest {
  @InjectMocks private ListagemDePedidoPorNumeroDePedido listagemDePedidoPorNumeroDePedido;

  @Mock private PedidoRepository pedidoRepository;

  @DisplayName("Test - Deve listar pedido por numero de pedido")
  @Test
  public void dadoNumeroDoPedido_deveListarPedido() {
    // Dado
    final String numeroPedido = "4234234";
    // Quando
    listagemDePedidoPorNumeroDePedido.listarPedidoPorNumeroPedido(numeroPedido);

    // Entao
    verify(pedidoRepository, times(1)).listarPedidoPorNumeroPedido(numeroPedido);
  }
}
