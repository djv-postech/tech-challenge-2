package com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento;

import static org.junit.jupiter.api.Assertions.*;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.TipoPagamento;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CancelamentoDePagamentoTest {

  @InjectMocks private CancelamentoDePagamento cancelamentoDePagamento;

  @DisplayName("Test - Deve cancelar pagamento")
  @Test
  public void dadoPagamento_EntaoDeveAlterarStatusDoPagamentoParaCancelado() {
    // Dado
    Pagamento pagamento =
        new Pagamento(
            "3434353463563342",
            new BigDecimal("30.00"),
            TipoPagamento.QRCODE,
            LocalDateTime.now(),
            StatusPagamento.PROCESSANDO);

    // Quando

    final Pagamento pagamentoCancelado = cancelamentoDePagamento.cancelarPagamento(pagamento);

    // Então
    Assertions.assertThat(pagamentoCancelado.getStatusPagamento())
        .isEqualTo(StatusPagamento.CANCELADO);
  }
}
