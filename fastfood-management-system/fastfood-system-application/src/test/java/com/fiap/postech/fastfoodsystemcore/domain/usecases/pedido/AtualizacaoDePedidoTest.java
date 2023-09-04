package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.TipoPagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Categoria;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AtualizacaoDePedidoTest {

  @InjectMocks private AtualizacaoDePedido atualizacaoDePedido;
  @Mock private PedidoRepository pedidoRepository;

  @DisplayName("Test - Deve atualizar status do pedido")
  @Test
  public void dadoIdEStatusPedido_QuandoAtualizarPedido_EntaoDeveRetornarPedidoAtualizado() {
    // Dado
    final Produto produto =
        new Produto(
            "1", "big mac", "pao, hamburguer e queijo", new BigDecimal("1"), 3, Categoria.LANCHE);
    final Pagamento pagamento =
        new Pagamento(
            "3434353463563342",
            new BigDecimal("30.00"),
            TipoPagamento.QRCODE,
            LocalDateTime.now(),
            StatusPagamento.APROVADO);

    final Pedido pedido =
        new Pedido(
            "IdPedido",
            null,
            List.of(produto),
            BigDecimal.valueOf(30.00),
            pagamento,
            StatusPedido.RECEBIDO,
            LocalDateTime.now());

    given(pedidoRepository.listarPedidoPorNumeroPedido("IdPedido")).willReturn(pedido);
    given(pedidoRepository.atualizarPedido(pedido)).willReturn(pedido);

    // Quando
    Pedido pedidoAtualizado =
        atualizacaoDePedido.atualizarPedido("IdPedido", StatusPedido.FINALIZADO);

    // Entao
    Assertions.assertThat(pedidoAtualizado).isNotNull();
    Assertions.assertThat(pedidoAtualizado.getNumeroPedido()).isEqualTo(pedido.getNumeroPedido());
  }
}
