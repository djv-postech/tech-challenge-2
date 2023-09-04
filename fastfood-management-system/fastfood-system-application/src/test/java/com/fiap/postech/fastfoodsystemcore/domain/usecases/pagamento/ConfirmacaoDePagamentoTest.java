package com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento;

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
class ConfirmacaoDePagamentoTest {
  @InjectMocks private ConfirmacaoDePagamento confirmacaoDePagamento;

  @DisplayName("Test - Deve confirmar pagamento")
  @Test
  public void dadoPagamento_EntaoDeveAlterarStatusDoPagamentoParaConfirmado() {
    // Dado
    final LocalDateTime dataHorarioDeConfirmacao = LocalDateTime.now();
    final Pagamento pagamento =
        new Pagamento(
            "3434353463563342",
            new BigDecimal("30.00"),
            TipoPagamento.QRCODE,
            LocalDateTime.now(),
            StatusPagamento.PROCESSANDO);

    // Quando
    final Pagamento pagamentoConfirmado =
        confirmacaoDePagamento.confirmarPagamento(pagamento, dataHorarioDeConfirmacao);

    // Então
    Assertions.assertThat(pagamentoConfirmado.getStatusPagamento())
        .isEqualTo(StatusPagamento.APROVADO);
    Assertions.assertThat(pagamentoConfirmado.getDataEHorarioPagamento())
        .isEqualTo(dataHorarioDeConfirmacao);
  }
}
