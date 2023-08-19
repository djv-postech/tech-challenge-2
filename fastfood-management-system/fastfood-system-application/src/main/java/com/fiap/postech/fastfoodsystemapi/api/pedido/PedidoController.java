package com.fiap.postech.fastfoodsystemapi.api.pedido;

import com.fiap.postech.fastfoodsystemapi.api.pedido.records.DadosCadastroPedido;
import com.fiap.postech.fastfoodsystemapi.api.pedido.records.DadosPedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.AtualizacaoDePedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.CadastroDePedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.ExclusaoDePedido;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.ListagemDePedido;
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
  private final ListagemDePedido listagemDePedido;
  private final AtualizacaoDePedido atualizacaoDePedido;

  @Operation(summary = "Cadastro de novos pedidos")
  @PostMapping
  public ResponseEntity<DadosPedido> cadastrarPedido(
          @Valid @RequestBody DadosCadastroPedido dadosCadastroPedido) {
    Pedido pedidoCadastrado = cadastroDePedido.cadastrarPedido(dadosCadastroPedido.convertToPedido());

    DadosPedido dadosPedido = new DadosPedido(pedidoCadastrado);
    return ResponseEntity.ok().body(dadosPedido);
  }

  @Operation(summary = "Listagem de pedido por Id")
  @GetMapping("/{id}")
  public ResponseEntity<DadosPedido> listarPedido(@PathVariable String id) {
    Pedido pedido = listagemDePedido.listarPedidoPorId(id);
    return Objects.nonNull(pedido)
        ? ResponseEntity.ok(new DadosPedido(pedido))
        : ResponseEntity.notFound().build();
  }

  @Operation(summary = "Listagem de pedidos por status")
  @GetMapping("/status/{status}")
  public ResponseEntity<List<DadosPedido>> listarPedidosPorStatus(
      @PathVariable("status") final StatusPedido statusPedido) {
    List<Pedido> pedidos = listagemDePedido.listarPedidoPorStatus(statusPedido);
    return ResponseEntity.ok(pedidos.stream().map(DadosPedido::new).collect(Collectors.toList()));
  }

  @Operation(summary = "Listagem de todos os pedidos")
  @GetMapping("/todos")
  public ResponseEntity<List<DadosPedido>> listarPedidos() {
    List<Pedido> pedidos = listagemDePedido.listarPedidos();
    return ResponseEntity.ok(pedidos.stream().map(DadosPedido::new).collect(Collectors.toList()));
  }

  //FIXME O Status deve ser enviado em um request param?
  @Operation(summary = "Atualização do status do pedido")
  @PutMapping("/{id}/{status}")
  public ResponseEntity<DadosPedido> atualizarStatusPedido(
      @PathVariable String id, @PathVariable("status") final StatusPedido statusPedido) {
    Pedido pedido = atualizacaoDePedido.atualizarPedido(id, statusPedido);
    return ResponseEntity.ok(new DadosPedido(pedido));
  }
}
