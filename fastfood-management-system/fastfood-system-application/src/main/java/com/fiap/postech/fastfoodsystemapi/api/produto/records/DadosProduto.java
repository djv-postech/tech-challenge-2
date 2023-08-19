package com.fiap.postech.fastfoodsystemapi.api.produto.records;

import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Categoria;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import java.math.BigDecimal;

public record DadosProduto(String id, String nome, String descricao, BigDecimal preco, Categoria produtoCategoria,
                           Integer quantidade) {

    public DadosProduto(Produto dadosProduto) {
        this(dadosProduto.getId(), dadosProduto.getNome(), dadosProduto.getDescricao(),
                dadosProduto.getPreco(), dadosProduto.getCategoria(), dadosProduto.getQuantidade());
    }
}
