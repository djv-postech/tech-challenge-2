package com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente;


import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;


public class CadastrarCliente {

  private final ClienteRepository clienteRepository;

  public CadastrarCliente(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  public void cadastrarCliente(Cliente cliente) {
    this.clienteRepository.cadastrarCliente(cliente);
  }


}
