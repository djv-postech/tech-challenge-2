package com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;
import com.fiap.postech.fastfoodsystemcore.domain.vo.CPF;
import com.fiap.postech.fastfoodsystemcore.domain.vo.Email;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AtualizacaoDeClienteTest {

  @InjectMocks private AtualizacaoDeCliente atualizacaoDeCliente;

  @Mock private ClienteRepository clienteRepository;

  @DisplayName("Test - Deve atualizar email do cliente")
  @Test
  public void
      dadoIDDoClienteENovoEmailDoCliente_QuandoAtualizarCLiente_EntaoDeveRetornarClienteAtualizado() {
    // Dado
    Cliente cliente =
        new Cliente("Cliente", new CPF("123.456.789-09"), new Email("cliente@email.com"));

    given(clienteRepository.identificaClientePorCpf("123.456.789-09")).willReturn(cliente);
    given(clienteRepository.atualizarCliente(cliente)).willReturn(cliente);

    // Quando
    Cliente clienteAtualizado = atualizacaoDeCliente.atualizarCliente("123.456.789-09", cliente);

    // Entao
    Assertions.assertThat(cliente).isNotNull();
    Assertions.assertThat(clienteAtualizado.getEmail()).isEqualTo(cliente.getEmail());
  }
}
