package com.fiap.postech.fastfoodsystemcore.domain.usecases.produto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.ProdutoRepository;
import java.util.Objects;

public class ListagemDeProdutoPorId {

    private final ProdutoRepository produtoRepository;

    public ListagemDeProdutoPorId(ProdutoRepository clienteRepository) {
        this.produtoRepository = clienteRepository;
    }

    public Produto listarProdutoPorId(String id) {
        Produto dadosProduto = produtoRepository.listarProdutoPorId(id);
        return (Objects.isNull(dadosProduto) ? null : dadosProduto);
    }

}
