package com.fiap.postech.fastfoodsystemcore.domain.usecases.produto;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;

public class IdentificacaoDeProduto {

    private final ClienteRepository clienteRepository;

    public IdentificacaoDeProduto(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente identificarPorCpf(String cpf){
        return clienteRepository.identificaClientePorCpf(cpf);
    }
}
