package com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;

import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.AtualizacaoDePedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.ListagemDePedidoPorNumeroDePedido;
import java.time.LocalDateTime;

public class ConfirmacaoDePagamento {



  public Pagamento confirmarPagamento(Pagamento pagamento, LocalDateTime horarioConfirmacao) {
    pagamento.setStatusPagamento(StatusPagamento.APROVADO);
    pagamento.setDataPagamento(LocalDateTime.now());
    return pagamento;
  }
}
