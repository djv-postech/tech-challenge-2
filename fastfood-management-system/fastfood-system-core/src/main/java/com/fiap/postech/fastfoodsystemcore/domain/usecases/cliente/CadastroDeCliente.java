package com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente;


import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;


public class CadastroDeCliente {

  private final ClienteRepository clienteRepository;

  public CadastroDeCliente(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  public Cliente cadastrar(Cliente cliente) {
   return this.clienteRepository.cadastrarCliente(cliente);
  }

}
