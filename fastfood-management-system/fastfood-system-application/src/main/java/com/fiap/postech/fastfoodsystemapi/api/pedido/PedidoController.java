package com.fiap.postech.fastfoodsystemapi.api.pedido;

import com.fiap.postech.fastfoodsystemapi.api.pedido.records.DadosCadastroPedido;
import com.fiap.postech.fastfoodsystemapi.api.pedido.records.DadosPedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.CadastroDePedido;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
@Tag(name = "Pedidos", description = "Rest api para operações de pedidos")
public class PedidoController {

  private final CadastroDePedido cadastroDePedido;

//  @Operation(summary = "Cadastro de novos pedidos")
//  @PostMapping
//  public ResponseEntity<DadosPedido> cadastrarPedido(
//          @Valid @RequestBody DadosCadastroPedido dadosCadastroPedido) {
//    Pedido pedidoCadastrado = cadastroDePedido.cadastrarPedido(new Pedido(dadosCadastroPedido));
//
//    DadosPedido dadosPedido = new DadosPedido(pedidoCadastrado);
//    return ResponseEntity.ok().body(dadosPedido);
//  }
//
//  @Operation(summary = "Listagem de pedido por Id")
//  @GetMapping("/{id}")
//  public ResponseEntity<DadosPedido> listaPedido(@PathVariable String id) {
//    Pedido pedido = pedidoServicePort.listarPedidoPorId(id);
//    return Objects.nonNull(pedido)
//        ? ResponseEntity.ok(new DadosPedido(pedido))
//        : ResponseEntity.notFound().build();
//  }
//
//  @Operation(summary = "Listagem de pedidos por status")
//  @GetMapping("/status/{status}")
//  public ResponseEntity<List<DadosPedido>> listaPedidosPorStatus(
//      @PathVariable("status") final StatusPedido statusPedido) {
//    List<Pedido> pedidos = pedidoServicePort.listarPedidosPorStatus(statusPedido);
//    return ResponseEntity.ok(pedidos.stream().map(DadosPedido::new).collect(Collectors.toList()));
//  }
//
//  @Operation(summary = "Listagem de todos os pedidos")
//  @GetMapping("/todos")
//  public ResponseEntity<List<DadosPedido>> listaTodosPedidos() {
//    List<Pedido> pedidos = pedidoServicePort.listarTodosPedidos();
//    return ResponseEntity.ok(pedidos.stream().map(DadosPedido::new).collect(Collectors.toList()));
//  }
//
//  //FIXME O Status deve ser enviado em um request param?
//  @Operation(summary = "Atualização do status do pedido")
//  @PutMapping("/{id}/{status}")
//  public ResponseEntity<DadosPedido> atualizarStatusPedido(
//      @PathVariable String id, @PathVariable("status") final StatusPedido statusPedido) {
//    Pedido pedido = pedidoServicePort.atualizarStatusPedido(id, statusPedido);
//    return ResponseEntity.ok(new DadosPedido(pedido));
//  }
}
