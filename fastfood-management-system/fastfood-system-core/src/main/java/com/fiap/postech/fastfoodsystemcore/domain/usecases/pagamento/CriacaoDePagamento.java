package com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.CashOut;
import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.GerarQRCodeRequest;
import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.Item;
import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.MercadoPagoGateway;
import com.fiap.postech.fastfoodsystemcore.domain.mercadoPago.QRCodeResponse;
import java.util.stream.Collectors;

public class CriacaoDePagamento {

  private final MercadoPagoGateway mercadoPagoGateway;

  public CriacaoDePagamento(MercadoPagoGateway mercadoPagoGateway) {
    this.mercadoPagoGateway = mercadoPagoGateway;
  }

  public String criarQrCodeParaPagamento(Pedido pedido) {
    // FIXME Gerar converter
    GerarQRCodeRequest gerarQRCodeRequest = new GerarQRCodeRequest();
    gerarQRCodeRequest.setExternalReference(pedido.getNumeroPedido());
    gerarQRCodeRequest.setTitle("Pedido");
    // TODO talvez tenhamos q rever o contrato :/ essa parte do total está meio em aberto
    gerarQRCodeRequest.setTotalAmount(pedido.getPagamento().getTotalPagamento().intValueExact());
    gerarQRCodeRequest.setDescription("Description");

    gerarQRCodeRequest.setItems(
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

    gerarQRCodeRequest.setCashOut(new CashOut(0));

    final QRCodeResponse response = mercadoPagoGateway.gerarQRCode(
        gerarQRCodeRequest);
    return response.getQrCode();
  }
}
