package com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento;

import java.util.List;
//FIXME Deletar ? Temos necessidade de ter um repository para pagamentos?
public interface PagamentoRepository {

  Pagamento confirmarPagamento(String idPagamento);

  Pagamento cancelarPagamento(String idPagamento);

  Pagamento retornarPagamento(String idPagamento);

  List<Pagamento> retornarPagamentosPorStatus(StatusPagamento status);
}
