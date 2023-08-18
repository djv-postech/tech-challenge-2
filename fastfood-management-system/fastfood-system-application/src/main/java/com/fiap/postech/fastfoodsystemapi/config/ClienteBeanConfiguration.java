package com.fiap.postech.fastfoodsystemapi.config;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente.CadastroDeCliente;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente.ListagemDeCliente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBeanConfiguration {

    private final ClienteRepository clienteRepository;

    public  ClienteBeanConfiguration(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Bean
    public CadastroDeCliente cadastrarCliente(){
        return new CadastroDeCliente(clienteRepository);
    }

    @Bean
    public ListagemDeCliente listarClientes(){
        return new ListagemDeCliente(clienteRepository);
    }

}
