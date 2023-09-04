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
class IdentificacaoDeClienteTest {
  @InjectMocks private IdentificacaoDeCliente identificacaoDeCliente;

  @Mock private ClienteRepository clienteRepository;

  @DisplayName("Test - Retornar cliente por CPF")
  @Test
  public void dadoCPF_QuandoBuscarCliente_EntaoDeveRetornarClienteCadastrado() {
    // Dado
    final String cpf = "123.456.789.09";
    final Cliente cliente =
        new Cliente("Cliente", new CPF("123.456.789-09"), new Email("cliente@email.com"));

    given(clienteRepository.identificaClientePorCpf(cpf)).willReturn(cliente);

    // Quando
    Cliente clienteIdentificado = identificacaoDeCliente.identificarPorCpf(cpf);

    // Entao
    Assertions.assertThat(cliente).isNotNull();
    Assertions.assertThat(clienteIdentificado.getEmail()).isEqualTo(cliente.getEmail());
    Assertions.assertThat(clienteIdentificado.getCpf()).isEqualTo(cliente.getCpf());
  }
}
