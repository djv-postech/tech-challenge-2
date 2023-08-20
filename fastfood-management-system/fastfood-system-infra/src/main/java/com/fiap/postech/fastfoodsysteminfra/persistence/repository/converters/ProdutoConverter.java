package com.fiap.postech.fastfoodsysteminfra.persistence.repository.converters;

import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsysteminfra.persistence.repository.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConverter {

    public Produto convertFrom(ProdutoEntity produtoEntity){
        return new Produto(produtoEntity.getId(), produtoEntity.getNome(), produtoEntity.getDescricao(), produtoEntity.getPreco(),
                produtoEntity.getQuantidade(), produtoEntity.getCategoria());
    }
}
