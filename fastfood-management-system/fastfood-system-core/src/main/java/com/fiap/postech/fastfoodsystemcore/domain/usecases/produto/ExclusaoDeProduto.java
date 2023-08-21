package com.fiap.postech.fastfoodsystemcore.domain.usecases.produto;

import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.ProdutoRepository;

public class ExclusaoDeProduto {
    private final ProdutoRepository produtoRepository;

    public ExclusaoDeProduto(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public void removerProdutoDoCatalogo(String id) {
        produtoRepository.removerProduto(id);
    }
}
