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
class AtualizacaoDeProdutoTest {
  @InjectMocks private AtualizacaoDeProduto atualizacaoDeProduto;

  @Mock private ProdutoRepository produtoRepository;

  @DisplayName("Test - Deve atualizar produto")
  @Test
  public void dadoID_deveAtualizarERetornarProdutoAtualizado() {
    // Dado
    final String idProduto = "1";
    final Produto produto =
        new Produto(
            "1", "big mac", "pao, hamburguer e queijo", new BigDecimal("1"), 3, Categoria.LANCHE);

    given(produtoRepository.listarProdutoPorId(idProduto)).willReturn(produto);
    given(produtoRepository.atualizarProduto(produto)).willReturn(produto);

    // Quando
    Produto produtoAtualizado = atualizacaoDeProduto.atualizarDadosProduto(idProduto, produto);

    // Entao
    Assertions.assertThat(produtoAtualizado).isNotNull();
    Assertions.assertThat(produtoAtualizado.getPreco()).isEqualTo(produto.getPreco());
  }
}
