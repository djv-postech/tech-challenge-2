package com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente;

import com.fiap.postech.fastfoodsystemcore.domain.ClienteNaoEncontradoException;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;

import java.util.Objects;

public class AtualizacaoDeCliente {

    private final ClienteRepository clienteRepository;

    public AtualizacaoDeCliente(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente atualizarCliente(String cpf, Cliente cliente) {
        Cliente clienteBanco = clienteRepository.identificaClientePorCpf(cpf);

        if (Objects.isNull(clienteBanco)) {
            throw new ClienteNaoEncontradoException("Cliente de CPF: " + cpf + " não encontrado");
        }

        clienteBanco.setNome(cliente.getNome());
        clienteBanco.setEmail(cliente.getEmail());

        return clienteRepository.atualizarCliente(clienteBanco);
    }
}
