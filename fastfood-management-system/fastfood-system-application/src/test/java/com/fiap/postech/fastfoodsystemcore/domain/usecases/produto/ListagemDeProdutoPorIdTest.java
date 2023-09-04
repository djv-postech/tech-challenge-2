package com.fiap.postech.fastfoodsystemcore.domain.usecases.produto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Categoria;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.ProdutoRepository;
import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListagemDeProdutoPorIdTest {
  @InjectMocks
  private ListagemDeProdutoPorId listagemDeProdutoPorId;
  @Mock
  private ProdutoRepository produtoRepository;

  @DisplayName("Test - Deve retornar produto pelo id")
  @Test
  public void dadoId_QuandoRetornarProdutoPorId_EntaoDeveRetornarProduto(){
    Produto produto = new Produto(
        "1", "big mac", "pao, hamburguer e queijo",
        new BigDecimal("1"), 3, Categoria.LANCHE);

    given(produtoRepository.listarProdutoPorId("1")).willReturn(produto);

    //Quando
    Produto produtoRetornado = listagemDeProdutoPorId.listarProdutoPorId(produto.getId());

    //Entao
    Assertions.assertThat(produtoRetornado).isNotNull();
    Assertions.assertThat(produtoRetornado.getId()).isEqualTo(produto.getId());

  }
}
