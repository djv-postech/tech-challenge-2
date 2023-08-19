package com.fiap.postech.fastfoodsysteminfra.persistence.repository.entity;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Document(collection = "pedidos")
public class PedidoEntity {

    @Id
    private String id;
    private List<Produto> produtos;
    private Cliente cliente;
    private Pagamento pagamento;
    private StatusPedido statusPedido;
    private LocalDateTime dataCriacaoPedido;

    public PedidoEntity(Pedido pedido) {
        this.id = pedido.getId();
        this.produtos = pedido.getProdutos();
        this.cliente = pedido.getCliente();
        this.pagamento = pedido.getPagamento();
        this.statusPedido = pedido.getStatusPedido();
        this.dataCriacaoPedido = pedido.getDataCriacaoPedido();
    }

    public PedidoEntity(
            String id,
            List<Produto> produtos,
            Cliente cliente,
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

    public PedidoEntity(){

    }

    public String getId() {
        return id;
    }

    public List<Produto> getProdutos() {
        return produtos;
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

    public Cliente getCliente() {
        return cliente;
    }
}