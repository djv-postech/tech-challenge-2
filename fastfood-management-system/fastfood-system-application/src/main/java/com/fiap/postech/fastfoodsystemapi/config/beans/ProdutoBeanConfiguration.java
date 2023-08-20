package com.fiap.postech.fastfoodsystemapi.config.beans;

import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.ProdutoRepository;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.produto.AtualizacaoDeProduto;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.produto.CadastroDeProduto;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.produto.ExclusaoDeProduto;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.produto.ListagemDeProduto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoBeanConfiguration {

    private final ProdutoRepository produtoRepository;

    public ProdutoBeanConfiguration(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @Bean
    public CadastroDeProduto cadastroDeProduto(){
        return new CadastroDeProduto(produtoRepository);
    }

    @Bean
    public ListagemDeProduto listagemDeProduto(){
        return new ListagemDeProduto(produtoRepository);
    }

    @Bean
    public AtualizacaoDeProduto atualizacaoDeProduto(){
        return new AtualizacaoDeProduto(produtoRepository);
    }

    @Bean
    public ExclusaoDeProduto exclusaoDeProduto(){
        return new ExclusaoDeProduto(produtoRepository);
    }

}
