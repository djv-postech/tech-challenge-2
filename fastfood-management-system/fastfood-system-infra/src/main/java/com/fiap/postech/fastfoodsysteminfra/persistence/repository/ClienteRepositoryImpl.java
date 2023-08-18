package com.fiap.postech.fastfoodsysteminfra.persistence.repository;

import com.fiap.postech.fastfoodsystemcore.domain.ClienteNaoEncontradoException;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;
import com.fiap.postech.fastfoodsysteminfra.persistence.repository.converters.ClienteConverter;
import com.fiap.postech.fastfoodsysteminfra.persistence.repository.entity.ClienteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteRepositoryMongo clienteRepositoryMongo;
    private final ClienteConverter clienteConverter;

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        try {
            ClienteEntity clienteEntity = clienteRepositoryMongo.save(ClienteEntity.from(cliente));
            return clienteConverter.convertFrom(clienteEntity);
        }catch (Exception e) {
            throw new RuntimeException(
                    "Cliente de CPF: " + cliente.getCpf() + "já cadastrado");
        }
    }

    @Override
    public Cliente identificaClientePorCpf(String cpf) {
        Optional<ClienteEntity> clienteEntity = clienteRepositoryMongo.findByCpf(cpf);
        return clienteEntity.map(clienteConverter::convertFrom).orElseThrow(
                () -> new ClienteNaoEncontradoException("Cliente de CPF: " + cpf + " não encontrado"));
    }


    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        ClienteEntity clienteEntity = clienteRepositoryMongo.save(ClienteEntity.from(cliente));
        return clienteConverter.convertFrom(clienteEntity);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositoryMongo.findAll()
                .stream()
                .map(clienteConverter::convertFrom)
                .collect(Collectors.toList());
    }

    @Override
    public void excluirClientePorCpf(String cpf) {
        this.clienteRepositoryMongo.deleteById(cpf);
    }
}
