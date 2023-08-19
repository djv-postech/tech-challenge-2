package com.fiap.postech.fastfoodsystemapi.config;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.PedidoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.pedido.CadastroDePedido;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoBeanConfiguration {

    private final PedidoRepository pedidoRepository;

    public  PedidoBeanConfiguration(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    @Bean
    public CadastroDePedido cadastroDePedido(){
        return new CadastroDePedido(pedidoRepository);
    }

}
