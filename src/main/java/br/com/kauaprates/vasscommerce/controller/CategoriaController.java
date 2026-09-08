package br.com.kauaprates.vasscommerce.controller;

import br.com.kauaprates.vasscommerce.model.Categoria;
import br.com.kauaprates.vasscommerce.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/categoria", produces = "application/json")
public class CategoriaController {

    private final List<Categoria> categorias = new ArrayList<>();
    private final List<Produto> produtos = new ArrayList<>();

    public CategoriaController() {
        categorias.add(new Categoria(1L, "img/livros.png", "Livros", "Livros em geral"));
        categorias.add(new Categoria(2L, "img/eletronicos.png", "Eletrônicos", "Eletrônicos diversos"));

        produtos.add(new Produto(1L, "Domain-Driven Design", "Livro sobre DDD", "foto1.jpg",
                LocalDateTime.of(2026, 1, 10, 9, 0), LocalDateTime.of(2026, 1, 10, 9, 0),
                new BigDecimal("120.00"), 1L));
        produtos.add(new Produto(2L, "Clean Code", "Livro sobre código limpo", "foto2.jpg",
                LocalDateTime.of(2026, 1, 12, 9, 0), LocalDateTime.of(2026, 1, 12, 9, 0),
                new BigDecimal("95.00"), 1L));
        produtos.add(new Produto(3L, "Fone Bluetooth", "Fone sem fio", "foto3.jpg",
                LocalDateTime.of(2026, 2, 1, 9, 0), LocalDateTime.of(2026, 2, 1, 9, 0),
                new BigDecimal("199.90"), 2L));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listar(
            @RequestParam(name = "nome", required = false) String nome) {

        if (nome == null || nome.isBlank()) {
            return ResponseEntity.ok(categorias);
        }

        List<Categoria> filtradas = new ArrayList<>();
        for (Categoria categoria : categorias) {
            if (categoria.getNome().toLowerCase().contains(nome.toLowerCase())) {
                filtradas.add(categoria);
            }
        }

        return ResponseEntity.ok(filtradas);
    }

    @GetMapping("/{idcategoria}/produto")
    public ResponseEntity<List<Produto>> listarProdutosDaCategoria(
            @PathVariable Long idcategoria,
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "valorMinimo", required = false) BigDecimal valorMinimo,
            @RequestParam(name = "valorMaximo", required = false) BigDecimal valorMaximo) {

        boolean categoriaExiste = categorias.stream().anyMatch(c -> c.getId().equals(idcategoria));
        if (!categoriaExiste) {
            return ResponseEntity.notFound().build();
        }

        List<Produto> filtrados = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.getIdCategoria().equals(idcategoria)) {
                boolean atendeFiltro = true;

                if (nome != null && !nome.isBlank()) {
                    if (!produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                        atendeFiltro = false;
                    }
                }

                if (valorMinimo != null) {
                    if (produto.getValorUnitario().compareTo(valorMinimo) < 0) {
                        atendeFiltro = false;
                    }
                }

                if (valorMaximo != null) {
                    if (produto.getValorUnitario().compareTo(valorMaximo) > 0) {
                        atendeFiltro = false;
                    }
                }

                if (atendeFiltro) {
                    filtrados.add(produto);
                }
            }
        }

        return ResponseEntity.ok(filtrados);
    }
}