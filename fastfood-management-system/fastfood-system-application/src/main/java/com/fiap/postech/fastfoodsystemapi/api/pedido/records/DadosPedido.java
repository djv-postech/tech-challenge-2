package com.fiap.postech.fastfoodsystemapi.api.pedido.records;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fiap.postech.fastfoodsystemapi.api.cliente.records.DadosCliente;
import com.fiap.postech.fastfoodsystemapi.api.pagamento.records.DadosPagamento;
import com.fiap.postech.fastfoodsystemapi.api.produto.records.DadosProduto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static java.util.Objects.isNull;

public record DadosPedido(
    String id,
    List<DadosProduto> produtos,

    @JsonInclude(NON_NULL) DadosCliente cliente,
    DadosPagamento pagamento,
    StatusPedido status,
    LocalDateTime dataCriacaoPedido) {

  public DadosPedido(Pedido dadosPedido) {
    this(
        dadosPedido.getNumeroPedido(),
        dadosPedido.getProdutos().stream().map(DadosProduto::new).collect(
            Collectors.toList()),
        isNull(dadosPedido.getCliente())? null: new DadosCliente(dadosPedido.getCliente()),
        new DadosPagamento(dadosPedido.getPagamento()),
        dadosPedido.getStatusPedido(),
        dadosPedido.getDataCriacaoPedido());
  }
}
