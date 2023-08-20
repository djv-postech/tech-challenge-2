package com.fiap.postech.fastfoodsystemapi.api.pedido.records;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.StatusPagamento;

public record StatusPagamentoPedido(String numeroPedido, StatusPagamento statusPagamento) {


}
