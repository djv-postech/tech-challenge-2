package com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.TipoPagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Categoria;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.MercadoPagoGateway;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CriacaoDePagamentoTest {
  @InjectMocks private CriacaoDePagamento criacaoDePagamento;

  @Mock private MercadoPagoGateway mercadoPagoGateway;

  @DisplayName("Test - Deve criar pagamento")
  @Test
  public void dadoPedido_EntaoGerarQRCodeParaPagamento() {
    // Dado
    // Dado
    Produto produto =
        new Produto(
            "1", "big mac", "pao, hamburguer e queijo", new BigDecimal("1"), 3, Categoria.LANCHE);
    Pagamento pagamento =
        new Pagamento(
            "3434353463563342",
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

    // Quando
    criacaoDePagamento.gerarQrCodeParaPagamento(pedido);

    // Entao
    verify(mercadoPagoGateway, times(1)).gerarQRCode(pedido);

  }
}
