package com.fiap.postech.fastfoodsystemapi.api.pagamento;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pagamento.CriacaoDePagamento;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.ListagemDePedidoPorNumeroDePedido;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
@Tag(name = "Pagamentos", description = "Rest api para operações de pagamentos")
public class PagamentoController {

  private final CriacaoDePagamento criacaoDePagamento;
  private final ListagemDePedidoPorNumeroDePedido listagemDePedidoPorNumeroDePedido;

  public PagamentoController(
      CriacaoDePagamento criacaoDePagamento,
      ListagemDePedidoPorNumeroDePedido listagemDePedidoPorNumeroDePedido) {
    this.criacaoDePagamento = criacaoDePagamento;
    this.listagemDePedidoPorNumeroDePedido = listagemDePedidoPorNumeroDePedido;
  }

  @Operation(summary = "Gerar qrCode para pagamento")
  @GetMapping("/{numeroPedido}")
  public ResponseEntity<String> gerarPagamento(@PathVariable String numeroPedido) {
    final Pedido pedido =
        listagemDePedidoPorNumeroDePedido.listarPedidoPorNumeroPedido(numeroPedido);
    final String qrCode = criacaoDePagamento.criarQrCodeParaPagamento(pedido);
    return ResponseEntity.ok(qrCode);
  }
}
