package com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Pagamento {

  private String id;
  private BigDecimal totalPagamento;
  private TipoPagamento tipoPagamento;
  private LocalDateTime dataEHorarioPagamento;
  private StatusPagamento statusPagamento;

  public Pagamento(
      String id,
      BigDecimal totalPagamento,
      TipoPagamento tipoPagamento,
      LocalDateTime dataEHorarioPagamento,
      StatusPagamento statusPagamento) {

    this.id = id;
    this.totalPagamento = totalPagamento;
    this.tipoPagamento = tipoPagamento;
    this.dataEHorarioPagamento = dataEHorarioPagamento;
    this.statusPagamento = statusPagamento;
  }

  public Pagamento() {}

  public Pagamento(
      LocalDateTime dataEHorarioPagamento,
      StatusPagamento statusPagamento,
      TipoPagamento tipoPagamento,
      BigDecimal totalPagamento) {
    this.id = UUID.randomUUID().toString();
    this.dataEHorarioPagamento = dataEHorarioPagamento;
    this.statusPagamento = statusPagamento;
    this.tipoPagamento = tipoPagamento;
    this.totalPagamento = totalPagamento;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BigDecimal getTotalPagamento() {
    return totalPagamento;
  }

  public StatusPagamento getStatusPagamento() {
    return statusPagamento;
  }

  public void setTotalPagamento(BigDecimal totalPagamento) {
    this.totalPagamento = totalPagamento;
  }

  public TipoPagamento getTipoPagamento() {
    return tipoPagamento;
  }

  public void setTipoPagamento(TipoPagamento tipoPagamento) {
    this.tipoPagamento = tipoPagamento;
  }

  public LocalDateTime getDataEHorarioPagamento() {
    return dataEHorarioPagamento;
  }

  public void setDataEHorarioPagamento(LocalDateTime dataEHorarioPagamento) {
    this.dataEHorarioPagamento = dataEHorarioPagamento;
  }

  public void setStatusPagamento(StatusPagamento statusPagamento) {
    this.statusPagamento = statusPagamento;
  }
}
