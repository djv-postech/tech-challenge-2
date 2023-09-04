package com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListagemDeClienteTest {
  @InjectMocks private ListagemDeCliente listagemDeCliente;

  @Mock private ClienteRepository clienteRepository;

  @DisplayName("Test - Deve listar todos clientes")
  @Test
  public void quandoBuscarClientes_EntaoDeveRetornarTodosClientesCadastrados() {
    // Quando
    listagemDeCliente.todos();

    // Então
    verify(clienteRepository, times(1)).listarClientes();
  }
}
