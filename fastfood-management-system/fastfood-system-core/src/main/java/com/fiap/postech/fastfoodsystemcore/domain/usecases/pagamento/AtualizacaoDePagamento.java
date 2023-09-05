package com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AtualizacaoDePagamento {

  public Pagamento atualizarPagamento(Pagamento pagamento, BigDecimal totalPagamento) {
    pagamento.setStatusPagamento(StatusPagamento.PROCESSANDO);
    pagamento.setDataEHorarioPagamento(LocalDateTime.now());
    pagamento.setTotalPagamento(totalPagamento);
    return pagamento;
  }
}
