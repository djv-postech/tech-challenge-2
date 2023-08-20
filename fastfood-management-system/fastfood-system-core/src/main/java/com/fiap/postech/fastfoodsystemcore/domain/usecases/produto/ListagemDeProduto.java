package com.fiap.postech.fastfoodsystemcore.domain.usecases.produto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Categoria;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.ProdutoRepository;

import java.util.List;
import java.util.Objects;

public class ListagemDeProduto {

    private final ProdutoRepository produtoRepository;

    public ListagemDeProduto(ProdutoRepository clienteRepository) {
        this.produtoRepository = clienteRepository;
    }

    public Produto listarProdutoPorId(String id) {
        Produto dadosProduto = produtoRepository.listarProdutoPorId(id);
        return (Objects.isNull(dadosProduto) ? null : dadosProduto);
    }

    public List<Produto> listarTodosOsProdutos() {
        return produtoRepository.listarProdutos();
    }

    public List<Produto> listaProdutosPorCategoria(Categoria categoria) {
        return produtoRepository.listaProdutosPorCategoria(categoria);
    }
}
