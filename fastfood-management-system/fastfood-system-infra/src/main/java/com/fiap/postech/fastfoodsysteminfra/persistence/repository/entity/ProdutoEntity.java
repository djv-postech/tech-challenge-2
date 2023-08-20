package com.fiap.postech.fastfoodsysteminfra.persistence.repository.entity;

import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Categoria;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Builder
@Document(collection = "produtos")
public class ProdutoEntity {

  @Id private String id;

  private String nome;
  private String descricao;
  private BigDecimal preco;
  private Integer quantidade;
  private Categoria categoria;

  public ProdutoEntity(
      String id,
      String nome,
      String descricao,
      BigDecimal preco,
      Integer quantidade,
      Categoria categoria) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.quantidade = quantidade;
    this.categoria = categoria;
  }

  public ProdutoEntity(
          String nome,
          String descricao,
          BigDecimal preco,
          Integer quantidade,
          Categoria categoria) {
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.quantidade = quantidade;
    this.categoria = categoria;
  }

  public ProdutoEntity() {}

  public static ProdutoEntity from(Produto produto) {
    return new ProdutoEntity(produto.getNome(), produto.getDescricao(),produto.getPreco(), produto.getQuantidade(), produto.getCategoria());
  }

  public String getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public Categoria getCategoria() {
    return categoria;
  }
}
