package com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagamento {

  private String id;
  private String idPedido;
  private BigDecimal totalPagamento;
  private TipoPagamento tipoPagamento;
  private LocalDateTime dataPagamento;
  private StatusPagamento statusPagamento;

   public Pagamento(
      String id,
      String idPedido,
      BigDecimal totalPagamento,
      TipoPagamento tipoPagamento,
       LocalDateTime dataPagamento,
      StatusPagamento statusPagamento) {

    this.id = id;
    this.idPedido = idPedido;
    this.totalPagamento = totalPagamento;
    this.tipoPagamento = tipoPagamento;
    this.dataPagamento = dataPagamento;
    this.statusPagamento = statusPagamento;
  }

  public Pagamento() {}

  public Pagamento(LocalDateTime dataPagamento, StatusPagamento statusPagamento, TipoPagamento tipoPagamento, BigDecimal totalPagamento) {
     this.dataPagamento = dataPagamento;
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

  public String getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(String idPedido) {
    this.idPedido = idPedido;
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

  public LocalDateTime getDataPagamento() {
    return dataPagamento;
  }

  public void setDataPagamento(LocalDateTime dataPagamento) {
    this.dataPagamento = dataPagamento;
  }

  public void setStatusPagamento(StatusPagamento statusPagamento) {
    this.statusPagamento = statusPagamento;
  }
}
