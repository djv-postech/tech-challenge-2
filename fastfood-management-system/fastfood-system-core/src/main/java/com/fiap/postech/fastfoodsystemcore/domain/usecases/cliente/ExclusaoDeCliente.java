package com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;

public class ExclusaoDeCliente {
    private final ClienteRepository clienteRepository;


    public ExclusaoDeCliente(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public void excluirPorCpf(String cpf) {
        clienteRepository.excluirClientePorCpf(cpf);
    }
}
