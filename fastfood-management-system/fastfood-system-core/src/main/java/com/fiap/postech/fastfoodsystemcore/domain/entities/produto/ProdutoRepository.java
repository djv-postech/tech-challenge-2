package com.fiap.postech.fastfoodsystemcore.domain.entities.produto;

import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.Pedido;
import com.fiap.postech.fastfoodsystemcore.domain.entities.pedido.StatusPedido;

import java.util.List;

public interface ProdutoRepository {

    Produto cadastrarProduto(Produto produto);

    Produto listarProdutoPorId(String id);

    Produto atualizarProduto(Produto produto);

    void removerProduto(String id);

    List<Produto> listarProdutos();

    List<Produto> listaProdutosPorCategoria(Categoria categoria);

    Produto listarProdutoPorNome(String nome);
}
