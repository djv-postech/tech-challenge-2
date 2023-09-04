package com.fiap.postech.fastfoodsystemcore.domain.usecases.produto;

import static org.mockito.BDDMockito.given;

import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Categoria;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.ProdutoRepository;
import java.math.BigDecimal;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListagemDeProdutosPorCategoriaTest {
  @InjectMocks
  private ListagemDeProdutosPorCategoria listagemDeProdutosPorCategoria;
  @Mock
  private ProdutoRepository produtoRepository;

  @DisplayName("Test - Deve retornar produto pela categoria")
  @Test
  public void dadoId_QuandoRetornarProdutoPorId_EntaoDeveRetornarProduto(){
   Categoria categoria = Categoria.LANCHE;
    Produto produto = new Produto(
        "1", "big mac", "pao, hamburguer e queijo",
        new BigDecimal("1"), 3, Categoria.LANCHE);

    given(produtoRepository.listaProdutosPorCategoria(categoria)).willReturn(List.of(produto));

    //Quando
    List<Produto> produtosRetornados = listagemDeProdutosPorCategoria.listaProdutosPorCategoria(categoria);

    //Entao
    Assertions.assertThat(produtosRetornados).isNotNull();
    Assertions.assertThat(produtosRetornados.get(0).getCategoria()).isEqualTo(categoria);
  }
}
