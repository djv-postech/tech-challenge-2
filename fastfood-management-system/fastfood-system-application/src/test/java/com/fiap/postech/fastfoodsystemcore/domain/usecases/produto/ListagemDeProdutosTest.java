package com.fiap.postech.fastfoodsystemcore.domain.usecases.produto;

import static org.mockito.BDDMockito.given;

import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Categoria;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.ProdutoRepository;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListagemDeProdutosTest {

  @InjectMocks private ListagemDeProdutos listagemDeProdutos;
  @Mock
  private ProdutoRepository produtoRepository;

  @DisplayName("Test - Deve retornar todos os produtos cadastrados")
  @Test
  public void dadoListaDeProdutos_QuandoListarProdutos_EntaoRetornaListaDeProdutosCadastrados(){

    //Dado
    Produto produto = new Produto(
        "1", "big mac", "pao, hamburguer e queijo",
        new BigDecimal("1"), 3, Categoria.LANCHE);

    Produto produto2 = new Produto(
        "1", "big tasty", "pao, hamburguer e queijo e molho",
        new BigDecimal("5"), 3, Categoria.LANCHE);


    given(produtoRepository.listarProdutos()).willReturn(List.of(produto, produto2));


    //Quando
    List<Produto> listaProdutos = listagemDeProdutos.listarTodosOsProdutos();

    //Entao
    Assertions.assertThat(listaProdutos).isNotNull();
    Assertions.assertThat(listaProdutos.size()).isEqualTo(2);

  }

  @DisplayName("Test - Deve retornar lista de produtos vazia")
  @Test
  public void dadoListaVazia_QuandoListarProdutos_EntaoDeveRetornarListaDeProdutosVazia(){
   //Dado
    given(produtoRepository.listarProdutos()).willReturn(Collections.emptyList());

    //Quando
    List<Produto> listaProdutos = listagemDeProdutos.listarTodosOsProdutos();

    //Entao
    Assertions.assertThat(listaProdutos).isEmpty();

  }
}