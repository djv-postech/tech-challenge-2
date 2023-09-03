package com.fiap.postech.fastfoodsystemapi.api.pagamento.records;


import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.TipoPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DadosPagamento(
    String id,
    BigDecimal totalPagamento,
    TipoPagamento tipoPagamento,
    LocalDateTime dataPagamento,
    StatusPagamento statusPagamento) {

  public DadosPagamento(Pagamento dadosPagamento) {
    this(
        dadosPagamento.getId(),
        dadosPagamento.getTotalPagamento(),
        dadosPagamento.getTipoPagamento(),
        dadosPagamento.getDataPagamento(),
        dadosPagamento.getStatusPagamento());
  }
}
