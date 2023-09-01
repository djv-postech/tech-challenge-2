package com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.converter;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.json.CashOut;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.json.QRCodeRequest;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.json.Item;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.json.QRCodeResponse;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class GerarQRCodeRequestConverter {
  public QRCodeRequest convertFrom(Pedido pedido) {

    QRCodeRequest QRCodeRequest = new QRCodeRequest();
    QRCodeRequest.setExternalReference(pedido.getNumeroPedido());
    QRCodeRequest.setTitle("Pedido");
    // TODO talvez tenhamos q rever o contrato :/ essa parte do total está meio em aberto
    QRCodeRequest.setTotalAmount(pedido.getPagamento().getTotalPagamento().intValueExact());
    QRCodeRequest.setDescription("Description");

    QRCodeRequest.setItems(
        pedido.getProdutos().stream()
            .map(
                produto ->
                    new Item(
                        produto.getNome(),
                        produto.getPreco().intValueExact(),
                        produto.getQuantidade(),
                        "unit",
                        (produto.getQuantidade() * produto.getPreco().intValueExact())))
            .collect(Collectors.toList()));

    QRCodeRequest.setCashOut(new CashOut(0));

    return QRCodeRequest;
  }

  public String convertFrom(QRCodeResponse response) {
    return response.getQrCode();
  }
}
