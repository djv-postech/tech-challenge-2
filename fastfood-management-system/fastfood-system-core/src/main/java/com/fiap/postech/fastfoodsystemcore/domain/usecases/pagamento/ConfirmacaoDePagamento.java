package com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;
import java.time.LocalDateTime;

public class ConfirmacaoDePagamento {

  public Pagamento confirmarPagamento(Pagamento pagamento, LocalDateTime dataHorarioConfirmacao) {
    pagamento.setStatusPagamento(StatusPagamento.APROVADO);
    pagamento.setDataEHorarioPagamento(dataHorarioConfirmacao);
    return pagamento;
  }
}
