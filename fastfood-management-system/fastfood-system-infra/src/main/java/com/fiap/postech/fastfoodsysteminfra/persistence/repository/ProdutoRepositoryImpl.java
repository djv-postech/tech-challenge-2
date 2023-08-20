package com.fiap.postech.fastfoodsysteminfra.persistence.repository;

import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Categoria;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.ProdutoRepository;
import com.fiap.postech.fastfoodsysteminfra.persistence.exception.ProdutoNaoEncontradoException;
import com.fiap.postech.fastfoodsysteminfra.persistence.repository.converters.ProdutoConverter;
import com.fiap.postech.fastfoodsysteminfra.persistence.repository.entity.ProdutoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoRepositoryMongo produtoRepositoryMongo;
    private final ProdutoConverter produtoConverter;

    @Override
    public Produto cadastrarProduto(Produto produto) {
        ProdutoEntity produtoEntity = produtoRepositoryMongo.insert(ProdutoEntity.from(produto));
        return produtoConverter.convertFrom(produtoEntity);
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepositoryMongo.findAll()
                .stream()
                .map(produtoConverter::convertFrom)
                .collect(Collectors.toList());
    }


    @Override
    public Produto listarProdutoPorNome(String nome) {
        return produtoRepositoryMongo.findByNome(nome)
                .map(produtoConverter::convertFrom)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto: "+ nome +" não encontrado"));
    }

    @Override
    public Produto listarProdutoPorId(String id) {
        return produtoRepositoryMongo.findById(id)
                .map(produtoConverter::convertFrom)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto de Id: "+ id +" não encontrado"));
    }

    @Override
    public void removerProduto(String id) {
        produtoRepositoryMongo.deleteById(id);
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        ProdutoEntity produtoEntity = produtoRepositoryMongo.insert(ProdutoEntity.from(produto));
        return produtoConverter.convertFrom(produtoEntity);
    }

    @Override
    public List<Produto> listaProdutosPorCategoria(Categoria categoria) {
        return produtoRepositoryMongo.findByCategoria(categoria).stream()
                .map(produtoConverter::convertFrom)
                .collect(Collectors.toList());
    }
}