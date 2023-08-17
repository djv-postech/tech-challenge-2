package com.fiap.postech.fastfoodsystemcore.domain.entities.cliente;

import java.util.List;

public interface ClienteRepository {
  void cadastrarCliente(Cliente cliente);

  Cliente retornarClientePorCpf(String CPF);

  void removerCliente(String CPF);

  Cliente atualizarCliente(Cliente cliente);

  List<Cliente> listarClientes();
}
