package com.fiap.postech.fastfoodsystemcore.domain.usecases.produto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.ProdutoRepository;
import java.util.List;

public class ListagemDeProdutos {

    private final ProdutoRepository produtoRepository;

    public ListagemDeProdutos(ProdutoRepository clienteRepository) {
        this.produtoRepository = clienteRepository;
    }

    public List<Produto> listarTodosOsProdutos() {
        return produtoRepository.listarProdutos();
    }

}
