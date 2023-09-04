package com.fiap.postech.fastfoodsystemcore.domain.usecases.produto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.ProdutoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExclusaoDeProdutoTest {
  @InjectMocks private ExclusaoDeProduto exclusaoDeProduto;
  @Mock private ProdutoRepository produtoRepository;

  @DisplayName("Test - Deve remover produto por id")
  @Test
  public void dadoId_QuandoRemoverProduto_EntaoDeveRemoverProdutoDoBanco() {
    // Dado
    final String idPedido = "123";
    // Quando
    exclusaoDeProduto.removerProdutoDoCatalogo(idPedido);

    // Entao
    verify(produtoRepository, times(1)).removerProduto(anyString());
  }
}
