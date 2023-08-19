package com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;

public class AtualizacaoDeCliente {

    private final ClienteRepository clienteRepository;

    public AtualizacaoDeCliente(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente atualizarCliente(String cpf, Cliente cliente) {
        Cliente clienteBanco = clienteRepository.identificaClientePorCpf(cpf);

        clienteBanco.setNome(cliente.getNome());
        clienteBanco.setEmail(cliente.getEmail());

        return clienteRepository.atualizarCliente(clienteBanco);
    }
}
