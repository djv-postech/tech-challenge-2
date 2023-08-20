package com.fiap.postech.fastfoodsystemcore.domain.usecases.produto;

import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.Cliente;
import com.fiap.postech.fastfoodsystemcore.domain.entities.cliente.ClienteRepository;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.ProdutoRepository;

import java.util.Objects;
import java.util.Properties;

public class AtualizacaoDeProduto {

    private final ProdutoRepository produtoRepository;

    public AtualizacaoDeProduto(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public Produto atualizarDadosProduto(String id, Produto produto) {
        Produto produtoBanco = produtoRepository.listarProdutoPorId(id);

        if (Objects.isNull(produtoBanco)) {
            throw new RuntimeException("Produto não encontrado - id: " + id);
        }

        produtoBanco.setNome(produto.getNome());
        produtoBanco.setDescricao(produto.getDescricao());
        produtoBanco.setPreco(produto.getPreco());
        produtoBanco.setCategoria(produto.getCategoria());
        produtoBanco.setQuantidade(produto.getQuantidade());

        return produtoRepository.atualizarProduto(produtoBanco);
    }
}
