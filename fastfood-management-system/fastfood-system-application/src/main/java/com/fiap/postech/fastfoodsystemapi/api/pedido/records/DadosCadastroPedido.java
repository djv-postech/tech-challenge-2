package com.fiap.postech.fastfoodsystemapi.api.pedido.records;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fiap.postech.fastfoodsystemapi.api.cliente.records.DadosCadastroCliente;
import com.fiap.postech.fastfoodsystemapi.api.pagamento.records.DadosCadastroPagamento;
import com.fiap.postech.fastfoodsystemapi.api.produto.records.DadosCadastroProduto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DadosCadastroPedido(
    DadosCadastroCliente cliente,
    @NotNull List<DadosCadastroProduto> produtos,
    @NotNull DadosCadastroPagamento pagamento,
    @NotNull StatusPedido statusPedido,
    @NotNull @JsonSerialize(using = LocalDateTimeSerializer.class)
        LocalDateTime dataCriacaoPedido) {}
