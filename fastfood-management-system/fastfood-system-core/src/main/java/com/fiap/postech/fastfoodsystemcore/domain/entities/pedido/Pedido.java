package com.fiap.postech.fastfoodsystemcore.domain.entities.pedido;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    private String id;
    private List<Produto> produtos;

    private Cliente cliente;
    private Pagamento pagamento;
    private StatusPedido statusPedido;
    private LocalDateTime dataCriacaoPedido;

    public Pedido(
            String id,
            Cliente cliente,
            List<Produto> produtos,
            Pagamento pagamento,
            StatusPedido statusPedido,
            LocalDateTime dataCriacaoPedido) {
        this.id = id;
        this.produtos = produtos;
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.statusPedido = statusPedido;
        this.dataCriacaoPedido = dataCriacaoPedido;
    }

    public Pedido(
            Cliente cliente,
            List<Produto> produtos,
            Pagamento pagamento,
            StatusPedido statusPedido,
            LocalDateTime dataCriacaoPedido) {
        this.produtos = produtos;
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.statusPedido = statusPedido;
        this.dataCriacaoPedido = dataCriacaoPedido;
    }

    public String getId() {
        return id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public LocalDateTime getDataCriacaoPedido() {
        return dataCriacaoPedido;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void setStatus(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}
