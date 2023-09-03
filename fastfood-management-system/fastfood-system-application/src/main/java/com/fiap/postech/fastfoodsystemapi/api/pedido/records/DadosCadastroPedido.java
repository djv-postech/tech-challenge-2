package com.fiap.postech.fastfoodsystemapi.api.pedido.records;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fiap.postech.fastfoodsystemapi.api.cliente.records.DadosCadastroCliente;
import com.fiap.postech.fastfoodsystemapi.api.pagamento.records.DadosCadastroPagamento;
import com.fiap.postech.fastfoodsystemapi.api.produto.records.DadosCadastroProduto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsystemcore.domain.vo.CPF;
import com.fiap.postech.fastfoodsystemcore.domain.vo.Email;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DadosCadastroPedido(
    DadosCadastroCliente cliente,
    @NotNull List<DadosCadastroProduto> cadastroProdutos,

    @NotNull BigDecimal valorTotal,

    @NotNull DadosCadastroPagamento pagamento,
    @NotNull StatusPedido statusPedido,
    @NotNull @JsonSerialize(using = LocalDateTimeSerializer.class)
        LocalDateTime dataCriacaoPedido) {

        public Pedido convertToPedido() {
                return new Pedido(
                        new Cliente(cliente.nome(),new CPF(cliente.cpf()), new Email(cliente.email())),
                        buildProdutos(cadastroProdutos),
                        valorTotal,
                        new Pagamento(pagamento.dataPagamento(), pagamento.statusPagamento(), pagamento.tipoPagamento(), pagamento.totalPagamento()),
                        statusPedido, dataCriacaoPedido);
        }

        private List<Produto> buildProdutos(List<DadosCadastroProduto> cadastroProdutos) {
              return cadastroProdutos.stream()
                         .map(cadastroProduto -> new Produto(cadastroProduto.nome(), cadastroProduto.descricao(),
                                 cadastroProduto.categoria(),cadastroProduto.preco(), cadastroProduto.quantidade())).collect(Collectors.toList());
        }
}
