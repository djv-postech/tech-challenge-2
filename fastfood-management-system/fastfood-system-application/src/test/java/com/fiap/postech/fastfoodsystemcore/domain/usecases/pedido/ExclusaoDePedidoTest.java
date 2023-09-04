package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente.ExclusaoDeCliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExclusaoDePedidoTest {
  @InjectMocks private ExclusaoDePedido exclusaoDePedido;
  @Mock private PedidoRepository pedidoRepository;

  @DisplayName("Test - Deve excluir pedido por numero do pedido")
  @Test
  public void dadoNumeroPedido_EntaoDeveExcluirPedido() {
    // Dado
    final String numeroPedido = "48937498749";

    // Quando
    exclusaoDePedido.excluirPedido(numeroPedido);

    // Entao
    verify(pedidoRepository, times(1)).excluirPedido(numeroPedido);
  }
}
