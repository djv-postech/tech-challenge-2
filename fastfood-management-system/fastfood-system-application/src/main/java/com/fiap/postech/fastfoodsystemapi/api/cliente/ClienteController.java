package com.fiap.postech.fastfoodsystemapi.api.cliente;


import com.fiap.postech.fastfoodsystemapi.api.cliente.records.DadosCadastroCliente;
import com.fiap.postech.fastfoodsystemapi.api.cliente.records.DadosCliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente.*;
import com.fiap.postech.fastfoodsystemcore.domain.vo.CPF;
import com.fiap.postech.fastfoodsystemcore.domain.vo.Email;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@Tag(name = "Clientes", description = "Rest api para operações de clientes")
public class ClienteController {

  private final CadastroDeCliente cadastroDeCliente;
  private final ListagemDeCliente listagemDeCliente;
  private final IdentificacaoDeCliente identificacaoDeCliente;
  private final ExclusaoDeCliente exclusaoDeCliente;
  private final AtualizacaoDeCliente atualizacaoDeCliente;

  public ClienteController(CadastroDeCliente cadastroDeCliente,
                           ListagemDeCliente listagemDeCliente,
                           IdentificacaoDeCliente identificacaoDeCliente,
                           ExclusaoDeCliente exclusaoDeCliente,
                           AtualizacaoDeCliente atualizacaoDeCliente){
    this.cadastroDeCliente = cadastroDeCliente;
    this.listagemDeCliente = listagemDeCliente;
    this.identificacaoDeCliente = identificacaoDeCliente;
    this.exclusaoDeCliente = exclusaoDeCliente;
    this.atualizacaoDeCliente = atualizacaoDeCliente;
  }

  @Operation(summary = "Cadastrar novo cliente")
  @PostMapping
  public ResponseEntity<DadosCliente> cadastrar(
          @Valid @RequestBody DadosCadastroCliente dadosCadastroCliente) {

    Cliente dadosCliente = cadastroDeCliente.cadastrar(dadosCadastroCliente.convertToCliente());

    return ResponseEntity.ok(new DadosCliente(dadosCliente.getNome(),
            dadosCliente.getCpf(), dadosCliente.getEmail().getEndereco()));
  }

  @Operation(summary = "Identificar cliente pelo CPF")
  @GetMapping("/{cpf}")
  public ResponseEntity<DadosCliente> identificarPorCpf(@PathVariable String cpf) {

    Cliente cliente = identificacaoDeCliente.identificarPorCpf(cpf);

    return Objects.nonNull(cliente)
        ? ResponseEntity.ok(new DadosCliente(cliente))
        : ResponseEntity.notFound().build();
  }

  @Operation(summary = "Remover cliente por CPF")
  @DeleteMapping("/{cpf}")
  public ResponseEntity<DadosCliente> excluirPorCpf(@PathVariable String cpf){
    exclusaoDeCliente.excluirPorCpf(cpf);
    return ResponseEntity.ok().build();
  }

  @Operation(summary = "Atualizar cliente")
  @PutMapping("/{cpf}")
  public ResponseEntity<DadosCliente> atualizarCliente(@PathVariable String cpf, @Valid @RequestBody DadosCadastroCliente dadosCadastroCliente){
    Cliente cliente = atualizacaoDeCliente.atualizarCliente(cpf,
            new Cliente(dadosCadastroCliente.nome(), new CPF(dadosCadastroCliente.cpf()), new Email(dadosCadastroCliente.email())));
    return ResponseEntity.ok(new DadosCliente(cliente));
  }

  @Operation(summary = "Listar clientes")
  @GetMapping("/todos")
  public ResponseEntity<List<DadosCliente>> listarClientes(){
    List<Cliente> clientes = listagemDeCliente.todos();
    return Objects.nonNull(clientes) ? ResponseEntity.ok(clientes.stream()
        .map(DadosCliente::new).collect(Collectors.toList())):
        ResponseEntity.notFound().build();
  }
}
