package com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;
import java.time.LocalDateTime;

public class CancelamentoDePagamento {

  public Pagamento cancelarPagamento(Pagamento pagamento) {
    pagamento.setStatusPagamento(StatusPagamento.CANCELADO);
    pagamento.setDataEHorarioPagamento(LocalDateTime.now());
    return pagamento;
  }
}
