package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListagemDePedidoPorStatusTest {
  @InjectMocks private ListagemDePedidoPorStatus listagemDePedidoPorStatus;

  @Mock private PedidoRepository pedidoRepository;

  @DisplayName("Test - Deve listar pedidos por status")
  @Test
  public void dadoStatus_deveListarPedidosPorStatus() {
    // Dado
    final StatusPedido status = StatusPedido.EM_PREPARACAO;

    // Quando
    listagemDePedidoPorStatus.listarPedidoPorStatus(status);

    // Entao
    verify(pedidoRepository, times(1)).listarPedidosPorStatus(status);
  }
}
