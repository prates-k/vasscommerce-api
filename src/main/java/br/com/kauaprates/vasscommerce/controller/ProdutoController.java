package br.com.kauaprates.vasscommerce.controller;

import br.com.kauaprates.vasscommerce.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/produto", produces = "application/json")
public class ProdutoController {

    private final List<Produto> produtos = new ArrayList<>();

    public ProdutoController() {
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

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}