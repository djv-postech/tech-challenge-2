package com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.TipoPagamento;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ListagemDePagamento {
  public Pagamento retornarPagamento(String idPagamento) {
    return new Pagamento(
        idPagamento,
        UUID.randomUUID().toString(),
        new BigDecimal("30.00"),
        TipoPagamento.QRCODE,
        LocalDateTime.now(),
        StatusPagamento.PROCESSANDO);
  }

  public List<Pagamento> retornarPagamentosPorStatus(StatusPagamento status) {
    return List.of(new Pagamento());
  }
}
