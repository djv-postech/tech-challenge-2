package com.fiap.postech.fastfoodsystemcore.domain.usecases.produto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Categoria;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.ProdutoRepository;
import java.util.List;

public class ListagemDeProdutosPorCategoria {

    private final ProdutoRepository produtoRepository;

    public ListagemDeProdutosPorCategoria(ProdutoRepository clienteRepository) {
        this.produtoRepository = clienteRepository;
    }

    public List<Produto> listaProdutosPorCategoria(Categoria categoria) {
        return produtoRepository.listaProdutosPorCategoria(categoria);
    }
}
