package com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
class InformacoesDePagamentoDoPedidoTest {
  @InjectMocks private InformacoesDePagamentoDoPedido informacoesDePagamentoDoPedido;
  @Mock private PedidoRepository pedidoRepository;

  @DisplayName("Test - Deve retornar informacoes do pagamento por numero do pedido")
  @Test
  public void dadoNumeroPedido_EntaoDeveRetornarInformacoesDoPagamento() {
    // Dado
    final String numeroPedido = "3244234324";
    // Dado
    Produto produto =
        new Produto(
            "1", "big mac", "pao, hamburguer e queijo", new BigDecimal("1"), 3, Categoria.LANCHE);
    Pagamento pagamento =
        new Pagamento(
            "3244234324",
            new BigDecimal("30.00"),
            TipoPagamento.QRCODE,
            LocalDateTime.now(),
            StatusPagamento.APROVADO);

    Pedido pedido =
        new Pedido(
            "IdPedido",
            null,
            List.of(produto),
            BigDecimal.valueOf(30.00),
            pagamento,
            StatusPedido.RECEBIDO,
            LocalDateTime.now());

    given(pedidoRepository.listarPedidoPorNumeroPedido(numeroPedido)).willReturn(pedido);

    // Quando
    final StatusPagamento statusPagamento =
        informacoesDePagamentoDoPedido.verificaStatusPagamentoPedido(numeroPedido);

    // Entao
    verify(pedidoRepository, times(1)).listarPedidoPorNumeroPedido(numeroPedido);
    Assertions.assertThat(statusPagamento).isNotNull();
    Assertions.assertThat(statusPagamento).isEqualTo(pagamento.getStatusPagamento());
  }
}
