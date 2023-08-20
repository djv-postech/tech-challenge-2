package com.fiap.postech.fastfoodsysteminfra.persistence.repository;

import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Categoria;
import com.fiap.postech.fastfoodsysteminfra.persistence.repository.entity.ProdutoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProdutoRepositoryMongo extends MongoRepository<ProdutoEntity, String> {

    List<ProdutoEntity> findByCategoria(Categoria categoria);

    Optional<ProdutoEntity> findByNome(String nome);
}
