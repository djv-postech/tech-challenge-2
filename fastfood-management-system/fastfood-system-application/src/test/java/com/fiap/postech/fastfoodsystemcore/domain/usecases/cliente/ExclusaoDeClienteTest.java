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
class ExclusaoDeClienteTest {
  @InjectMocks private ExclusaoDeCliente exclusaoDeCliente;

  @Mock private ClienteRepository clienteRepository;

  @DisplayName("Test - Deve excluir cliente por CPF")
  @Test
  public void dadoCPFDoCliente_EntaoDeveExcluirCliente() {
    // Dado
    final String cpf = "123.456.789-09";

    // Quando
    exclusaoDeCliente.excluirPorCpf(cpf);

    // Entao
    verify(clienteRepository, times(1)).excluirClientePorCpf(cpf);
  }
}
