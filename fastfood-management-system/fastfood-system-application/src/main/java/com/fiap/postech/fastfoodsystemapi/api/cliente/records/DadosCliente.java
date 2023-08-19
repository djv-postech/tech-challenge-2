package com.fiap.postech.fastfoodsystemapi.api.cliente.records;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;


public record DadosCliente(String nome, String cpf, String email) {

  public DadosCliente(Cliente dadosCliente) {
    this(dadosCliente.getNome(), dadosCliente.getCpf(), dadosCliente.getEmail().getEndereco());
  }
}
