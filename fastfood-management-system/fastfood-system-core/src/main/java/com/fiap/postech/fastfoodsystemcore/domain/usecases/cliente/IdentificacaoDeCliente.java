package com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;

public class IdentificacaoDeCliente {

    private final ClienteRepository clienteRepository;

    public IdentificacaoDeCliente(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente identificarPorCpf(String cpf){
        return clienteRepository.identificaClientePorCpf(cpf);
    }
}
