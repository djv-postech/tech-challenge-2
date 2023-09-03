package com.fiap.postech.fastfoodsystemapi.api.pedido;

import com.fiap.postech.fastfoodsystemapi.api.pedido.records.DadosCadastroPedido;
import com.fiap.postech.fastfoodsystemapi.api.pedido.records.DadosPedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.AtualizacaoDePedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.CadastroDePedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.ListagemDePedidoOrdenadosPorRecebimentoEStatus;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.ListagemDePedidoPorNumeroDePedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.ListagemDePedidoPorStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
@Tag(name = "Pedidos", description = "Rest api para operações de pedidos")
public class PedidoController {

  private final CadastroDePedido cadastroDePedido;
  private final ListagemDePedidoPorNumeroDePedido listarPedidoPorNumeroPedido;
  private final ListagemDePedidoPorStatus listarPedidoPorStatus;

  private final ListagemDePedidoOrdenadosPorRecebimentoEStatus
      listagemDePedidoOrdenadosPorRecebimentoEStatus;
  private final AtualizacaoDePedido atualizacaoDePedido;

  public PedidoController(
      CadastroDePedido cadastroDePedido,
      ListagemDePedidoPorNumeroDePedido listarPedidoPorNumeroPedido,
      ListagemDePedidoPorStatus listarPedidoPorStatus,
      ListagemDePedidoOrdenadosPorRecebimentoEStatus listagemDePedidoOrdenadosPorRecebimentoEStatus,
      AtualizacaoDePedido atualizacaoDePedido) {
    this.cadastroDePedido = cadastroDePedido;
    this.listarPedidoPorNumeroPedido = listarPedidoPorNumeroPedido;
    this.listarPedidoPorStatus = listarPedidoPorStatus;
    this.listagemDePedidoOrdenadosPorRecebimentoEStatus =
        listagemDePedidoOrdenadosPorRecebimentoEStatus;
    this.atualizacaoDePedido = atualizacaoDePedido;
  }

  @Operation(summary = "Checkout de Pedidos")
  @PostMapping
  public ResponseEntity<DadosPedido> cadastrarPedido(
      @Valid @RequestBody DadosCadastroPedido dadosCadastroPedido) {

    Pedido pedidoCadastrado =
        cadastroDePedido.cadastrarPedido(dadosCadastroPedido.convertToPedido());

    DadosPedido dadosPedido = new DadosPedido(pedidoCadastrado);

    return ResponseEntity.ok().body(dadosPedido);
  }

  @Operation(summary = "Listar pedido por numeroPedido")
  @GetMapping("/{numeroPedido}")
  public ResponseEntity<DadosPedido> listarPedido(@PathVariable String numeroPedido) {
    Pedido pedido = listarPedidoPorNumeroPedido.listarPedidoPorNumeroPedido(numeroPedido);
    return Objects.nonNull(pedido)
        ? ResponseEntity.ok(new DadosPedido(pedido))
        : ResponseEntity.notFound().build();
  }

  @Operation(summary = "Listar pedidos por status")
  @GetMapping("/status/{status}")
  public ResponseEntity<List<DadosPedido>> listarPedidosPorStatus(
      @PathVariable("status") final StatusPedido statusPedido) {
    List<Pedido> pedidos = listarPedidoPorStatus.listarPedidoPorStatus(statusPedido);
    return ResponseEntity.ok(pedidos.stream().map(DadosPedido::new).collect(Collectors.toList()));
  }

  @Operation(summary = "Listar pedidos ordernados por recebimento e status")
  @GetMapping("/todos")
  public ResponseEntity<List<DadosPedido>> listarPedidos() {
    List<Pedido> pedidos =
        listagemDePedidoOrdenadosPorRecebimentoEStatus
            .listarPedidosOrdenadosPorRecebimentoEStatus();
    return ResponseEntity.ok(pedidos.stream().map(DadosPedido::new).collect(Collectors.toList()));
  }

  @Operation(summary = "Atualizar status do pedido")
  @PutMapping("/{numeroPedido}/{status}")
  public ResponseEntity<DadosPedido> atualizarStatusPedido(
      @PathVariable String numeroPedido, @PathVariable("status") final StatusPedido statusPedido) {
    Pedido pedido = atualizacaoDePedido.atualizarPedido(numeroPedido, statusPedido);
    return ResponseEntity.ok(new DadosPedido(pedido));
  }
}
