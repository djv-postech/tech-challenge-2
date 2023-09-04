package com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.converter;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.json.Saque;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.json.QRCodeRequest;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.json.Item;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.json.QRCodeResponse;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class QRCodeRequestConverter {
  private static final String PEDIDO = "PEDIDO";
  private static final String UNIDADE_DE_MEDIDA = "unit";

  private static final Integer CASH_OUT = 0;

  public QRCodeRequest convertFrom(Pedido pedido) {

    QRCodeRequest QRCodeRequest = new QRCodeRequest();
    QRCodeRequest.setNumeroPedido(pedido.getNumeroPedido());
    QRCodeRequest.setTitulo(PEDIDO);
    QRCodeRequest.setValorTotal(pedido.getValorTotal().intValueExact());
    QRCodeRequest.setDescricao(
        pedido.getProdutos().stream()
            .map(Produto::getNome)
            .toList()
            .toString());

    QRCodeRequest.setItens(
        pedido.getProdutos().stream()
            .map(
                produto ->
                    new Item(
                        produto.getNome(),
                        produto.getPreco().intValueExact(),
                        produto.getQuantidade(),
                        UNIDADE_DE_MEDIDA,
                        (produto.getQuantidade() * produto.getPreco().intValueExact())))
            .collect(Collectors.toList()));

    QRCodeRequest.setSaque(new Saque(CASH_OUT));

    return QRCodeRequest;
  }

  public String convertFrom(QRCodeResponse response) {
    return response.getQrCode();
  }
}
