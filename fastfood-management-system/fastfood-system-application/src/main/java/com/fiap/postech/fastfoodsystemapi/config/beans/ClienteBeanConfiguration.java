package com.fiap.postech.fastfoodsystemapi.config.beans;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.cliente.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBeanConfiguration {

    private final ClienteRepository clienteRepository;

    public  ClienteBeanConfiguration(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Bean
    public CadastroDeCliente cadastroDeCliente(){
        return new CadastroDeCliente(clienteRepository);
    }

    @Bean
    public ListagemDeCliente listagemDeClientes(){
        return new ListagemDeCliente(clienteRepository);
    }

    @Bean
    public IdentificacaoDeCliente identificacaoDeCliente(){
        return new IdentificacaoDeCliente(clienteRepository);
    }

    @Bean
    public AtualizacaoDeCliente AtualizacaoDeCliente(){
        return new AtualizacaoDeCliente(clienteRepository);
    }

    @Bean
    public ExclusaoDeCliente exclusaoDeClientes(){
        return new ExclusaoDeCliente(clienteRepository);
    }

}
