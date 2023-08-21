package com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;
import java.time.LocalDateTime;

public class CancelamentoDePagamento {

  public CancelamentoDePagamento(ListagemDePagamento listagemDePagamenoto) {
    this.listagemDePagamenoto = listagemDePagamenoto;
  }

  private final ListagemDePagamento listagemDePagamenoto;

  public Pagamento cancelarPagamento(String idPagamento) {
    Pagamento pagamento = listagemDePagamenoto.retornarPagamento(idPagamento);
    pagamento.setStatusPagamento(StatusPagamento.CANCELADO);
    pagamento.setDataPagamento(LocalDateTime.now());
    return pagamento;
  }
}
