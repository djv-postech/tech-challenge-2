package com.fiap.postech.fastfoodsysteminfra.persistence.repository.converters;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.vo.CPF;
import com.fiap.postech.fastfoodsystemcore.domain.vo.Email;
import com.fiap.postech.fastfoodsysteminfra.persistence.repository.entity.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {

    public Cliente convertFrom(ClienteEntity clienteEntity){
        return new Cliente(clienteEntity.getNome(), new CPF(clienteEntity.getCpf()), new Email(clienteEntity.getEmail()));
    }

}
