package com.fiap.postech.fastfoodsystemapi.api.cliente;


import com.fiap.postech.fastfoodsystemapi.api.cliente.records.DadosCadastroCliente;
import com.fiap.postech.fastfoodsystemapi.api.cliente.records.DadosCliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente.CadastrarCliente;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente.ListarClientes;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

  private final CadastrarCliente cadastrarCliente;
  private final ListarClientes listarClientes;

  public ClienteController(CadastrarCliente cadastrarCliente, ListarClientes listarClientes){
    this.cadastrarCliente = cadastrarCliente;
    this.listarClientes = listarClientes;
  }

  @Operation(summary = "Cadastra novo cliente")
  @PostMapping
  public ResponseEntity<?> cadastrarCliente(
          @Valid @RequestBody DadosCadastroCliente dadosCadastroCliente, UriComponentsBuilder builder) {

    cadastrarCliente.cadastrarCliente(dadosCadastroCliente.convertToCliente());

    return ResponseEntity.ok().build();
  }

//  @Operation(summary = "Identifica cliente pelo CPF")
//  @GetMapping("/{cpf}")
//  public ResponseEntity<DadosCliente> identificarCliente(@PathVariable String cpf) {
//    Cliente cliente = clienteServicePort.retornaClientePorCpf(cpf);
//
//    return Objects.nonNull(cliente)
//        ? ResponseEntity.ok(new DadosCliente(cliente))
//        : ResponseEntity.notFound().build();
//  }
//
//  @Operation(summary = "Deleta cliente por CPF")
//  @DeleteMapping("/{cpf}")
//  public ResponseEntity<DadosCliente> apagarCliente(@PathVariable String cpf){
//    clienteServicePort.removerCliente(cpf);
//
//    return ResponseEntity.ok().build();
//  }
//
//  @Operation(summary = "Atualiza cliente")
//  @PutMapping("/{cpf}")
//  public ResponseEntity<DadosCliente> atualizarCliente(@PathVariable String cpf, @Valid @RequestBody DadosCadastroCliente dadosCadastroCliente){
//    Cliente cliente = clienteServicePort.atualizarCliente(cpf, new Cliente(dadosCadastroCliente));
//    return ResponseEntity.ok(new DadosCliente(cliente));
//  }
//
  @Operation(summary = "Lista clientes")
  @GetMapping("/todos")
  public ResponseEntity<List<DadosCliente>> listarClientes(){
    List<Cliente> clientes = listarClientes.todos();
    return Objects.nonNull(clientes) ? ResponseEntity.ok(clientes.stream()
        .map(DadosCliente::new).collect(Collectors.toList())):
        ResponseEntity.notFound().build();
  }
}
