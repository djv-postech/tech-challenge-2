package com.fiap.postech.fastfoodsysteminfra.persistence.repository;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;
import com.fiap.postech.fastfoodsysteminfra.persistence.repository.converters.ClienteConverter;
import com.fiap.postech.fastfoodsysteminfra.persistence.repository.entity.ClienteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteRepositoryMongo clienteRepositoryMongo;
    private final ClienteConverter clienteConverter;

    @Override
    public void cadastrarCliente(Cliente cliente) {
        ClienteEntity clienteEntity = clienteRepositoryMongo.save(ClienteEntity.from(cliente));

    }

    @Override
    public Cliente retornarClientePorCpf(String CPF) {
        return null;
    }

    @Override
    public void removerCliente(String CPF) {

    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        return null;
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositoryMongo.findAll()
                .stream()
                .map(clienteConverter::convertFrom)
                .collect(Collectors.toList());
    }
}
