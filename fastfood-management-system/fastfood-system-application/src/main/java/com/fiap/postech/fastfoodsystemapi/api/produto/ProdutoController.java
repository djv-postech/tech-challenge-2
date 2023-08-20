package com.fiap.postech.fastfoodsystemapi.api.produto;

import com.fiap.postech.fastfoodsystemapi.api.produto.records.DadosCadastroProduto;
import com.fiap.postech.fastfoodsystemapi.api.produto.records.DadosProduto;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Categoria;
import com.fiap.postech.fastfoodsystemcore.domain.entities.produto.Produto;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.produto.AtualizacaoDeProduto;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.produto.CadastroDeProduto;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.produto.ExclusaoDeProduto;
import com.fiap.postech.fastfoodsystemcore.domain.usecases.produto.ListagemDeProduto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
@Tag(name = "Produtos", description = "Rest api para operações de produtos")
public class ProdutoController {

    private final CadastroDeProduto cadastrarProduto;
    private final ListagemDeProduto listagemDeProduto;
    private final AtualizacaoDeProduto atualizacaoDeProduto;
    private final ExclusaoDeProduto exclusaoDeProduto;

    @Operation(summary = "Cadastro de produto")
    @PostMapping
    public ResponseEntity<DadosProduto> cadastrarProduto(@Valid @RequestBody DadosCadastroProduto dadosCadastroProduto){

        Produto produtoCadastrado = cadastrarProduto.cadastrar(new Produto(dadosCadastroProduto.nome(),
                dadosCadastroProduto.descricao(), dadosCadastroProduto.categoria(), dadosCadastroProduto.preco(),
                dadosCadastroProduto.quantidade()));

        DadosProduto dadosProduto = new DadosProduto(produtoCadastrado);
         return ResponseEntity.ok().body(dadosProduto);
    }


    @Operation(summary = "Listagem de produto por Id")
    @GetMapping("/{id}")
    public ResponseEntity<DadosProduto> listarProduto(@PathVariable String id){
        Produto produto = listagemDeProduto.listarProdutoPorId(id);

        return Objects.nonNull(produto) ? ResponseEntity.ok(new DadosProduto(produto)):
               ResponseEntity.notFound().build();
    }

    @Operation(summary = "Atualização de produto")
    @PutMapping("/{id}")
    public ResponseEntity<DadosProduto> atualizarProduto(@PathVariable String id, @Valid @RequestBody DadosCadastroProduto dadosCadastroProduto){
        Produto produto = atualizacaoDeProduto.atualizarDadosProduto(id, new Produto(dadosCadastroProduto.nome(),
                dadosCadastroProduto.descricao(), dadosCadastroProduto.categoria(), dadosCadastroProduto.preco(),
                dadosCadastroProduto.quantidade()));
        return ResponseEntity.ok(new DadosProduto(produto));
    }

    @Operation(summary = "Remoção de produto do catalogo")
    @DeleteMapping("/{id}")
    public ResponseEntity<DadosProduto> removerProdutoDoCatalogo(@PathVariable String id){
        exclusaoDeProduto.removerProdutoDoCatalogo(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Listagem de todos os produtos")
    @GetMapping("/todos")
    public ResponseEntity<List<DadosProduto>> listarProdutos(){
        List<Produto> produtos = listagemDeProduto.listarTodosOsProdutos();
        return Objects.nonNull(produtos) ? ResponseEntity.ok(produtos.stream()
                .map(DadosProduto::new).collect(Collectors.toList())):
                ResponseEntity.notFound().build();
    }


    @Operation(summary = "Listagem de produtos por categoria")
    @GetMapping
    public ResponseEntity<List<DadosProduto>> listarProdutosPorCategoria(@RequestParam("categoria") final
                                                                         Categoria categoria){
        List<Produto> produtos = listagemDeProduto.listaProdutosPorCategoria(categoria);
        return Objects.nonNull(produtos) ? ResponseEntity.ok(produtos.stream()
                .map(DadosProduto::new).collect(Collectors.toList())):
                ResponseEntity.notFound().build();
    }


}
