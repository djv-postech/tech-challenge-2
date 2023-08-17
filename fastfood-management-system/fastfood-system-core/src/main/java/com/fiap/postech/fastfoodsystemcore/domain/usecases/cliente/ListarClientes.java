package com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;

import java.util.List;

public class ListarClientes {

    private final ClienteRepository clienteRepository;

    public ListarClientes(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> todos() {
        return clienteRepository.listarClientes();
    }
}
