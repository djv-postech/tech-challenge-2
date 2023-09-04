package com.fiap.postech.fastfoodsystemapi.api.pagamento;

import com.fiap.postech.fastfoodsystemapi.api.pedido.records.StatusPagamentoPedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pagamento.Pagamento;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento.ConfirmacaoDePagamento;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento.CriacaoDePagamento;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.AtualizacaoDePedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.ListagemDePedidoPorNumeroDePedido;
import com.fiap.postech.fastfoodsysteminfra.gateway.feign.mercadopago.json.ConfirmacaoDePagamentoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
@Tag(name = "Pagamentos", description = "Rest api para operações de pagamentos")
public class PagamentoController {

  private final CriacaoDePagamento criacaoDePagamento;
  private final ConfirmacaoDePagamento confirmacaoDePagamento;
  private final ListagemDePedidoPorNumeroDePedido listagemDePedidoPorNumeroDePedido;
  private final AtualizacaoDePedido atualizacaoDePedido;

  public PagamentoController(
      CriacaoDePagamento criacaoDePagamento,
      ConfirmacaoDePagamento confirmacaoDePagamento,
      ListagemDePedidoPorNumeroDePedido listagemDePedidoPorNumeroDePedido,
      AtualizacaoDePedido atualizacaoDePedido) {
    this.criacaoDePagamento = criacaoDePagamento;
    this.confirmacaoDePagamento = confirmacaoDePagamento;
    this.listagemDePedidoPorNumeroDePedido = listagemDePedidoPorNumeroDePedido;
    this.atualizacaoDePedido = atualizacaoDePedido;
  }

  @Operation(summary = "Gerar QRCode para pagamento")
  @GetMapping("/{numeroPedido}")
  public ResponseEntity<String> gerarPagamento(@PathVariable String numeroPedido) {
    final Pedido pedido =
        listagemDePedidoPorNumeroDePedido.listarPedidoPorNumeroPedido(numeroPedido);
    final String qrCode = criacaoDePagamento.gerarQrCodeParaPagamento(pedido);
    return ResponseEntity.ok(qrCode);
  }

  @Operation(summary = "Consultar status do pagamento do pedido")
  @GetMapping("/{numeroPedido}/statusPagamento")
  public ResponseEntity<StatusPagamentoPedido> verificarStatusPagamentoPedido(
      @PathVariable String numeroPedido) {
    Pedido pedido = listagemDePedidoPorNumeroDePedido.listarPedidoPorNumeroPedido(numeroPedido);

    return ResponseEntity.ok(
        new StatusPagamentoPedido(numeroPedido, pedido.getPagamento().getStatusPagamento()));
  }

  @Operation(summary = "Webhook para confirmação de pagamento")
  @PostMapping("/confirmacaoPagamento")
  public ResponseEntity<StatusPagamentoPedido> confirmarPagamento(
      @RequestBody ConfirmacaoDePagamentoRequest confirmacaoDePagamentoRequest) {
    final String numeroPedido = confirmacaoDePagamentoRequest.getDadosDoPagamento().getId();

    final Pedido pedido =
        listagemDePedidoPorNumeroDePedido.listarPedidoPorNumeroPedido(numeroPedido);

    final Pagamento pagamento =
        confirmacaoDePagamento.confirmarPagamento(
            pedido.getPagamento(), confirmacaoDePagamentoRequest.getDataHoraDeConfirmacao());

    atualizacaoDePedido.atualizarPedido(numeroPedido, pagamento);

    return ResponseEntity.ok(
        new StatusPagamentoPedido(numeroPedido, pagamento.getStatusPagamento()));
  }
}
