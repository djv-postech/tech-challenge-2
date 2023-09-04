package com.fiap.postech.fastfoodsystemcore.domain.usecases.produto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

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
class CadastroDeProdutoTest {

  @InjectMocks private CadastroDeProduto cadastrarProduto;
  @Mock private ProdutoRepository produtoRepository;

  @DisplayName("Test - Cadastro de produto")
  @Test
  public void dadoProduto_QuandoCadastrarProduto_EntaoRetornaProdutoCadastrado() {
    // Dado
    Produto produto =
        new Produto(
            "1", "big mac", "pao, hamburguer e queijo", new BigDecimal("1"), 3, Categoria.LANCHE);

    given(produtoRepository.listarProdutoPorNome(produto.getNome())).willReturn(null);

    given(produtoRepository.cadastrarProduto(produto)).willReturn(produto);

    // Quando
    Produto produtoCadastrado = cadastrarProduto.cadastrar(produto);

    // Entao
    Assertions.assertThat(produtoCadastrado).isNotNull();
  }

  @DisplayName("Test - Lança exceção ao tentar cadastrar produto já existente")
  @Test
  public void dadoProdutoJaCadastrado_QuandoTentarCadastrar_EntaoLancaException() {

    // Dado
    Produto produto =
        new Produto(
            "1", "big mac", "pao, hamburguer e queijo", new BigDecimal("1"), 3, Categoria.LANCHE);

    given(produtoRepository.listarProdutoPorNome(produto.getNome())).willReturn(produto);

    // Quando
    org.junit.jupiter.api.Assertions.assertThrows(
        RuntimeException.class, () -> cadastrarProduto.cadastrar(produto));

    // Entao
    verify(produtoRepository, never()).cadastrarProduto(any(Produto.class));
  }
}
