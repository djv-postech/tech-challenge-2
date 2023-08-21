package com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;

import java.time.LocalDateTime;

public class ConfirmacaoDePagamento {

  private final ListagemDePagamento listagemDePagamento;

  public ConfirmacaoDePagamento(ListagemDePagamento listagemDePagamento) {
    this.listagemDePagamento = listagemDePagamento;
  }

  public Pagamento confirmarPagamento(String idPagamento) {
    Pagamento pagamento = listagemDePagamento.retornarPagamento(idPagamento);
    pagamento.setStatusPagamento(StatusPagamento.APROVADO);
    pagamento.setDataPagamento(LocalDateTime.now());
    return pagamento;
  }
}
