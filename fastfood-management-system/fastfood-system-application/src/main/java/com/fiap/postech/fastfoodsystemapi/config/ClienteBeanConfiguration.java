package com.fiap.postech.fastfoodsystemapi.config;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente.CadastrarCliente;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente.ListarClientes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBeanConfiguration {

    private final ClienteRepository clienteRepository;

    public  ClienteBeanConfiguration(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Bean
    public CadastrarCliente cadastrarCliente(){
        return new CadastrarCliente(clienteRepository);
    }

    @Bean
    public ListarClientes listarClientes(){
        return new ListarClientes(clienteRepository);
    }

}
