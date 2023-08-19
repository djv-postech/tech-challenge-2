package com.fiap.postech.fastfoodsystemapi.api.produto.records;

import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Categoria;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record DadosCadastroProduto(
        @NotBlank
        String nome,

        @NotBlank
        String descricao,

        @NotNull
        BigDecimal preco,

        @NotNull
        Integer quantidade,

        @NotNull
        Categoria categoria)  {

        public List<Produto> convertToProduto(DadosCadastroProduto dadosCadastroProduto){
                return null;
        }
}
